package draw;

import Entity.Lekarstwo;
import datafiles.Medicines;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

public class MedicineDraw {

    private List<String> listOfMedicines = (new Medicines()).getListOfMedicines();
    private Connection connection;
    private Random random ;

    public MedicineDraw(String url, String user, String password) throws SQLException, IOException {
        connection = DriverManager.getConnection(url, user, password);
        random = new Random();
    }

    public void addMedicine(int medicine_amount) throws SQLException {
        for (int i = 0; i < medicine_amount; i++) {
            drawMedicine(i + 1).addLekarstwo(connection);
        }
    }

    private Lekarstwo drawMedicine(int id) {
        int random_index = random.nextInt(listOfMedicines.size());
        String nazwa = listOfMedicines.get(random_index);
        return new Lekarstwo(id, nazwa);
    }
}
