package units;

/**
 * Created by maxim on 21.04.2021.
 */
public class Foot implements UnitConverter {
    private static final double toSantimeter = 0.0328;
    private static final double toMeter = 0.32808;
    private static final double toInch = 0.833;

    @Override
    public double convert(String convert, double value) {
        switch (convert){
            case "in":
                return value * toInch;
            case "sm":
                return value * toSantimeter;
            case "m":
                return value * toMeter;
        }
        return value;
    }
}
