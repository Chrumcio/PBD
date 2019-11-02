package Entity;

public class Przyrzad_Medyczny {
    private int id;
    private String nazwa;

    public Przyrzad_Medyczny(int id, String nazwa) {
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
        return "Przyrzad_Medyczny{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }
}
