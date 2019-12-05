package Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Przyrzad_Medyczny {
    private int id;
    private String nazwa;

    public Przyrzad_Medyczny() {
    }

    public Przyrzad_Medyczny(int id, String nazwa) {
        this.id = id;
        this.nazwa = nazwa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return "Przyrzad_Medyczny{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }

    public void addPrzyrzad_Medyczny(Connection connection) throws SQLException {
        String query = "INSERT INTO przyrzad_medyczny(idprzyrzadu, nazwaprzyrzadu) " +
                "VALUES(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, nazwa);
        preparedStatement.executeUpdate();
        System.out.println(this.toString());
    }
}
