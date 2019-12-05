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

public class Cities {
    private List<String> listOfCities = new ArrayList<>();

    public List<String> setListOfCities() throws IOException {
        File file = new File(CONST.citiesUrl);
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));;
        String city;
        while((city = reader.readLine()) != null){
            listOfCities.add(city);
        }
        return listOfCities;
    }

}
