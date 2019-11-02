package Entity;

public class Dostawca {

    private int id;
    private String nazwa;
    private String adres;
    private String nip;

    public Dostawca(int id, String nazwa, String adres, String nip) {
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

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
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
}
