package draw;

import Entity.Wizyta;
import datafiles.Visits;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class VisitDraw {

    private List<Integer> doctor_list;
    private List<Integer> status_list;
    private List<Integer> nurse_list;
    private List<Integer> prescription_list;
    private List<Integer> receptionist_list;
    private List<Integer> patient_list;
    private List<String> diagnostic_list;
    private List<String> type_of_visit;
    private List<Integer> room_list;


    private Connection connection;
    private Random random;

    public VisitDraw(String url, String user, String password) throws SQLException, IOException {
        connection = DriverManager.getConnection(url, user, password);
        random = new Random();
        patient_list = getPatientList();
        receptionist_list = getReceptionistList();
        prescription_list = getPrespcriptionList();
        nurse_list = getNurseList();
        doctor_list = getDoctorList();
        diagnostic_list = getDiagnosticList();
        type_of_visit = (new Visits().setListOfSurnames());
        status_list = getStatusList();
        room_list = getRoomList();
    }

    public void addVisit(int visit_amount) throws SQLException {
        int lastId = getLastId() +1;
        for(int i=0; i<visit_amount; i++){
            drawVisit(lastId + 1 +i).addWizyta(connection);
        }
    }

    private Wizyta drawVisit(int id){
        int random_doctor_index = random.nextInt(doctor_list.size());
        int random_patient_index = random.nextInt(patient_list.size());
        int random_nurse_index = random.nextInt(nurse_list.size());
        int random_diagnostic_index = random.nextInt(diagnostic_list.size());
        int random_status_index = random.nextInt(status_list.size());
        int random_prescription_index = random.nextInt(prescription_list.size());
        int random_receptionist_index = random.nextInt(receptionist_list.size());
        int random_type_visit = random.nextInt(type_of_visit.size());
        int random_room = random.nextInt(room_list.size());

        int room = room_list.get(random_room);
        String type = type_of_visit.get(random_type_visit);
        int doctor = doctor_list.get(random_doctor_index);
        int patient = patient_list.get(random_patient_index);
        int nurse = nurse_list.get(random_nurse_index);
        String diagnostic = diagnostic_list.get(random_diagnostic_index);
        int status = status_list.get(random_status_index);
        int prescription = prescription_list.get(random_prescription_index);
        int receptionist = receptionist_list.get(random_receptionist_index);


        Date date = drawDate();
        Time time = new Time(20,15,15);
        String comment = "komentarz";

        return new Wizyta(id,date,time,type,status,nurse,doctor,room,prescription,receptionist,patient,diagnostic,comment);
    }


    private List<Integer> getDoctorList() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM lekarz");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Integer> doctor_id = new ArrayList<>();
        while (resultSet.next()) {
            doctor_id.add(resultSet.getInt(1));
        }
        return doctor_id;
    }

    private List<Integer> getPatientList() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM pacjent");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Integer> patient_id = new ArrayList<>();
        while (resultSet.next()) {
            patient_id.add(resultSet.getInt(1));
        }
        return patient_id;
    }

    private List<Integer> getNurseList() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM pielegniarka");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Integer> nurse_id = new ArrayList<>();
        while (resultSet.next()) {
            nurse_id.add(resultSet.getInt(1));
        }
        return nurse_id;
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

    private List<Integer> getPrespcriptionList() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM recepta");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Integer> prescription_id = new ArrayList<>();
        while (resultSet.next()) {
            prescription_id.add(resultSet.getInt(1));
        }
        return prescription_id;
    }

    private List<Integer> getReceptionistList() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM recepcjonistka");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Integer> receptionist_id = new ArrayList<>();
        while (resultSet.next()) {
            receptionist_id.add(resultSet.getInt(1));
        }
        return receptionist_id;
    }
    private List<String> getDiagnosticList() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM diagnostyka");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<String> diagnostic_id = new ArrayList<>();
        while (resultSet.next()) {
            diagnostic_id.add(resultSet.getString(1));
        }
        return diagnostic_id;
    }

    private List<Integer> getStatusList() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM status");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Integer> status_id = new ArrayList<>();
        while (resultSet.next()) {
            status_id.add(resultSet.getInt(1));
        }
        return status_id;
    }

    private int getLastId() throws SQLException {
        int lastId = 0;
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM wizyta");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            lastId = resultSet.getInt(1);
        }
        return lastId;
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
}
