import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import Consty.CONST;
import Entity.Diagnostyka;
import Entity.Lekarstwo;
import Entity.Przyrzad_Medyczny;
import datafiles.Medicines;
import draw.*;


public class Main {
    private static List<String> listOfCodes = new ArrayList<>();
    private static List<String> listOfNames = new ArrayList<>();
    private static List<String> listOfInstumentsName = new ArrayList<>();

    public static void setListOfDiagnosis() throws IOException {
        File file = new File(CONST.diagnosisUrl);
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
        String line;
        while((line = reader.readLine()) != null){
            listOfCodes.add(line.substring(0,4));
            listOfNames.add(line.substring(4));
        }
    }

    public static void setListOfInstruments() throws IOException{
        File file = new File(CONST.instrumentsUrl);
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
        String line;
        while((line = reader.readLine()) != null){
            listOfInstumentsName.add(line);
        }
    }

    public static void main(String[] args) throws SQLException, IOException {
        String url = CONST.url;
        String user = CONST.user;
        String password = CONST.haslo;
        Connection connection = DriverManager.getConnection(url,user,password);

//        DrawRoom drawRoom = new DrawRoom(url, user, password);
//        drawRoom.addRoom(80);
//        DoctorDraw doctorDraw = new DoctorDraw(url,user,password);
//        doctorDraw.addDoctor(100);
//        MedicineDraw medicineDraw = new MedicineDraw(url,user,password);
//        medicineDraw.addMedicine(200);
//        NurseDraw nurseDraw = new NurseDraw(url,user,password);
//        nurseDraw.addNurse(50);
//        PatientDraw patientDraw = new PatientDraw(url,user,password);
//        patientDraw.addPatient(50000);
//        ProviderDraw providerDraw = new ProviderDraw(url,user,password);
//        providerDraw.addProvider(20);
//        RecepcionistsDraw.randRecepcjonistka(20);
        setListOfDiagnosis();
        for(int i=0;i<800;i++) {
            Diagnostyka diagnostyka = new Diagnostyka();
            int rand = (int) (Math.random()*899)+1;
            try {
                diagnostyka.setIdDiagnostyki(listOfCodes.get(rand));
                diagnostyka.setNazwaDiagnostyki(listOfNames.get(rand));
                diagnostyka.addDiagnostyka(connection);
            }catch (Exception e){

            }
        }
        setListOfInstruments();
        for(int i=0;i<listOfInstumentsName.size();i++){
            Przyrzad_Medyczny przyrzadMedyczny = new Przyrzad_Medyczny();
            przyrzadMedyczny.setId(i);
            przyrzadMedyczny.setNazwa(listOfInstumentsName.get((int)Math.random()*listOfInstumentsName.size()));
            przyrzadMedyczny.addPrzyrzad_Medyczny(connection);
        }
    }
}