package Entity;

public class Zaopatrzenie {
    private int nrGabinetu;
    private int idPrzyrzadu;

    public Zaopatrzenie(int nrGabinetu, int idPrzyrzadu) {
        this.nrGabinetu = nrGabinetu;
        this.idPrzyrzadu = idPrzyrzadu;
    }

    public int getNrGabinetu() {
        return nrGabinetu;
    }

    public void setNrGabinetu(int nrGabinetu) {
        this.nrGabinetu = nrGabinetu;
    }

    public int getIdPrzyrzadu() {
        return idPrzyrzadu;
    }

    public void setIdPrzyrzadu(int idPrzyrzadu) {
        this.idPrzyrzadu = idPrzyrzadu;
    }

    @Override
    public String toString() {
        return "Zaopatrzenie{" +
                "nrGabinetu=" + nrGabinetu +
                ", idPrzyrzadu=" + idPrzyrzadu +
                '}';
    }
}
