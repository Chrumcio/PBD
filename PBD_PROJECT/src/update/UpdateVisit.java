package update;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateVisit {

    private Connection connection;

    public UpdateVisit(Connection connection) {
        this.connection = connection;
    }

    public void updateWizytaDate(int id, Date date) throws SQLException {
        String query = "UPDATE wizyta "
                +"SET datawizyty = ? "
                +"WHERE idwizyty = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.setDate(2, date);
        preparedStatement.executeUpdate();
        System.out.println((this.toString()));
    }
}
