package Entity;

public class Pielegniarka {

    private int id;
    private String nazwisko;
    private String imie;
    private int nrpwz;
    private String adres;
    private int pesel;

    public Pielegniarka(int id, String nazwisko, String imie, int nrpwz, String adres, int pesel) {
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

    public int getPesel() {
        return pesel;
    }

    public void setPesel(int pesel) {
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
}
