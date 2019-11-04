package Entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;


public class Recepcjonistka {
    private int id;
    private String nazwisko;
    private String imie;
    private Date dataUrodzenia;
    private String adres;
    private String pesel;

    public Recepcjonistka(int id, String nazwisko, String imie, Date dataUrodzenia, String adres, String pesel) {
        this.id = id;
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.dataUrodzenia = dataUrodzenia;
        this.adres = adres;
        this.pesel = pesel;
    }

    public Recepcjonistka() {
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public Date getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(Date dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @Override
    public String toString() {
        return "Recepcjonistka{" +
                "id=" + id +
                ", nazwisko='" + nazwisko + '\'' +
                ", imie='" + imie + '\'' +
                ", dataUrodzenia=" + dataUrodzenia +
                ", adres='" + adres + '\'' +
                ", pesel='" + pesel + '\'' +
                '}';
    }
    
    public void addRecepcjonistka(Connection con) {
    	String query = "INSERT INTO recepcjonistka(idrecepcjonistki, nazwisko, imie, dataurodzenia, adres, pesel) VALUES(?,?,?,?,?,?)";
    	/*
    	try (PreparedStatement pst = con.prepareStatement(query)) {
              pst.setInt(1, id);
              pst.setString(2, nazwisko);
              pst.setString(3, imie);
              pst.setDate(4, dataUrodzenia);
              pst.setString(5, adres);
              pst.setString(6, pesel);
              
              pst.executeUpdate();

          } catch (SQLException ex) {
              ex.printStackTrace();
          }
          */
    	System.out.println(this.toString());
    }
}
