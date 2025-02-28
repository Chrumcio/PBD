package datafiles;

import Consty.CONST;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Surnames {
    private List<String> listOfSurnames = new ArrayList<>();

    public List<String> setListOfSurnames() throws IOException {
        File file = new File(CONST.surnamesUrl);
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));;
        String surname;
        while((surname = reader.readLine()) != null){
            listOfSurnames.add(surname);
        }
        return listOfSurnames;
    }

}
