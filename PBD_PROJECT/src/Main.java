import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import Consty.CONST;
import Entity.*;
import datafiles.Medicines;
import draw.*;
import update.UpdateVisit;


public class Main {
    private static List<String> listOfCodes = new ArrayList<>();
    private static List<String> listOfNames = new ArrayList<>();
    private static List<String> listOfInstumentsName = new ArrayList<>();
    private static List<String> listofStatus = new ArrayList<>();
    private static List<String> amount = new ArrayList<>();
    private static List<String> percent = new ArrayList<>();

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

    public static void setListofStatus() throws IOException{
        File file = new File(CONST.statusUrl);
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
        String line;
        while((line = reader.readLine()) != null){
            listofStatus.add(line);
        }
    }

    public static void setAmount() throws IOException{
        File file = new File(CONST.amountOfMedicine);
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String line;
        while((line = reader.readLine()) != null){
            amount.add(line);
        }
    }

    public static void setPercent() throws IOException{
        File file = new File(CONST.Percents);
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String line;
        while((line = reader.readLine()) != null){
            percent.add(line);
        }
    }

    public static void main(String[] args) throws SQLException, IOException {
        String url = CONST.url;
        String user = CONST.user;
        String password = CONST.haslo;
        Connection connection = DriverManager.getConnection(url,user,password);

        UpdateVisit updateVisit = new UpdateVisit(connection);
        Date date = new Date(2012,12,12);
        updateVisit.updateWizytaDate(1,date);
//        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM przyrzad_medyczny");
//        preparedStatement.execute();

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

//        RecepcionistsDraw.addRecepcjonistka(20, url, user, password);
//
//
//        setListOfDiagnosis();
//        for(int i=0;i<800;i++) {
//            Diagnostyka diagnostyka = new Diagnostyka();
//            int rand = (int) (Math.random()*899)+1;
//            try {
//                diagnostyka.setIdDiagnostyki(listOfCodes.get(rand));
//                diagnostyka.setNazwaDiagnostyki(listOfNames.get(rand));
//                diagnostyka.addDiagnostyka(connection);
//            }catch (Exception e){
//
//            }
//        }
//        setListOfInstruments();
//        for(int i=1;i<listOfInstumentsName.size();i++){
//            Przyrzad_Medyczny przyrzadMedyczny = new Przyrzad_Medyczny();
//            przyrzadMedyczny.setId(i);
//            int rand = (int)(Math.random()*listOfInstumentsName.size());
//            String nazwa = listOfInstumentsName.get(rand);
//            przyrzadMedyczny.setNazwa(nazwa);
//            przyrzadMedyczny.addPrzyrzad_Medyczny(connection);
//        }
//        PrescriptionAdd prescriptionAdd = new PrescriptionAdd(url,user,password);
//        prescriptionAdd.addPrescription(1000);
//        SpecializationsAdd specializationsAdd = new SpecializationsAdd(url,user,password);
//        specializationsAdd.addSpecializations();
//        SupplyAdd supplyAdd = new SupplyAdd(url,user,password);
//        try {
//            supplyAdd.addSupply(50000);
//        }catch (Exception e){
//
//        }
//        setListofStatus();
//        for(int i=0;i<listofStatus.size();i++){
//            Status status = new Status();
//            status.setId(i);
//            status.setNazwa(listofStatus.get(i));
//            status.addStatus(connection);
//        }
//
//        Dostawca_Przyrzadu dostawcaPrzyrzadu = new Dostawca_Przyrzadu();
//        for(int i=1;i<1000;i++) {
//            try {
//                dostawcaPrzyrzadu.setIdDostawcy((int) (Math.random() * 40));
//                dostawcaPrzyrzadu.setIdPrzyrzadu((int) (Math.random() * 152));
//                dostawcaPrzyrzadu.addDostawca_Przyrzadu(connection);
//            }catch (Exception e ){
//
//            }
//        }
//        Specjalizacje_Lekarskie specjalizacjeLekarskie = new Specjalizacje_Lekarskie();
//        for(int i=1;i<84;i++){
//            try {
//                specjalizacjeLekarskie.setIdLek(i);
//                specjalizacjeLekarskie.setIdSpecj((int)(Math.random()*84));
//                specjalizacjeLekarskie.addSpecjalizacje_Lekarskie(connection);
//            }catch (Exception e){
//
//            }
//        }
//        setAmount();
//        setPercent();
//        Wytyczne wytyczne = new Wytyczne();
//        for(int i=1;i<10000;i++) {
//            try {
//                int lek = (int) (Math.random() * 599 + 1);
//                wytyczne.setIdLekarstwa(lek);
//                int rec = (int) (Math.random() * 14000 + 1);
//                wytyczne.setIdRecepty(rec);
//                wytyczne.setIloscLeku(amount.get((int) (Math.random() * 39 + 1)));
//                wytyczne.setOdplatnosc(percent.get((int) (Math.random() * 19 + 1)));
//                wytyczne.addWytyczne(connection);
//            }catch (Exception e){
//
//            }
//        }

//        VisitDraw visitDraw = new VisitDraw(url, user, password);
//        visitDraw.addVisit(100000);
    }
}