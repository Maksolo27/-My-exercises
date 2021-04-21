package units;

/**
 * Created by maxim on 21.04.2021.
 */
public class Meter implements UnitConverter {

    private static final double toSantimeter = 100;
    private static final double toFoot = 3.2808;
    private static final double toInch = 39.37;

    @Override
    public double convert (String convert, double value) {
        switch (convert){
            case "ft":
                return value * toFoot;
            case "in":
                return value * toInch;
            case "cm":
                return value * toSantimeter;
        }
        return value;
    }
}
