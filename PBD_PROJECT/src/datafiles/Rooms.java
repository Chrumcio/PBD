package datafiles;

import Consty.CONST;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Rooms {
    private List<String> listOfRooms = new ArrayList<>();

    public List<String> getListOfRooms() throws IOException {
        File file = new File(CONST.typeOfRoomUrl);
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));;
        String room;
        while((room = reader.readLine()) != null){
            listOfRooms.add(room);
        }
        return listOfRooms;
    }
}
