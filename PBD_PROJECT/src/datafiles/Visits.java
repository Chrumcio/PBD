package datafiles;

import Consty.CONST;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Visits {
    private List<String> listOfVisits = new ArrayList<>();

    public List<String> setListOfSurnames() throws IOException {
        File file = new File(CONST.typeOfVisitsUrl);
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));;
        String visit;
        while((visit = reader.readLine()) != null){
            listOfVisits.add(visit);
        }
        return listOfVisits;
    }
}
