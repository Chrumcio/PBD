package Entity;

import java.math.BigInteger;
import java.util.Date;

public class Pacjent {
    private int id;
    private String nazwisko;
    private String imie;
    private String pesel;
    private Date dataUrodzenia;
    private BigInteger nrUbezpieczenia;

    public Pacjent(int id, String nazwisko, String imie, String pesel, Date dataUrodzenia, BigInteger nrUbezpieczenia) {
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

    public BigInteger getNrUbezpieczenia() {
        return nrUbezpieczenia;
    }

    public void setNrUbezpieczenia(BigInteger nrUbezpieczenia) {
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
}
