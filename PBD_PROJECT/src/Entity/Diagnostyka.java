package Entity;

public class Diagnostyka {

    private int idDiagnostyki;
    private String nazwaDiagnostyki;

    public Diagnostyka(int idDiagnostyki, String nazwaDiagnostyki) {
        this.idDiagnostyki = idDiagnostyki;
        this.nazwaDiagnostyki = nazwaDiagnostyki;
    }

    public int getIdDiagnostyki() {
        return idDiagnostyki;
    }

    public void setIdDiagnostyki(int idDiagnostyki) {
        this.idDiagnostyki = idDiagnostyki;
    }

    public String getNazwaDiagnostyki() {
        return nazwaDiagnostyki;
    }

    public void setNazwaDiagnostyki(String nazwaDiagnostyki) {
        this.nazwaDiagnostyki = nazwaDiagnostyki;
    }

    @Override
    public String toString() {
        return "Diagnostyka{" +
                "idDiagnostyki=" + idDiagnostyki +
                ", nazwaDiagnostyki='" + nazwaDiagnostyki + '\'' +
                '}';
    }
}
