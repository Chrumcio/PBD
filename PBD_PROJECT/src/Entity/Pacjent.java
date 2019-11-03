package Entity;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Pacjent {
    private int id;
    private String nazwisko;
    private String imie;
    private String pesel;
    private Date dataUrodzenia;
    private Long nrUbezpieczenia;

    public Pacjent(int id, String nazwisko, String imie, String pesel, Date dataUrodzenia, Long nrUbezpieczenia) {
        this.id = id;
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.pesel = pesel;
        this.dataUrodzenia = dataUrodzenia;
        this.nrUbezpieczenia = nrUbezpieczenia;
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

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Date getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(Date dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public Long getNrUbezpieczenia() {
        return nrUbezpieczenia;
    }

    public void setNrUbezpieczenia(Long nrUbezpieczenia) {
        this.nrUbezpieczenia = nrUbezpieczenia;
    }

    @Override
    public String toString() {
        return "Pacjent{" +
                "id=" + id +
                ", nazwisko='" + nazwisko + '\'' +
                ", imie='" + imie + '\'' +
                ", pesel='" + pesel + '\'' +
                ", dataUrodzenia=" + dataUrodzenia +
                ", nrUbezpieczenia=" + nrUbezpieczenia +
                '}';
    }

    public void addPatient(Connection connection) throws SQLException {
        String query = "INSERT INTO pacjent(idpacjenta, nazwisko, imie, pesel, dataUrodzenia, numerUbezpieczenia)" +
                "VALUES(?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, nazwisko);
        preparedStatement.setString(3, imie);
        preparedStatement.setString(4, pesel);
        preparedStatement.setDate(5, dataUrodzenia);
        preparedStatement.setLong(6, nrUbezpieczenia);
        preparedStatement.executeUpdate();
        System.out.println(this.toString());

    }
}
