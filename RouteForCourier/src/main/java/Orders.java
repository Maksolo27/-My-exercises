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
