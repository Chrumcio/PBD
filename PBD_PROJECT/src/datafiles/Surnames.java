package datafiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Surnames {
    private List<String> listOfSurnames = new ArrayList<>();

    public List<String> setListOfSurnames() throws IOException {
        File file = new File("C:\\Users\\Mateusz\\Documents\\PBD_PROJECT\\src\\surnames.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String surname;
        while((surname = reader.readLine()) != null){
            listOfSurnames.add(surname);
        }
        return listOfSurnames;
    }

}
