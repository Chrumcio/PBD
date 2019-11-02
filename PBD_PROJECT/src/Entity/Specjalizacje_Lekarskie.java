package Entity;

public class Specjalizacje_Lekarskie {
    private int idSpecj;
    private int idLek;

    public Specjalizacje_Lekarskie(int idSpecj, int idLek) {
        this.idSpecj = idSpecj;
        this.idLek = idLek;
    }

    public int getIdSpecj() {
        return idSpecj;
    }

    public void setIdSpecj(int idSpecj) {
        this.idSpecj = idSpecj;
    }

    public int getIdLek() {
        return idLek;
    }

    public void setIdLek(int idLek) {
        this.idLek = idLek;
    }

    @Override
    public String toString() {
        return "Specjalizacje_Lekarskie{" +
                "idSpecj=" + idSpecj +
                ", idLek=" + idLek +
                '}';
    }
}
