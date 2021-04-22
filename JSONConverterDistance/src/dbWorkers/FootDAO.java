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
public class FootDAO implements UnitDAO{

    private double toInc;
    private double toMeter;
    private double toSantimeter;

    public double getToInc() {
        return toInc;
    }

    public void setToInc(double toInc) {
        this.toInc = toInc;
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
        List<FootDAO> all = new ArrayList<>();
        Connection connection = DBWorker.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("Select * from Foot");
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                FootDAO footDAO = new FootDAO();
                double toSantimeter = rs.getDouble(1);
                double toMeter = rs.getDouble(3);
                double toInch = rs.getDouble(2);
                footDAO.setToSantimeter(toSantimeter);
                footDAO.setToMeter(toMeter);
                footDAO.setToInc(toInch);
                all.add(footDAO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all.get(0);
    }
}
