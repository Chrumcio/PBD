package datafiles;

import Consty.CONST;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Medicines {
    private List<String> listOfMedicines = new ArrayList<>();

    public List<String> getListOfMedicines() throws IOException {
        File file = new File(CONST.mediciensUrl);
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
        String medicine;
        while((medicine = reader.readLine()) != null){
            listOfMedicines.add(medicine);
        }
        return listOfMedicines;
    }
}
