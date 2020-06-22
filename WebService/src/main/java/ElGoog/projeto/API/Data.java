package ElGoog.projeto.API;

import java.util.Date;

public class Data {
    private long id;
    private String date;
    private double value;

    public Data(){};

    public Data(long id, String date, double value){
        this.id = id;
        this.date = date;
        this.value = value;
    }

    public Data(String date, double value){
        this.date = date;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public double getValue() {
        return value;
    }

}
