package models;

import java.sql.Timestamp;
import java.util.List;

public class Sighting {
    public int animal_id;
    public String location;
    public String RangerName;
    public int id;
    public Timestamp date;

    public Sighting(int animal_id, String location, String RangerName,int id){
        this.animal_id=animal_id;
        this.location=location;
        this.RangerName=RangerName;
        this.id=id;
        this.date=date;
    }

    public int getAnimal_id() {
        return animal_id;
    }

    public String getLocation() {
        return location;
    }

    public String getRangerName() {
        return RangerName;
    }

    public int getId() {
        return id;
    }

    public Timestamp getDate() {
        return date;
    }
}
