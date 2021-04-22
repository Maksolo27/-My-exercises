package units;

import dbWorkers.MeterDAO;

/**
 * Created by maxim on 21.04.2021.
 */
public class Meter implements UnitConverter {
    @Override
    public double convert (String convert, double value) {
        MeterDAO meterDAO = (MeterDAO) new MeterDAO().getDAO();
        switch (convert){
            case "ft":
                return value * meterDAO.getToFoot();
            case "in":
                return value * meterDAO.getToInc();
            case "cm":
                return value * meterDAO.getToSantimeter();
        }
        return value;
    }
}
