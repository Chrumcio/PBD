package Entity;

public class Lekarstwo {

    private int id;
    private String nazwa;

    public Lekarstwo(int id, String nazwa) {
        this.id = id;
        this.nazwa = nazwa;
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

    @Override
    public String toString() {
        return "Lekarstwo{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }
}
