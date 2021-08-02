package backend;

import javafx.scene.effect.Bloom;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class CSVLoader {
    FileReader fileReader;

    private ArrayList<String>  CSVString = new ArrayList<>();

    public void setCSVString(ArrayList<String> CSVString) {
        this.CSVString = CSVString;
    }

    public ArrayList<String> getCSVString() {
        return CSVString;
    }

    public CSVLoader(String path) {
       fileReader = null; //read csv file
        try {
            fileReader = new FileReader(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void readCSV(){
        BufferedReader csvReader = new BufferedReader(fileReader);
        String row;
        while(true){
            try {
                if((row= csvReader.readLine())!=null) {
                    CSVString.add(row);
                }
                else {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            //System.out.println(row);
        }
    }

    protected void writeCSV(String csvData){
        readCSV();
        this.getCSVString().add(csvData);
        try {
            FileWriter fileWriter=new FileWriter("src/resources/files/details.csv");
            for(String row:getCSVString()){
                fileWriter.write(row+"\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
