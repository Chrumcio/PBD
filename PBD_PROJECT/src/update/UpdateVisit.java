package update;

import Entity.Historia_Wizyt;

import java.sql.*;
import java.util.Calendar;

public class UpdateVisit {

    private Connection connection;

    public UpdateVisit(Connection connection) {
        this.connection = connection;
    }

    public void updateWizytaDate(int id, Date date) throws SQLException {
        addVisitHistory(id).addHistoriaWizyty(connection);
        String query = "UPDATE wizyta "
                +"SET datawizyty = ? "
                +"WHERE idwizyty = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(2, id);
        preparedStatement.setDate(1, date);
        preparedStatement.executeUpdate();
        System.out.println((this.toString()));
    }

    private Historia_Wizyt addVisitHistory(int id) throws SQLException {
        int lastId = getLastId()+1;
        Timestamp last_date = new Timestamp(System.currentTimeMillis());
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM wizyta WHERE idwizyty="+id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return new Historia_Wizyt(resultSet.getInt(1),resultSet.getDate(2),resultSet.getTime(3),
                resultSet.getString(4),resultSet.getInt(5),resultSet.getInt(6),
                resultSet.getInt(7), resultSet.getInt(8), resultSet.getInt(9),
                resultSet.getInt(10), resultSet.getInt(11), resultSet.getString(12),
                resultSet.getString(13), lastId , last_date);
    }
    private int getLastId() throws SQLException {
        int lastId = 0;
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM historia_wizyt");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            lastId = resultSet.getInt(14);
        }
        return lastId;
    }

    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
}
