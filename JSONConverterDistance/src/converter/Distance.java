package converter;

/**
 * Created by maxim on 21.04.2021.
 */
public class Distance {

    private String unit;
    private double value;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Distance{" +
                "unit='" + unit + '\'' +
                ", value=" + value +
                '}';
    }

    public Distance(String unit, double value) {
        this.unit = unit;
        this.value = value;
    }
}
