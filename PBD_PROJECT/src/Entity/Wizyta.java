package Entity;

import java.sql.Time;
import java.util.Date;

public class Wizyta {

    private int id;
    private Date data;
    private Time time;
    private String rodzaj;
    private int idStatusu;
    private int idPielegniarki;
    private int idLekarza;
    private int gabinet;
    private int idRecepty;
    private int idRecepcjonistki;
    private int idPacjenta;
    private int idKarty;
    private int idDiagnostyki;

    public Wizyta(int id, Date data, Time time, String rodzaj, int idStatusu, int idPielegniarki, int idLekarza, int gabinet, int idRecepty, int idRecepcjonistki, int idPacjenta, int idKarty, int idDiagnostyki) {
        this.id = id;
        this.data = data;
        this.time = time;
        this.rodzaj = rodzaj;
        this.idStatusu = idStatusu;
        this.idPielegniarki = idPielegniarki;
        this.idLekarza = idLekarza;
        this.gabinet = gabinet;
        this.idRecepty = idRecepty;
        this.idRecepcjonistki = idRecepcjonistki;
        this.idPacjenta = idPacjenta;
        this.idKarty = idKarty;
        this.idDiagnostyki = idDiagnostyki;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    public int getIdStatusu() {
        return idStatusu;
    }

    public void setIdStatusu(int idStatusu) {
        this.idStatusu = idStatusu;
    }

    public int getIdPielegniarki() {
        return idPielegniarki;
    }

    public void setIdPielegniarki(int idPielegniarki) {
        this.idPielegniarki = idPielegniarki;
    }

    public int getIdLekarza() {
        return idLekarza;
    }

    public void setIdLekarza(int idLekarza) {
        this.idLekarza = idLekarza;
    }

    public int getGabinet() {
        return gabinet;
    }

    public void setGabinet(int gabinet) {
        this.gabinet = gabinet;
    }

    public int getIdRecepty() {
        return idRecepty;
    }

    public void setIdRecepty(int idRecepty) {
        this.idRecepty = idRecepty;
    }

    public int getIdRecepcjonistki() {
        return idRecepcjonistki;
    }

    public void setIdRecepcjonistki(int idRecepcjonistki) {
        this.idRecepcjonistki = idRecepcjonistki;
    }

    public int getIdPacjenta() {
        return idPacjenta;
    }

    public void setIdPacjenta(int idPacjenta) {
        this.idPacjenta = idPacjenta;
    }

    public int getIdKarty() {
        return idKarty;
    }

    public void setIdKarty(int idKarty) {
        this.idKarty = idKarty;
    }

    public int getIdDiagnostyki() {
        return idDiagnostyki;
    }

    public void setIdDiagnostyki(int idDiagnostyki) {
        this.idDiagnostyki = idDiagnostyki;
    }

    @Override
    public String toString() {
        return "Wizyta{" +
                "id=" + id +
                ", data=" + data +
                ", time=" + time +
                ", rodzaj='" + rodzaj + '\'' +
                ", idStatusu=" + idStatusu +
                ", idPielegniarki=" + idPielegniarki +
                ", idLekarza=" + idLekarza +
                ", gabinet=" + gabinet +
                ", idRecepty=" + idRecepty +
                ", idRecepcjonistki=" + idRecepcjonistki +
                ", idPacjenta=" + idPacjenta +
                ", idKarty=" + idKarty +
                ", idDiagnostyki=" + idDiagnostyki +
                '}';
    }
}
