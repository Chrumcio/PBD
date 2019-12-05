package draw;

import Entity.Zaopatrzenie;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SupplyAdd {

    private List<Integer> room_list;
    private List<Integer> instrument_list;
    private Connection connection;
    private Random random;

    public SupplyAdd(String url, String user, String password) throws IOException, SQLException {
        connection = DriverManager.getConnection(url, user, password);
        random = new Random();
        room_list = getRoomList();
        instrument_list = getInstrumentsList();
    }

    public void addSupply(int supply_amount) throws SQLException {
        for (int i = 0; i < supply_amount; i++) {
            drawZaopatrzenie().addZaopatrzenie(connection);
        }
    }

    private Zaopatrzenie drawZaopatrzenie() {
        int random_room_index = random.nextInt(room_list.size());
        int random_instrument_index = random.nextInt(instrument_list.size());
        int room = room_list.get(random_room_index);
        int instrument = instrument_list.get(random_instrument_index);

        return new Zaopatrzenie(room, instrument);
    }

    private List<Integer> getRoomList() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM gabinet");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Integer> room_numbers = new ArrayList<>();
        while (resultSet.next()) {
            room_numbers.add(resultSet.getInt(1));
        }
        return room_numbers;
    }

    private List<Integer> getInstrumentsList() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM przyrzad_medyczny");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Integer> instruments_id = new ArrayList<>();
        while (resultSet.next()) {
            instruments_id.add(resultSet.getInt(1));
        }
        return instruments_id;
    }

}
