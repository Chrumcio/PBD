package Entity;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Recepta {
    private int id;
    private Date dataWystawienia;
    private Date dataWaznosci;

    public Recepta() {
    }

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

    public void addRecepta(Connection connection) throws SQLException {
        String query = "INSERT INTO recepta(idrecepty, datawystawienia, datawaznosci) " +
                "VALUES(?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.setDate(2, dataWystawienia);
        preparedStatement.setDate(3, dataWaznosci);
        preparedStatement.executeUpdate();
        System.out.println(this.toString());
    }
}
