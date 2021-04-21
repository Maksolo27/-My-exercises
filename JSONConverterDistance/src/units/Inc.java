package units;

/**
 * Created by maxim on 21.04.2021.
 */
public class Inc implements UnitConverter {
    private static final double toMeter = 39.37;
    private static final double toFoot = 12;
    private static final double toSantimeter = 2.54;

    @Override
    public double convert(String convert, double value) {
        switch (convert){
            case "ft":
                return value * toFoot;
            case "sm":
                return value * toSantimeter;
            case "m":
                return value * toMeter;
        }
        return value;
    }
}
