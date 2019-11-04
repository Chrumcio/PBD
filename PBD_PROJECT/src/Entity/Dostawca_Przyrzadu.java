package Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dostawca_Przyrzadu {

    private int idPrzyrzadu;
    private int idDostawcy;

    public Dostawca_Przyrzadu() {
    }

    public Dostawca_Przyrzadu(int idPrzyrzadu, int idDostawcy) {
        this.idPrzyrzadu = idPrzyrzadu;
        this.idDostawcy = idDostawcy;
    }

    public int getIdPrzyrzadu() {
        return idPrzyrzadu;
    }

    public void setIdPrzyrzadu(int idPrzyrzadu) {
        this.idPrzyrzadu = idPrzyrzadu;
    }

    public int getIdDostawcy() {
        return idDostawcy;
    }

    public void setIdDostawcy(int idDostawcy) {
        this.idDostawcy = idDostawcy;
    }

    @Override
    public String toString() {
        return "Dostawca_Przyrzadu{" +
                "idPrzyrzadu=" + idPrzyrzadu +
                ", idDostawcy=" + idDostawcy +
                '}';
    }
    public void addDostawca_Przyrzadu(Connection connection) throws SQLException {
        String query = "INSERT INTO dostawca_przyrzadu(iddostawcy, idprzyrzadu) " +
                "VALUES(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,idDostawcy);
        preparedStatement.setInt(2,idPrzyrzadu);
        preparedStatement.executeUpdate();
        System.out.println(this.toString());
    }
}
