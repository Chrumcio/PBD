package draw;

import Entity.Pielegniarka;
import datafiles.Cities;
import datafiles.Names;
import datafiles.Streets;
import datafiles.Surnames;

import java.io.IOException;
import java.sql.*;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class NurseDraw {

    private List<String> names = (new Names()).setListOfNames();
    private List<String> surnames = (new Surnames()).setListOfSurnames();
    private List<String> cities=(new Cities()).setListOfCities();
    private List<String> streets=(new Streets()).setListOfStreets();
    private Connection connection;
    private Random random;

    public NurseDraw(String url,
                     String user, String password) throws IOException, SQLException {
        connection = DriverManager.getConnection(url, user, password);
        random = new Random();
    }

    public void addNurse(int nurse_amount) throws SQLException {
        int lastId = getLastId();
        for(int i=0; i<nurse_amount; i++){
            drawNurse(lastId +i +1).addPielegniarka(connection);
        }
    }

    private Pielegniarka drawNurse(int id){
        String name = drawName();
        String surname = drawSurname();
        String pesel = drawPesel(drawDate());
        String address = drawAddress();
        int nrPwz = drawNrPwz();

        return new Pielegniarka(id, surname, name, nrPwz, address, pesel);
    }

    private String drawName() {
        int random_index_names = random.nextInt(names.size());
        return names.get(random_index_names);
    }

    private String drawSurname() {
        int random_index_surnames = random.nextInt(surnames.size());
        return surnames.get(random_index_surnames);
    }

    private String drawAddress(){
        int random_cities_index = random.nextInt(cities.size());
        int random_streets_index = random.nextInt(streets.size());
        int house_number = random.nextInt(100);
        String city = cities.get(random_cities_index);
        String street = streets.get(random_streets_index);
        return city + street + house_number;
    }

    private String drawPesel(Date birthDate) {
        String pesel = "";
        pesel += (birthDate.toString()).substring(2, 4) +
                (birthDate.toString()).substring(5, 7) +
                (birthDate.toString()).substring(8, 10);
        int serial_number = random.ints(100, 999).findFirst().getAsInt();
        pesel += Integer.toString(serial_number);
        int last_number = 0;
        int[] value = {9, 7, 3, 1, 9, 7, 3, 1, 9, 7};
        for (int i = 0; i < pesel.length(); i++) {
            last_number += value[i] * (Integer.parseInt(pesel.substring(i, i + 1)));
        }
        last_number = last_number % 10;
        pesel += Integer.toString(last_number);
        return pesel;
    }

    private Date drawDate() {
        String s = "1950-01-01";
        Date firstDate = Date.valueOf(s);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(firstDate);
        calendar.add(Calendar.DATE, random.nextInt(18250));
        return convertUtilToSql(calendar.getTime());
    }

    private int drawNrPwz() {
        int min_boundary = 1000000;
        int max_boundary = 9999999;
        return random.ints(min_boundary, max_boundary).findFirst().getAsInt();
    }

    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    private int getLastId() throws SQLException {
        int lastId = 0;
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM lekarz");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            lastId = resultSet.getInt(1);
        }
        return lastId;
    }
}
