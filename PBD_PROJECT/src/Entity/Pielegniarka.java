package Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Pielegniarka {

    private int id;
    private String nazwisko;
    private String imie;
    private int nrpwz;
    private String adres;
    private String pesel;

    public Pielegniarka(int id, String nazwisko, String imie, int nrpwz, String adres, String pesel) {
        this.id = id;
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.nrpwz = nrpwz;
        this.adres = adres;
        this.pesel = pesel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public int getNrpwz() {
        return nrpwz;
    }

    public void setNrpwz(int nrpwz) {
        this.nrpwz = nrpwz;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @Override
    public String toString() {
        return "Pielegniarka{" +
                "id=" + id +
                ", nazwisko='" + nazwisko + '\'' +
                ", imie='" + imie + '\'' +
                ", nrpwz=" + nrpwz +
                ", adres='" + adres + '\'' +
                ", pesel=" + pesel +
                '}';
    }

    public void addPielegniarka(Connection connection) throws SQLException {
        String query = "INSERT INTO pielegniarka(idpielegniarki, nazwisko, imie, nrpwz, adres, pesel)" +
                "VALUES(?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,id);
        preparedStatement.setString(2,nazwisko);
        preparedStatement.setString(3,imie);
        preparedStatement.setInt(4, nrpwz);
        preparedStatement.setString(5,adres);
        preparedStatement.setString(6,pesel);
        preparedStatement.executeUpdate();
        System.out.println(this.toString());
    }
}
