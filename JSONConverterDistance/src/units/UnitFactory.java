package units;

/**
 * Created by maxim on 21.04.2021.
 */
public class UnitFactory {

    public UnitConverter getUnit(Unit u){
        UnitConverter unit = null;
        switch (u){
            case METER:
                unit = new Meter();
                break;
            case FOOT:
                unit = new Foot();
                break;
            case SANTIMETER:
                unit = new Santimeter();
                break;
            case INC:
                unit = new Inc();
                break;

        }
        return unit;
    }
}
