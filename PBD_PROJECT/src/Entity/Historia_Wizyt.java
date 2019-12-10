package Entity;

import java.sql.*;

public class Historia_Wizyt {

    private int row_key;
    private int id;
    private Date data;
    private Timestamp createDate;
    private Time time;
    private String rodzaj;
    private int idStatusu;
    private int idPielegniarki;
    private int idLekarza;
    private int gabinet;
    private int idRecepty;
    private int idRecepcjonistki;
    private int idPacjenta;
    private String idDiagnostyki;
    private String komenatrz;

    public Historia_Wizyt() {
    }

    public Historia_Wizyt(int id, Date data, Time time, String rodzaj, int idStatusu, int idPielegniarki, int idLekarza,
                          int gabinet, int idRecepty, int idRecepcjonistki, int idPacjenta
            , String idDiagnostyki, String komenatrz, int row_key, Timestamp createDate) {
        this.row_key = row_key;
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
        this.idDiagnostyki = idDiagnostyki;
        this.komenatrz = komenatrz;
        this.createDate = createDate;
    }

    public int getRow_key() {
        return row_key;
    }

    public void setRow_key(int row_key) {
        this.row_key = row_key;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
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

    public String getKomenatrz() {
        return komenatrz;
    }

    public void setKomenatrz(String komenatrz) {
        this.komenatrz = komenatrz;
    }

    public String getIdDiagnostyki() {
        return idDiagnostyki;
    }

    public void setIdDiagnostyki(String idDiagnostyki) {
        this.idDiagnostyki = idDiagnostyki;
    }

    @Override
    public String toString() {
        return "Wizyta{" +
                "row_key="+ row_key+
                "id=" + id +
                "create_date=" + createDate+
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
                ", idDiagnostyki=" + idDiagnostyki +
                '}';
    }

    public void addHistoriaWizyty(Connection connection) throws SQLException {
        String query = "INSERT INTO historia_wizyt(idwizyty, datawizyty ,godzinawizyty ," +
                "rodzajwizyty ,idstatusu ,idpielegniarki ,idlekarza ,numergabinetu ," +
                "idrecepty ,idrecepcjonistki ,idpacjenta,iddiagnostyki, komentarz, row_key, create_date) " +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.setDate(2, data);
        preparedStatement.setTime(3,time);
        preparedStatement.setString(4, rodzaj);
        preparedStatement.setInt(5,idStatusu);
        preparedStatement.setInt(6,idPielegniarki);
        preparedStatement.setInt(7,idLekarza);
        preparedStatement.setInt(8,gabinet);
        preparedStatement.setInt(9,idRecepty);
        preparedStatement.setInt(10,idRecepcjonistki);
        preparedStatement.setInt(11,idPacjenta);
        preparedStatement.setString(13,idDiagnostyki);
        preparedStatement.setString(12, komenatrz);
        preparedStatement.setInt(14,row_key);
        preparedStatement.setTimestamp(15,createDate);
        preparedStatement.executeUpdate();
        System.out.println(this.toString());
    }


}
