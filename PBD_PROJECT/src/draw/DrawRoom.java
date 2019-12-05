package draw;

import Entity.Gabinet;
import datafiles.Rooms;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

;

public class DrawRoom {
    private List<String> listOfRooms = (new Rooms()).getListOfRooms();
    Connection connection;
    Random random;

    public DrawRoom(String url, String user, String password) throws SQLException, IOException {
        connection = DriverManager.getConnection(url, user, password);
        random = new Random();
    }

    public void addRoom(int room_amount) throws SQLException {
        for (int i = 0; i < room_amount; i++) {
            drawRoom().addGabinet(connection);
        }
    }

    public Gabinet drawRoom() throws SQLException {
        int room_number = 0;
        List<Integer> room_numbers = getRoomList();
        AtomicBoolean found = new AtomicBoolean(false);
        while (!found.get()) {
            found.set(true);
            room_number = random.ints(100, 399).findFirst().getAsInt();
            int finalRoom_number = room_number;
            room_numbers.stream().forEach(x -> {
                if (x == finalRoom_number)
                    found.set(false);
            });
        }
        int floor;
        switch (Integer.toString(room_number).charAt(0)) {
            case '1':
                floor = 0;
                break;
            case '2':
                floor = 1;
                break;
            case '3':
                floor = 2;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + Integer.toString(room_number).charAt(0));
        }
        int random_index = random.nextInt(listOfRooms.size());
        String type = listOfRooms.get(random_index);
        return new Gabinet(room_number, floor, type);
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
}
