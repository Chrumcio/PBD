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

public class Streets {
    private List<String> listOfStreets = new ArrayList<>();

    public List<String> setListOfStreets() throws IOException {
        File file = new File(CONST.streetsUrl);
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));;
        String street;
        while((street = reader.readLine()) != null){
            listOfStreets.add(street);
        }
        return listOfStreets;
    }

}
