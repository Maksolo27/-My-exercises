package dbWorkers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maxim on 22.04.2021.
 */
public class MeterDAO implements UnitDAO{

    private double toFoot;
    private double toInc;
    private double toSantimeter;

    public double getToFoot() {
        return toFoot;
    }

    public void setToFoot(double toFoot) {
        this.toFoot = toFoot;
    }

    public double getToInc() {
        return toInc;
    }

    public void setToInc(double toInc) {
        this.toInc = toInc;
    }

    public double getToSantimeter() {
        return toSantimeter;
    }

    public void setToSantimeter(double toSantimeter) {
        this.toSantimeter = toSantimeter;
    }

    @Override
    public UnitDAO getDAO() {
        List<MeterDAO> allm = new ArrayList<>();
        Connection connection = DBWorker.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("Select * from Meter");
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                MeterDAO meterDAO = new MeterDAO();
                double toSantimeter = rs.getDouble(1);
                double toFoot = rs.getDouble(2);
                double toInch = rs.getDouble(3);
                meterDAO.setToSantimeter(toSantimeter);
                meterDAO.setToFoot(toFoot);
                meterDAO.setToInc(toInch);
                allm.add(meterDAO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allm.get(0);

    }
}
