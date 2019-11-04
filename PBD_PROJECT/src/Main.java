import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Consty.CONST;
import Entity.Lekarstwo;
import datafiles.Medicines;
import draw.*;


public class Main {
    private static List<String> listOfNames = new ArrayList<>();

    public static List<String> setListOfNames() throws IOException {
        File file = new File(CONST.namesUrl);
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
        String name;
        while((name = reader.readLine()) != null){
            listOfNames.add(name);
            System.out.println(name); 
        }
        
        return listOfNames;
    }

    public static void main(String[] args) throws SQLException, IOException { 
//        String url = CONST.url;
//        String user = CONST.user;
//        String password = CONST.haslo;
        String url = "jdbc:postgresql://localhost/PBD_PROJECT";
        String user = "postgres";

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/PBD_PROJECT","postgres","12345678");
        Medicines medicines = new Medicines();
        List<String> medicinesList = medicines.getListOfMedicines();
        for(int i=0;i<medicinesList.size();i++){
            Lekarstwo lekarstwo = new Lekarstwo();
            lekarstwo.setId(i);
            int a = (int)(Math.random()*medicinesList.size());
            lekarstwo.setNazwa(medicinesList.get(a));
            lekarstwo.addLekarstwo(connection);
        }
//        try (
//             PreparedStatement pst = connection.prepareStatement("SELECT * FROM dostawca");
//             ResultSet rs = pst.executeQuery()) {
//            while (rs.next()) {
//                System.out.print(rs.getInt(1));
//                System.out.print(": ");
//                System.out.println(rs.getString(2));
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
        
        System.out.println("XXXXXXXXXXXXXXX");
        
        
        
        //RecepcionistsDraw.addRecepcjonistka(30, url, user, password);
        //MedicineDraw medicineDraw = new MedicineDraw(url, user, password);
        //medicineDraw.addMedicine(10);
        //PatientDraw patientDraw = new PatientDraw(url, user, password);
        //patientDraw.addPatient(10);
        //DoctorDraw  doctorDraw = new DoctorDraw(url, user, password);
        //doctorDraw.addDoctor(10);
        //NurseDraw nurseDraw = new NurseDraw(url, user, password);
        //nurseDraw.addNurse(10);
//        ProviderDraw providerDraw = new ProviderDraw(url, user, password);
//        providerDraw.addProvider(10);
//
        
        
        
        
        
        
        
        
//
//        int id = 6;
//        String author = "Trygve Gulbranssen";
//        String query = "INSERT INTO car(idcar,name) VALUES(?,?)";
//
        
        
        
//        try (Connection con = DriverManager.getConnection(url, user, password);
//             PreparedStatement pst = con.prepareStatement(query)) {
//            pst.setInt(1, id);
//            pst.setString(2, author);
//            pst.executeUpdate();
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
    }
}