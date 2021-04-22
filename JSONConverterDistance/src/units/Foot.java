package units;

import dbWorkers.FootDAO;

/**
 * Created by maxim on 21.04.2021.
 */
public class Foot implements UnitConverter {

    @Override
    public double convert(String convert, double value) {
        FootDAO footDAO = (FootDAO) new FootDAO().getDAO();
        switch (convert){
            case "in":
                return value * footDAO.getToInc();
            case "sm":
                return value * footDAO.getToSantimeter();
            case "m":
                return value * footDAO.getToMeter();
        }
        return value;
    }

}
