import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by maxim on 26.04.2021.
 */
public class Courier {

    //"workStart: '9:00', workFinish: '20:00', delayTime: 10, courierSpeed: 50, startX: 50.300, startY: 30.350"

    private String workStart;
    private String workFinish;
    private int delayTime;
    private int courierSpeed;
    private double startX;
    private double startY;

    public Courier(String workStart, String workFinish, int delayTime, int courierSpeed, double startX, double startY) {
        this.workStart = workStart;
        this.workFinish = workFinish;
        this.delayTime = delayTime;
        this.courierSpeed = courierSpeed;
        this.startX = startX;
        this.startY = startY;
    }

    public String getWorkStart() {
        return workStart;
    }

    public void setWorkStart(String workStart) {
        this.workStart = workStart;
    }

    public String getWorkFinish() {
        return workFinish;
    }

    public void setWorkFinish(String workFinish) {
        this.workFinish = workFinish;
    }

    public int getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(int delayTime) {
        this.delayTime = delayTime;
    }

    public int getCourierSpeed() {
        return courierSpeed;
    }

    public void setCourierSpeed(int courierSpeed) {
        this.courierSpeed = courierSpeed;
    }

    public double getStartX() {
        return startX;
    }

    public void setStartX(double startX) {
        this.startX = startX;
    }

    public double getStartY() {
        return startY;
    }

    public void setStartY(double startY) {
        this.startY = startY;
    }

    @Override
    public String toString() {
        return "Courier{" +
                "workStart='" + workStart + '\'' +
                ", workFinish='" + workFinish + '\'' +
                ", delayTime=" + delayTime +
                ", courierSpeed=" + courierSpeed +
                ", startX=" + startX +
        ", startY=" + startY +
                '}';
    }

    private double distanceToNextPoint(double x, double y){
        double distance = Math.sqrt(((x - this.startX)*(x - this.startX)) + ((y - this.startY)*(y - this.startY)));
        return distance;
    }

    public Orders getNearestOrder(List<Orders> ordersList){
        Map<Double, Orders> distanceOrderMap = new HashMap<Double, Orders>();
        double[] distances = new double[ordersList.size()];
        for (int i = 0; i < ordersList.size(); i++) {
            double distance =  distanceToNextPoint(ordersList.get(i).getLaititude(), ordersList.get(i).getLongitude());
            System.out.println(ordersList.get(i));
            System.out.println(distance);
            distances[i] = distance;
            distanceOrderMap.put(distance, ordersList.get(i));
        }
        System.out.println("----------");
        Arrays.sort(distances);
        Orders nearestOrder = null;
        for (int i = distances.length - 1; i >= 0; i--) {
            System.out.println(distances[i]);
            nearestOrder = distanceOrderMap.get(distances[i]);
            System.out.println(distanceOrderMap.get(distances[i]));
        }

        return nearestOrder;
    }
}
