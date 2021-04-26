import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

/**
 * Created by maxim on 26.04.2021.
 */
public class Main {

    public static void main(String[] args) {
        OrderDB orderDB = new OrderDB();
        String jsonCourier = "{workStart: '9:00', workFinish: '20:00', delayTime: 10, courierSpeed: 50, startX: 50.300, startY: 30.350}";
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Courier courier = gson.fromJson(jsonCourier, Courier.class);
        System.out.println(courier.toString());
        List<Orders> orderList = orderDB.getOrderList();
        for (int i = 0; i < orderList.size(); i++) {
            System.out.println(orderList.get(i).toString());
        }
        System.out.println("-------------");
        Orders nearestOrder = courier.getNearestOrder(orderList);
        System.out.println(nearestOrder.toString());
    }
}
