package draw;

import Entity.Lekarstwo;
import datafiles.Medicines;

import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Random;

public class MedicineDraw {

    private List<String> listOfMedicines = (new Medicines()).getListOfMedicines();
    private Connection connection;
    private Random random;

    public MedicineDraw(String url, String user, String password) throws SQLException, IOException {
        connection = DriverManager.getConnection(url, user, password);
        random = new Random();
    }

    public void addMedicine(int medicine_amount) throws SQLException {
        int lastId = getLastId();
        for (int i = 0; i < medicine_amount; i++) {
            drawMedicine(lastId + i + 1).addLekarstwo(connection);
        }
    }

    private Lekarstwo drawMedicine(int id) {
        int random_index = random.nextInt(listOfMedicines.size());
        String nazwa = listOfMedicines.get(random_index);
        return new Lekarstwo(id, nazwa);
    }

    private int getLastId() throws SQLException {
        int lastId = 0;
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM lekarstwo");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            lastId = resultSet.getInt(1);
        }
        return lastId;
    }
}
