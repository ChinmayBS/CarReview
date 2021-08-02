package backend;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class LoginDetailsLoader extends CSVLoader{
    private HashMap<String,String> loginMap;

    public LoginDetailsLoader(String path){
        super(path);
    }

    public HashMap<String,String> loadLoginDetails(){
        readCSV();
        loginMap =new HashMap<>();
        for(String row:getCSVString()){
            String[]  detail=row.split(",");
            loginMap.put(detail[0],detail[1]);
        }
        return loginMap;
    }

    public void updateSignupDetails(String csvData) throws IOException {
        writeCSV(csvData);
    }
}
