package Entity;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Gabinet {

    private int numer;
    private int pietro;
    private String rodzaj;

    public Gabinet(int numer, int pietro, String rodzaj) {
        this.numer = numer;
        this.pietro = pietro;
        this.rodzaj = rodzaj;
    }

    public int getNumer() {
        return numer;
    }

    public void setNumer(int numer) {
        this.numer = numer;
    }

    public int getPietro() {
        return pietro;
    }

    public void setPietro(int pietro) {
        this.pietro = pietro;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    @Override
    public String toString() {
        return "Gabinet{" +
                "numer=" + numer +
                ", pietro=" + pietro +
                ", rodzaj='" + rodzaj + '\'' +
                '}';
    }

    public void addGabinet(Connection connection) throws SQLException {
        String query = "INSERT INTO gabinet(numergabinetu,pietro,rodzaj) " +
                "VALUES(?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,numer);
        preparedStatement.setInt(2, pietro);
        preparedStatement.setString(3, rodzaj);
        preparedStatement.executeUpdate();
        System.out.println(this.toString());
    }
}
