package units;

import dbWorkers.SantimeterDAO;

/**
 * Created by maxim on 21.04.2021.
 */
public class Santimeter implements UnitConverter {

    @Override
    public double convert(String convert, double value) {
        SantimeterDAO santimeterDAO = new SantimeterDAO().getDAO();
        switch (convert){
            case "ft":
                return value * santimeterDAO.getToFoot();
            case "in":
                return value * santimeterDAO.getToInc();
            case "m":
                return value * santimeterDAO.getToMeter();
        }
        return value;
    }
}
