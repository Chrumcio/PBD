package draw;

import Entity.Specjalizacja;
import datafiles.Specjalizations;

import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Random;

public class SpecializationsAdd {
    private List<String> listOfSpecializations = (new Specjalizations().getListOfSpecjalizations());
    Connection connection;

    public SpecializationsAdd(String url, String user, String password) throws IOException, SQLException {
        connection = DriverManager.getConnection(url, user, password);
    }

    public void addSpecializations() throws SQLException {
        final int[] lastId = {getLastId()+1};
        listOfSpecializations.stream().forEach(specialization -> {
            try {
                (new Specjalizacja(lastId[0], specialization)).addSpecjalizacja(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            lastId[0]++;
        });
    }

    private int getLastId() throws SQLException {
        int lastId = 0;
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM specjalizacja");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            lastId = resultSet.getInt(1);
        }
        return lastId;
    }
}
