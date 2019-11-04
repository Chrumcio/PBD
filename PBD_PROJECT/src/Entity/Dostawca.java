package Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dostawca {

    private int id;
    private String nazwa;
    private String adres;
    private Long nip;

    public Dostawca(int id, String nazwa, String adres, Long nip) {
        this.id = id;
        this.nazwa = nazwa;
        this.adres = adres;
        this.nip = nip;
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

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public Long getNip() {
        return nip;
    }

    public void setNip(Long nip) {
        this.nip = nip;
    }

    @Override
    public String toString() {
        return "Dostawca{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", adres='" + adres + '\'' +
                ", nip='" + nip + '\'' +
                '}';
    }

    public void addDostawca(Connection connection) throws SQLException {
        String query = "INSERT INTO dostawca(iddostawcy,nazwadostawcy, adresdostawcy, nip)" +
                "VALUES(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,id);
        preparedStatement.setString(2,nazwa);
        preparedStatement.setString(3,adres);
        preparedStatement.setLong(4,nip);
        preparedStatement.executeUpdate();
        System.out.println(this.toString());
    }
}
