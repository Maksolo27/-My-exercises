import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by maxim on 26.04.2021.
 */
@Entity
public class Orders {

    @Id
    private int id;
    private double laititude;
    private double longitude;
    private String delivery_from;
    private String delivery_to;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLaititude() {
        return laititude;
    }

    public void setLaititude(double laititude) {
        this.laititude = laititude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getDelivery_from() {
        return delivery_from;
    }

    public void setDelivery_from(String delivery_from) {
        this.delivery_from = delivery_from;
    }

    public String getDelivery_to() {
        return delivery_to;
    }

    public void setDelivery_to(String delivery_to) {
        this.delivery_to = delivery_to;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", laititude=" + laititude +
                ", longitude=" + longitude +
                ", delivery_from='" + delivery_from + '\'' +
                ", delivery_to='" + delivery_to + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (id != orders.id) return false;
        if (Double.compare(orders.laititude, laititude) != 0) return false;
        if (Double.compare(orders.longitude, longitude) != 0) return false;
        if (delivery_from != null ? !delivery_from.equals(orders.delivery_from) : orders.delivery_from != null)
            return false;
        return delivery_to != null ? delivery_to.equals(orders.delivery_to) : orders.delivery_to == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        temp = Double.doubleToLongBits(laititude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (delivery_from != null ? delivery_from.hashCode() : 0);
        result = 31 * result + (delivery_to != null ? delivery_to.hashCode() : 0);
        return result;
    }

    public Orders(int id, double laititude, double longitude, String delivery_from, String delivery_to) {
        this.id = id;
        this.laititude = laititude;
        this.longitude = longitude;
        this.delivery_from = delivery_from;
        this.delivery_to = delivery_to;
    }

    public Orders() {

    }

}
