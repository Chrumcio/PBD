package draw;

import Entity.Pacjent;
import datafiles.Names;
import datafiles.Surnames;

import java.io.IOException;
import java.sql.*;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class PatientDraw {

    private List<String> names = (new Names()).setListOfNames();
    private List<String> surnames = (new Surnames()).setListOfSurnames();
    private Connection connection;
    private Random random;


    public PatientDraw(String url, String user, String password) throws IOException, SQLException {
        connection = DriverManager.getConnection(url, user, password);
        random = new Random();
    }

    public void addPatient(int patient_amount) throws SQLException {
        int lastId = getLastId();
        for (int i = 0; i < patient_amount; i++) {
            drawPatient(lastId + i +  1).addPatient(connection);
        }
    }

    private Pacjent drawPatient(int id) {

        String name = drawName();
        String surname = drawSurname();
        Date birthDate = drawDate();
        Long insuranceNumber = drawInsuranceNumber();
        String pesel = drawPesel(birthDate);

        return new Pacjent(id, surname, name, pesel, birthDate, insuranceNumber);

    }

    private String drawName() {
        int random_index_names = random.nextInt(names.size());
        return names.get(random_index_names);
    }

    private String drawSurname() {
        int random_index_surnames = random.nextInt(surnames.size());
        return surnames.get(random_index_surnames);
    }

    private Date drawDate() {
        String s = "1950-01-01";
        Date firstDate = Date.valueOf(s);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(firstDate);
        calendar.add(Calendar.DATE, random.nextInt(18250));
        return convertUtilToSql(calendar.getTime());
    }

    private String drawPesel(Date birthDate) {
        String pesel = "";
        pesel += (birthDate.toString()).substring(2, 4) +
                (birthDate.toString()).substring(5, 7) +
                (birthDate.toString()).substring(8, 10);
        int serial_number = random.ints(100,999).findFirst().getAsInt();
        pesel += Integer.toString(serial_number);
        int last_number = 0;
        int[] value= {9,7,3,1,9,7,3,1,9,7};
        for(int i=0; i<pesel.length(); i++){
            last_number += value[i]*(Integer.parseInt(pesel.substring(i,i+1)));
        }
        last_number = last_number %10;
        pesel += Integer.toString(last_number);
        return pesel;
    }

    private Long drawInsuranceNumber() {
        Long insuranceNumber = random.nextLong();
        while (insuranceNumber < 0) {
            insuranceNumber = random.nextLong();
        }
        return insuranceNumber;
    }

    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    private int getLastId() throws SQLException {
        int lastId = 0;
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM pacjent");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            lastId = resultSet.getInt(1);
        }
        return lastId;
    }
}


