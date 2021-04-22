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
public class IncDAO implements UnitDAO {
    private double toFoot;
    private double toMeter;
    private double toSantimeter;

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

    public double getToSantimeter() {
        return toSantimeter;
    }

    public void setToSantimeter(double toSantimeter) {
        this.toSantimeter = toSantimeter;
    }

    @Override
    public UnitDAO getDAO() {
        List<IncDAO> all = new ArrayList<>();
        Connection connection = DBWorker.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("Select * from Inch");
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                IncDAO incDAO = new IncDAO();
                double toSantimeter = rs.getDouble(1);
                double toFoot = rs.getDouble(2);
                double toMeter = rs.getDouble(3);
                incDAO.setToSantimeter(toSantimeter);
                incDAO.setToFoot(toFoot);
                incDAO.setToMeter(toMeter);
                all.add(incDAO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all.get(0);
    }
}
