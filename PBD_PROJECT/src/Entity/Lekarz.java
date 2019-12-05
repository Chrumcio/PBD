package Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Lekarz {

    private int id;
    private String nazwisko;
    private String imie;
    private String pesel;
    private int nrpwz;

    public Lekarz() {
    }

    public Lekarz(int id, String nazwisko, String imie, String pesel, int nrpwz) {
        this.id = id;
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.pesel = pesel;
        this.nrpwz = nrpwz;
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

    public int getNrpwz() {
        return nrpwz;
    }

    public void setNrpwz(int nrpwz) {
        this.nrpwz = nrpwz;
    }

    @Override
    public String toString() {
        return "Lekarz{" +
                "id=" + id +
                ", nazwisko='" + nazwisko + '\'' +
                ", imie='" + imie + '\'' +
                ", pesel='" + pesel + '\'' +
                ", nrpwz=" + nrpwz +
                '}';
    }

    public void addLekarz(Connection connection) throws SQLException {
        String query = "INSERT INTO lekarz(idlekarza,imie,nazwisko,pesel,nrpwz) " +
                "VALUES(?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,id);
        preparedStatement.setString(2,imie);
        preparedStatement.setString(3,nazwisko);
        preparedStatement.setString(4,pesel);
        preparedStatement.setInt(5,nrpwz);
        preparedStatement.executeUpdate();
        System.out.println(this.toString());
    }
}
