import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by maxim on 26.04.2021.
 */
public class Main {

    public static void main(String[] args) {
        OrderDB orderDB = new OrderDB();
        String jsonCourier = "{workStart: '10:00', workFinish: '20:00', delayTime: 10, courierSpeed: 50, startX: 50.300, startY: 30.350}";
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Courier courier = gson.fromJson(jsonCourier, Courier.class);
        List<Orders> orderList = orderDB.getOrderList();
        List<Orders> rightOrdersRouter = new ArrayList<Orders>();
        Iterator<Orders> iterator = orderList.iterator();
        int i = 0;
        double waitingTime = 0;
        double resultDistance = 0;
        double currentTime = courier.parseTimeInMinutes(courier.getWorkStart());
        List<Orders> unfulfilledOrders = new ArrayList<Orders>();
        while (iterator.hasNext()) {
            Orders nearestOrder = courier.getNearestOrder(orderList);
            rightOrdersRouter.add(nearestOrder);
            double distanceToNextPoint = 0;
            if(currentTime >= courier.parseTimeInMinutes(nearestOrder.getDelivery_from()) && currentTime <= courier.parseTimeInMinutes(nearestOrder.getDelivery_to())) {
                distanceToNextPoint = courier.distanceToNextPoint(rightOrdersRouter.get(i).getLaititude(), rightOrdersRouter.get(i).getLongitude());
                resultDistance += distanceToNextPoint;
                System.out.println(distanceToNextPoint);
                courier.moveToNextPoint(rightOrdersRouter.get(i).getLaititude(), rightOrdersRouter.get(i).getLongitude());
                orderList.remove(nearestOrder);
            }else if(currentTime <= courier.parseTimeInMinutes(nearestOrder.getDelivery_from())){
                distanceToNextPoint = courier.distanceToNextPoint(rightOrdersRouter.get(i).getLaititude(), rightOrdersRouter.get(i).getLongitude());
                waitingTime += courier.parseTimeInMinutes(nearestOrder.getDelivery_from()) - currentTime;
                currentTime = courier.parseTimeInMinutes(nearestOrder.getDelivery_from());
                resultDistance += distanceToNextPoint;
                System.out.println(distanceToNextPoint);
                courier.moveToNextPoint(rightOrdersRouter.get(i).getLaititude(), rightOrdersRouter.get(i).getLongitude());
                orderList.remove(nearestOrder);
            }else {
                unfulfilledOrders.add(nearestOrder);
                orderList.remove(nearestOrder);
            }
            i++;
        }
        for (int j = 0; j < unfulfilledOrders.size(); j++) {
            for (int k = 0; k < rightOrdersRouter.size(); k++) {
                if(unfulfilledOrders.get(j).equals(rightOrdersRouter.get(k))){
                    rightOrdersRouter.remove(unfulfilledOrders.get(j));
                }
            }
        }
        StringBuilder pointStringBuilder = new StringBuilder();
        for (Orders orders: rightOrdersRouter) {
            pointStringBuilder.append("[").append(orders.getId()).append("]").append("=>");
        }
        double timeInRoute = resultDistance / courier.getCourierSpeed();
        double resultTimeInRoute =  (timeInRoute * 60);
        System.out.println("Наименшое растояние: " + pointStringBuilder.append("[Finish]|") + " Растояние: " +  resultDistance + " километров |" + " Время в пути: " + courier.getTimeInNormalView(resultTimeInRoute)  + " |Время ожидания: " + courier.getTimeInNormalView(waitingTime));

    }
}
