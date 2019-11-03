import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Consty.CONST;


public class Main {
    private List<String> listOfNames = new ArrayList<>();

    public List<String> setListOfNames() throws IOException {
        File file = new File("C:\\Users\\Mateusz\\Documents\\PBD_PROJECT\\src\\names.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String name;
        while((name = reader.readLine()) != null){
            listOfNames.add(name);
        }
        return listOfNames;
    }

    public static void main(String[] args) throws SQLException, IOException {
        String url = CONST.url;
        String user = CONST.user;
        String password = CONST.haslo;
        Connection connection = DriverManager.getConnection(url,user,password);
        try (
             PreparedStatement pst = connection.prepareStatement("SELECT * FROM specjalizacja");
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                System.out.print(rs.getInt(1));
                System.out.print(": ");
                System.out.println(rs.getString(2));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.printf("XXXXXXXXXXXXXXX");
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