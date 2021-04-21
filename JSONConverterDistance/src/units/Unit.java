package units;

/**
 * Created by maxim on 21.04.2021.
 */
public enum Unit {
    METER, SANTIMETER, INC, FOOT;

    public static Unit setUnit(String strUnit){
        Unit un = null;
        switch (strUnit) {
            case "m":
                un = METER;
                break;
            case "ft":
                un = FOOT;
                break;
            case "in":
                un = INC;
                break;
            case "sm":
                un = SANTIMETER;
                break;
        }
        return un;
    }
}
