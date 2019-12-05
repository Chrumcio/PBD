package draw;

import Entity.Recepta;

import java.io.IOException;
import java.sql.*;
import java.util.Calendar;
import java.util.Random;

public class PrescriptionAdd {

    Connection connection;
    Random random;
    public PrescriptionAdd(String url, String user, String password) throws IOException, SQLException {
        connection = DriverManager.getConnection(url, user, password);
        random = new Random();
    }

    public void addPrescription(int prescription_amount) throws SQLException {
        int lastId = getLastId()+1;
        for(int i=0; i< prescription_amount; i++){
            drawPrescription(getLastId()+i).addRecepta(connection);
        }
    }

    public Recepta drawPrescription(int id){
        Date issue_date = drawDate();
        Date validity_date = drawDate();

        return new Recepta(id,issue_date, validity_date);
    }

    private Date drawDate() {
        String s = "1950-01-01";
        Date firstDate = Date.valueOf(s);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(firstDate);
        calendar.add(Calendar.DATE, random.nextInt(18250));
        return convertUtilToSql(calendar.getTime());
    }
    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
    private int getLastId() throws SQLException {
        int lastId = 0;
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM recepta");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            lastId = resultSet.getInt(1);
        }
        return lastId;
    }

}
