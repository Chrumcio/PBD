package Entity;

public class Status {

    private int id;
    private String nazwa;

    public Status(int id, String nazwa) {
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
        return "Status{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }
}
