package backend;

import javafx.scene.effect.Bloom;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CSVLoader {
    private ArrayList<String>  CSVString=new ArrayList<>();
    private HashMap<String,String> loginMap;

    public CSVLoader() throws IOException {
        FileReader fileReader = null; //read csv file
        try {
            fileReader = new FileReader("src/resources/files/details.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader csvReader = new BufferedReader(fileReader);
        String row;
        while((row= csvReader.readLine())!=null){
            CSVString.add(row);
            //System.out.println(row);
        }
    }

    public HashMap<String,String> loadLoginDetails(){
        loginMap =new HashMap<>();
         for(String row:CSVString){
             String[]  detail=row.split(",");
             loginMap.put(detail[0],detail[1]);
         }
         return loginMap;

    }



}