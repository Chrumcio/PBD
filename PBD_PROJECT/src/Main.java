import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Consty.CONST;
import draw.MedicineDraw;
import draw.PatientDraw;
import draw.RecepcionistsDraw;


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
        String url = CONST.url;
        String user = CONST.user;
        String password = CONST.haslo;
        Connection connection = DriverManager.getConnection(url,user,password);
        try (
             PreparedStatement pst = connection.prepareStatement("SELECT * FROM lekarstwo");
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                System.out.print(rs.getInt(1));
                System.out.print(": ");
                System.out.println(rs.getString(2));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        System.out.println("XXXXXXXXXXXXXXX");
        
        
        
        //RecepcionistsDraw.addRecepcjonistka(30, url, user, password);
        //MedicineDraw medicineDraw = new MedicineDraw(url, user, password);
        //medicineDraw.addMedicine(10);
        //PatientDraw patientDraw = new PatientDraw(url, user, password);
        //patientDraw.addPatient(10);
         
        
        
        
        
        
        
        
        
        
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