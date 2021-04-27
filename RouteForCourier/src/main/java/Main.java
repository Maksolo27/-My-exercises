import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
        while (iterator.hasNext()) {
            Orders nearestOrder = courier.getNearestOrder(orderList);
            rightOrdersRouter.add(nearestOrder);
            double distanceToNextPoint = courier.distanceToNextPoint(rightOrdersRouter.get(i).getLaititude(), rightOrdersRouter.get(i).getLongitude());
            double currentWaiting = courier.parseTimeInMinutes(nearestOrder.getDelivery_from()) - courier.parseTimeInMinutes(courier.getWorkStart());
            waitingTime += currentWaiting;
            resultDistance += distanceToNextPoint;
            courier.moveToNextPoint(rightOrdersRouter.get(i).getLaititude(), rightOrdersRouter.get(i).getLongitude(), rightOrdersRouter.get(i).getDelivery_from());

            System.out.println(distanceToNextPoint);
            orderList.remove(nearestOrder);
            i++;
        }
        StringBuilder pointStringBuilder = new StringBuilder();
        for (Orders orders: rightOrdersRouter) {
            pointStringBuilder.append("[").append(orders.getId()).append("]").append("=>");
        }
        double timeInRoute = resultDistance / courier.getCourierSpeed();
        int resultTimeInRoute = (int) (timeInRoute * 60);
        System.out.println("Наименшое растояние: " + pointStringBuilder.append("[Finish]|") + " Растояние: " + (int) resultDistance + " километров |" + " Время в пути: " + resultTimeInRoute + " минут");

    }
}
