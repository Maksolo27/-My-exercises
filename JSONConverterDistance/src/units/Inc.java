package units;

import dbWorkers.IncDAO;


/**
 * Created by maxim on 21.04.2021.
 */
public class Inc implements UnitConverter {

    @Override
    public double convert(String convert, double value) {
        IncDAO incDAO = (IncDAO) new IncDAO().getDAO();
        switch (convert){
            case "ft":
                return value * incDAO.getToFoot();
            case "sm":
                return value * incDAO.getToSantimeter();
            case "m":
                return value * incDAO.getToMeter();
        }
        return value;
    }
}
