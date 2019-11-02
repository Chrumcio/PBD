package datafiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Names {
    private List<String> listOfNames = new ArrayList<>();

    public List<String> setListOfNames() throws IOException {
        File file = new File("C:\\Users\\Mateusz\\Documents\\PBD_PROJECT\\src\\names.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String name;
        while((name = reader.readLine()) != null){
            listOfNames.add(name);
        }
        return listOfNames;
    }
}
