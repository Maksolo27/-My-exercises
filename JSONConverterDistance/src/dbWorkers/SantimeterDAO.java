package dbWorkers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maxim on 22.04.2021.
 */
public class SantimeterDAO implements UnitDAO{
    private double toFoot;
    private double toMeter;
    private double toInc;

    public double getToFoot() {
        return toFoot;
    }

    public void setToFoot(double toFoot) {
        this.toFoot = toFoot;
    }

    public double getToMeter() {
        return toMeter;
    }

    public void setToMeter(double toMeter) {
        this.toMeter = toMeter;
    }

    public double getToInc() {
        return toInc;
    }

    public void setToInc(double toInc) {
        this.toInc = toInc;
    }

    public SantimeterDAO getDAO() {
        List<SantimeterDAO> allSm = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DBWorker.getConnection();
            String forSantimeter = "Select * from Santimeter";
            statement = connection.prepareStatement(forSantimeter);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                double tofoot = rs.getDouble(1);
                double toinch = rs.getDouble(2);
                double tometer = rs.getDouble(3);
                SantimeterDAO sm = new SantimeterDAO();
                sm.setToFoot(tofoot);
                sm.setToInc(toinch);
                sm.setToMeter(tometer);
                allSm.add(sm);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allSm.get(0);
    }

}
