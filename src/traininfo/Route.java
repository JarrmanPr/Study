package traininfo;

import java.io.Serializable;

public class Route implements Serializable{

    private int trainNumber;
    private String departureStation;
    private String arrivalStation;
    private String departureTime;
    private String arrivalTime;
    private String trainType;

    public Route(int trainNumber,
                 String departureStation,
                 String arrivalStation,
                 String departureTime,
                 String arrivalTime,
                 String trainType){

        this.trainNumber = trainNumber;
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.trainType = trainType;
    }

    public int getTrainNumber(){
        return trainNumber;
    }

    public String getDepartureStation(){
        return departureStation;
    }

    public String getArrivalStation(){
        return arrivalStation;
    }

    public String getDepartureTime(){
        return departureTime;
    }

    public String getArrivalTime(){
        return arrivalTime;
    }

    public String getTrainType(){
        return trainType;
    }
}
