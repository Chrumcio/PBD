package Entity;

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
}
