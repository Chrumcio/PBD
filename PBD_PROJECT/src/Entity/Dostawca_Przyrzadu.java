package Entity;

public class Dostawca_Przyrzadu {

    private int idPrzyrzadu;
    private int idDostawcy;

    public Dostawca_Przyrzadu(int idPrzyrzadu, int idDostawcy) {
        this.idPrzyrzadu = idPrzyrzadu;
        this.idDostawcy = idDostawcy;
    }

    public int getIdPrzyrzadu() {
        return idPrzyrzadu;
    }

    public void setIdPrzyrzadu(int idPrzyrzadu) {
        this.idPrzyrzadu = idPrzyrzadu;
    }

    public int getIdDostawcy() {
        return idDostawcy;
    }

    public void setIdDostawcy(int idDostawcy) {
        this.idDostawcy = idDostawcy;
    }

    @Override
    public String toString() {
        return "Dostawca_Przyrzadu{" +
                "idPrzyrzadu=" + idPrzyrzadu +
                ", idDostawcy=" + idDostawcy +
                '}';
    }
}
