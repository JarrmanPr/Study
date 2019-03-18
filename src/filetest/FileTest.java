package filetest;

import java.io.*;

public class FileTest {

    public static void main(String args[]) throws IOException{

        File dir = new File("C:\\jav");

        if(!dir.exists()){
            dir.mkdir();
        }

        File file = new File(dir.getPath() + "\\fruits.csv");
        if(!file.exists()){
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file);
        //fw.append("Яблоки");
        fw.append("Yabloki");
        fw.append(";");
        //fw.append("Груши\n");
        fw.append("Grushi\n");
        fw.append("Айдаред");
        fw.append(";");
        fw.append("Дюймовочка\n");
        fw.append("Семеренко");
        fw.append(";");
        fw.append("Лесная красавица\n");
        fw.close();
    }
}
