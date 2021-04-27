import javax.persistence.Transient;
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

    public double distanceToNextPoint(double x, double y){
        double distance = Math.sqrt(((x - this.startX)*(x - this.startX)) + ((y - this.startY)*(y - this.startY)));
        return distance;
    }

    public Orders getNearestOrder(List<Orders> ordersList){
        Map<Double, Orders> distanceOrderMap = new HashMap<Double, Orders>();
        double[] distances = new double[ordersList.size()];
        for (int i = 0; i < ordersList.size(); i++) {
            double distance =  distanceToNextPoint(ordersList.get(i).getLaititude(), ordersList.get(i).getLongitude());
            distances[i] = distance;
            distanceOrderMap.put(distance, ordersList.get(i));
        }
        Arrays.sort(distances);
        Orders nearestOrder;
        nearestOrder = distanceOrderMap.get(distances[0]);
        return nearestOrder;
    }

    public void moveToNextPoint(double x, double y){
        this.startX = x;
        this.startY = y;
    }

    public double timeToNextPoint(double x, double y){
        double distanceToNextPoint = distanceToNextPoint(x, y);
        double time = distanceToNextPoint / this.courierSpeed;
        return time;
    }

    public double parseTimeInMinutes(String time){
        String stringHours = "";
        String stringMinutes = "";
        for (int i = 0; i < time.length(); i++) {
            if(time.charAt(i) == ':'){
                for (int j = i + 1; j < time.length() ; j++) {
                    stringMinutes += time.charAt(j);
                }
                break;
            }
            stringHours += time.charAt(i);
        }
        int hours = Integer.valueOf(stringHours);
        int minutes = hours * 60 + Integer.valueOf(stringMinutes);
        return minutes;
    }

    public double getTimeInHours(double minutes){
        double result = minutes / 60.0;
        return result;
    }

    public String getTimeInNormalView(double minutes){
        String result = "";
        int hours = (int) (minutes / 60);
        int resultMinutes = (int) (minutes % 60);
        result += hours + ":" + resultMinutes;
        return result;
    }
    public double timeInWaiting(double time){
        return time;
    }
}
