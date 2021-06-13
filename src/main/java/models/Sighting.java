package models;

import dao.SightingInterface;
import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.List;

public class Sighting implements SightingInterface {
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

    @Override
    public boolean equals(Object otherSighting) {
        if(!(otherSighting instanceof Sighting)) {
            return false;
        } else {
            Sighting newSighting = (Sighting) otherSighting;
            return this.getAnimal_id() == (newSighting.getAnimal_id()) && this.getLocation().equals(newSighting.getLocation()) && this.getRangerName().equals(newSighting.getRangerName());
        }
    }

    @Override
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings (animal_id, location, rangerName, date) VALUES (:animal_id, :location, :rangerName, now());";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("animal_id", this.animal_id)
                    .addParameter("location", this.location)
                    .addParameter("rangerName", this.RangerName)
                    .throwOnMappingFailure(false)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<Sighting> all() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings;";
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Sighting.class);
        }
    }
}
