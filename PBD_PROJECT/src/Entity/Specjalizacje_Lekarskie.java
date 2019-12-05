package Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Specjalizacje_Lekarskie {
    private int idSpecj;
    private int idLek;

    public Specjalizacje_Lekarskie() {
    }

    public Specjalizacje_Lekarskie(int idSpecj, int idLek) {
        this.idSpecj = idSpecj;
        this.idLek = idLek;
    }

    public int getIdSpecj() {
        return idSpecj;
    }

    public void setIdSpecj(int idSpecj) {
        this.idSpecj = idSpecj;
    }

    public int getIdLek() {
        return idLek;
    }

    public void setIdLek(int idLek) {
        this.idLek = idLek;
    }

    @Override
    public String toString() {
        return "Specjalizacje_Lekarskie{" +
                "idSpecj=" + idSpecj +
                ", idLek=" + idLek +
                '}';
    }
    public void addSpecjalizacje_Lekarskie(Connection connection) throws SQLException {
        String query = "INSERT INTO specjalizacje_lekarskie(idlekarza, idspecjalizacji) " +
                "VALUES(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, idLek);
        preparedStatement.setInt(2, idSpecj);
        preparedStatement.executeUpdate();
        System.out.println(this.toString());
    }
}
