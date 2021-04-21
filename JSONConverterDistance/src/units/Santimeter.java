package units;

/**
 * Created by maxim on 21.04.2021.
 */
public class Santimeter implements UnitConverter {
    private static final double toMeter = 0.01;
    private static final double toFoot = 0.03280;
    private static final double toInch = 0.397;

    @Override
    public double convert(String convert, double value) {
        switch (convert){
            case "ft":
                return value * toFoot;
            case "in":
                return value * toInch;
            case "m":
                return value * toMeter;
        }
        return value;
    }
}
