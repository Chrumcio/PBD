package datafiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import Consty.CONST;

public class Specjalizations {
    private List<String> listOfCities = new ArrayList<>();

    public List<String> getListOfSpecjalizations() throws IOException {
        File file = new File(CONST.specjalizationsUrl);
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));;
        String specjalization;
        while((specjalization = reader.readLine()) != null){
            listOfCities.add(specjalization);
        }
        return listOfCities;
    }

}
