package backend;

import java.util.ArrayList;
import java.util.HashMap;

public class CarDetailsLoader extends CSVLoader{
    public CarDetailsLoader(String path) {
        super(path);
    }

    public ArrayList<String[]> getCarDetails(){
        ArrayList <String[] > cars=new ArrayList<>();

        readCSV();

        String[] rowValues=new String[11];

        for(String row:getCSVString()){
            rowValues=row.split(",");
            cars.add(rowValues);
        }
        return cars;
    }

}
