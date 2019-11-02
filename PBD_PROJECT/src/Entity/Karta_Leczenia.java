package Entity;

public class Karta_Leczenia {

    private int id;
    private String dolegliwosc;

    public Karta_Leczenia(int id, String dolegliwosc) {
        this.id = id;
        this.dolegliwosc = dolegliwosc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDolegliwosc() {
        return dolegliwosc;
    }

    public void setDolegliwosc(String dolegliwosc) {
        this.dolegliwosc = dolegliwosc;
    }

    @Override
    public String toString() {
        return "Karta_Leczenia{" +
                "id=" + id +
                ", dolegliwosc='" + dolegliwosc + '\'' +
                '}';
    }
}
