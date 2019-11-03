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


public class Names {
    private List<String> listOfNames = new ArrayList<>();

    public List<String> setListOfNames() throws IOException {
        File file = new File(CONST.namesUrl);
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));;
        String name;
        while((name = reader.readLine()) != null){
            listOfNames.add(name);
        }
        return listOfNames;
    }
}
