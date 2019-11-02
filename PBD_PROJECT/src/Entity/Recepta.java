package Entity;

import java.util.Date;

public class Recepta {
    private int id;
    private Date dataWystawienia;
    private Date dataWaznosci;

    public Recepta(int id, Date dataWystawienia, Date dataWaznosci) {
        this.id = id;
        this.dataWystawienia = dataWystawienia;
        this.dataWaznosci = dataWaznosci;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataWystawienia() {
        return dataWystawienia;
    }

    public void setDataWystawienia(Date dataWystawienia) {
        this.dataWystawienia = dataWystawienia;
    }

    public Date getDataWaznosci() {
        return dataWaznosci;
    }

    public void setDataWaznosci(Date dataWaznosci) {
        this.dataWaznosci = dataWaznosci;
    }

    @Override
    public String toString() {
        return "Recepta{" +
                "id=" + id +
                ", dataWystawienia=" + dataWystawienia +
                ", dataWaznosci=" + dataWaznosci +
                '}';
    }
}
