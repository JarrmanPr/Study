package traininfo;

import java.io.*;

public class Test {

    public static void main(String args[])throws IOException, ClassNotFoundException {

        // инициализирующая часть
        Route routes[] = new Route[4];

        /*routes[0] = new Route(1223,"Днепр", "Киев",
                "17:40", "01:10", "Пассажирский");
        routes[1] = new Route(1545,"Покровск", "Киев",
                "07:30", "12:30", "Скорый");
        routes[2] = new Route(2310,"Днепр", "Харьков",
                "13:20", "21:30", "Пассажирский");
        routes[3] = new Route(1478,"Мариуполь", "Львов",
                "07:15", "05:20", "Пассажирский");

        try(ObjectOutputStream objOut =
                new ObjectOutputStream(new FileOutputStream("Routes.txt"))) {

            objOut.writeObject(routes);
        } catch(IOException ex){
            System.out.println("Ошибка ввода/вывода");
        }

        routes = null;*/
        // конец инициализирующей части

        // начало программы

        /*try(ObjectInputStream objIn =
                    new ObjectInputStream(new FileInputStream("Routes.txt"))){
            routes = (Route[]) objIn.readObject();

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String passengerDestination = "";
            System.out.print("Введите пункт назначения: ");
            passengerDestination = reader.readLine();
            boolean trainFound = false;

            for(int i = 0 ; i < routes.length; i++){
                if(routes[i].getArrivalStation().equals(passengerDestination)) {
                    trainFound = true;
                    System.out.println("Для конечного пункта " + passengerDestination +
                            " найдены следующие поезда:");
                    System.out.println("Номер поезда: " + routes[i].getTrainNumber());
                    System.out.println("Станция отправления: " + routes[i].getDepartureStation());
                    System.out.println("Станция прибытия: " + routes[i].getArrivalStation());
                    System.out.println("Время отправления: " + routes[i].getDepartureTime());
                    System.out.println("Время прибытия: " + routes[i].getArrivalTime());
                    System.out.println("Тип поезда: " + routes[i].getTrainType());
                    System.out.println("");
                }
            }

            if(!trainFound){
                System.out.println("В системе отсутствуют маршруты для данного направления");
            }

        } catch(FileNotFoundException ex){
            System.out.println("Файл Routes.txt не найден");
        } catch(ClassCastException ex){
            System.out.println("Нужный класс в файле Routes.txt не найден");
        }*/
    }
}
