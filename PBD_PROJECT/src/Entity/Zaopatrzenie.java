package Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Zaopatrzenie {
    private int nrGabinetu;
    private int idPrzyrzadu;

    public Zaopatrzenie() {
    }

    public Zaopatrzenie(int nrGabinetu, int idPrzyrzadu) {
        this.nrGabinetu = nrGabinetu;
        this.idPrzyrzadu = idPrzyrzadu;
    }

    public int getNrGabinetu() {
        return nrGabinetu;
    }

    public void setNrGabinetu(int nrGabinetu) {
        this.nrGabinetu = nrGabinetu;
    }

    public int getIdPrzyrzadu() {
        return idPrzyrzadu;
    }

    public void setIdPrzyrzadu(int idPrzyrzadu) {
        this.idPrzyrzadu = idPrzyrzadu;
    }

    @Override
    public String toString() {
        return "Zaopatrzenie{" +
                "nrGabinetu=" + nrGabinetu +
                ", idPrzyrzadu=" + idPrzyrzadu +
                '}';
    }

    public void addZaopatrzenie(Connection connection) throws SQLException {
        String query = "INSERT INTO zaopatrzenie(numergabinetu, idprzyrzadu) " +
                "VALUES(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, nrGabinetu);
        preparedStatement.setInt(2, idPrzyrzadu);
        preparedStatement.executeUpdate();
        System.out.println(this.toString());
    }
}
