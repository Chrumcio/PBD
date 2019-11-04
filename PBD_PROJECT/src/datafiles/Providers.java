package datafiles;

import Consty.CONST;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Providers {
    private List<String> listOfProviders = new ArrayList<>();

    public List<String> setListOfProviders() throws IOException {
        File file = new File(CONST.providerUrl);
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));;
        String provider;
        while((provider = reader.readLine()) != null){
            listOfProviders.add(provider);
        }
        return listOfProviders;
    }
}
