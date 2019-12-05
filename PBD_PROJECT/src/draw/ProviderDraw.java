package draw;

import Entity.Dostawca;
import datafiles.Cities;
import datafiles.Providers;
import datafiles.Streets;

import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class ProviderDraw {

    private List<String> listOfProviders = (new Providers()).setListOfProviders();
    private List<String> cities = (new Cities()).setListOfCities();
    private List<String> streets = (new Streets()).setListOfStreets();
    private Connection connection;
    private Random random;

    public ProviderDraw(String url,
                        String user, String password) throws IOException, SQLException {
        connection = DriverManager.getConnection(url, user, password);
        random = new Random();
    }

    public void addProvider(int provider_amount) throws SQLException {
        int lastId = getLastId();
        for(int i=0; i<provider_amount; i++){
            drawProvider(lastId + i +1).addDostawca(connection);
        }
    }

    private Dostawca drawProvider(int id) {
        String name = drawName();
        String address = drawAddress();
        String nip = drawNip();

        return new Dostawca(id, name, address, nip);
    }

    private String drawName() {
        int random_index_names = random.nextInt(listOfProviders.size());
        return listOfProviders.get(random_index_names);
    }

    private String drawAddress() {
        int random_cities_index = random.nextInt(cities.size());
        int random_streets_index = random.nextInt(streets.size());
        int house_number = random.nextInt(100);
        String city = cities.get(random_cities_index);
        String street = streets.get(random_streets_index);
        return city + street + house_number;
    }

    private String drawNip() {
        int min_boundary = 100000000;
        int max_boundary = 999999999;
        Long not_complete_nip = random.longs(min_boundary, max_boundary).findFirst().getAsLong();
        int last_number = getLastNipNumber(not_complete_nip);
        return  "" + not_complete_nip + last_number;
    }

    private int getLastNipNumber(Long not_complete_nip) {
        String not_complete_nip_string = Long.toString(not_complete_nip);
        int nip_numbers[] = new int[not_complete_nip_string.length()];
        for (int i = 0; i < not_complete_nip_string.length(); i++) {
            nip_numbers[i] = not_complete_nip_string.charAt(i);
        }
        int[] wages = {6, 5, 7, 2, 3, 4, 5, 6, 7};
        int last_number = 0;
        for (int i = 0; i < wages.length; i++) {
            last_number += wages[i] * nip_numbers[i];
        }
        return last_number % 11;
    }

    private int getLastId() throws SQLException {
        int lastId = 0;
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM dostawca");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            lastId = resultSet.getInt(1);
        }
        return lastId;
    }
}
