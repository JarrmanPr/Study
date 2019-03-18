package studypart1;
import java.io.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException{

        // сериализация объекта
        try(ObjectOutputStream objOut =
                new ObjectOutputStream(new FileOutputStream("C:\\jv\\serial.txt"))){

            MyClass obj_1 = new MyClass("Hello", -7, 2.7e10);
            //System.out.println("object1: " + obj_1);
            MyClass obj_11 = new MyClass("Hello2", -72, 22.7e10);

            objOut.writeObject(obj_1);
            objOut.writeObject(obj_11);

        } catch(IOException e){
            System.out.println("Исключение при сериализации: " + e);
        }

        // десериализация объекта
        try(ObjectInputStream objIn =
                    new ObjectInputStream(new FileInputStream("C:\\jv\\serial.txt"))){

            MyClass obj_2 = (MyClass) objIn.readObject();
            System.out.println("object2: " + obj_2);
            MyClass obj_22 = (MyClass) objIn.readObject();
            System.out.println("object22: " + obj_22);

        } catch(FileNotFoundException | ClassNotFoundException e){
            System.out.println("Исключение при десериализации ClassNotFoundException: ");
        }
        /*finally {
            if(objIn != null){
                objIn.close();
            }

        }*/
    }
}