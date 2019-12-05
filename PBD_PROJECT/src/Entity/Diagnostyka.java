package Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Diagnostyka {

    private String idDiagnostyki;
    private String nazwaDiagnostyki;

    public Diagnostyka() {
    }

    public Diagnostyka(String idDiagnostyki, String nazwaDiagnostyki) {
        this.idDiagnostyki = idDiagnostyki;
        this.nazwaDiagnostyki = nazwaDiagnostyki;
    }

    public String getIdDiagnostyki() {
        return idDiagnostyki;
    }

    public void setIdDiagnostyki(String idDiagnostyki) {
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
        preparedStatement.setString(1,idDiagnostyki);
        preparedStatement.setString(2, nazwaDiagnostyki);
        preparedStatement.executeUpdate();
        System.out.println(this.toString());
    }
}
