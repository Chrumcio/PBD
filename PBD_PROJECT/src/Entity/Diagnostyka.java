package Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Diagnostyka {

    private int idDiagnostyki;
    private String nazwaDiagnostyki;

    public Diagnostyka(int idDiagnostyki, String nazwaDiagnostyki) {
        this.idDiagnostyki = idDiagnostyki;
        this.nazwaDiagnostyki = nazwaDiagnostyki;
    }

    public int getIdDiagnostyki() {
        return idDiagnostyki;
    }

    public void setIdDiagnostyki(int idDiagnostyki) {
        this.idDiagnostyki = idDiagnostyki;
    }

    public String getNazwaDiagnostyki() {
        return nazwaDiagnostyki;
    }

    public void setNazwaDiagnostyki(String nazwaDiagnostyki) {
        this.nazwaDiagnostyki = nazwaDiagnostyki;
    }

    @Override
    public String toString() {
        return "Diagnostyka{" +
                "idDiagnostyki=" + idDiagnostyki +
                ", nazwaDiagnostyki='" + nazwaDiagnostyki + '\'' +
                '}';
    }

    public void addDiagnostyka(Connection connection) throws SQLException {
        String query = "INSERT INTO diagnostyka(iddiagnostyki, nazwadiagnostyki)" +
                "VALUES(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,idDiagnostyki);
        preparedStatement.setString(2, nazwaDiagnostyki);
        preparedStatement.executeUpdate();
        System.out.println(this.toString());
    }
}
