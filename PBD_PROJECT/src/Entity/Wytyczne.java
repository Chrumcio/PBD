package Entity;

public class Wytyczne {
    private int idRecepty;
    private int idLekarstwa;
    private String iloscLeku;
    private String odplatnosc;

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
}
