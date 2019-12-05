package Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Wytyczne {
    private int idRecepty;
    private int idLekarstwa;
    private String iloscLeku;
    private String odplatnosc;

    public Wytyczne() {
    }

    public Wytyczne(int idRecepty, int idLekarstwa, String iloscLeku, String odplatnosc) {
        this.idRecepty = idRecepty;
        this.idLekarstwa = idLekarstwa;
        this.iloscLeku = iloscLeku;
        this.odplatnosc = odplatnosc;
    }

    public int getIdRecepty() {
        return idRecepty;
    }

    public void setIdRecepty(int idRecepty) {
        this.idRecepty = idRecepty;
    }

    public int getIdLekarstwa() {
        return idLekarstwa;
    }

    public void setIdLekarstwa(int idLekarstwa) {
        this.idLekarstwa = idLekarstwa;
    }

    public String getIloscLeku() {
        return iloscLeku;
    }

    public void setIloscLeku(String iloscLeku) {
        this.iloscLeku = iloscLeku;
    }

    public String getOdplatnosc() {
        return odplatnosc;
    }

    public void setOdplatnosc(String odplatnosc) {
        this.odplatnosc = odplatnosc;
    }

    @Override
    public String toString() {
        return "Wytyczne{" +
                "idRecepty=" + idRecepty +
                ", idLekarstwa=" + idLekarstwa +
                ", iloscLeku='" + iloscLeku + '\'' +
                ", odplatnosc='" + odplatnosc + '\'' +
                '}';
    }

    public void addWytyczne(Connection connection) throws SQLException {
        String query = "INSERT INTO wytyczne(idrecepty, idlekarstwa, iloscleku, odplatnosc) " +
                "VALUES(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, idRecepty);
        preparedStatement.setInt(2,idLekarstwa);
        preparedStatement.setString(3, iloscLeku);
        preparedStatement.setString(4, odplatnosc);
        preparedStatement.executeUpdate();
        System.out.println(this.toString());
    }
}
