package models;

import dao.SightingInterface;
import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.List;

public class Sighting implements SightingInterface {
//    private final Sql2o sql2o;
//
//    public Sighting(Sql2o sql2o){
//        this.sql2o=sql2o; //making the sql2o object available everywhere so we can call methods in it
//    }
    public int animal_id;
    public String location;
    public String rangerName;
    public int id;
    public Timestamp date;

    public Sighting (int animal_id, String location, String rangerName, int id){
        this.animal_id=animal_id;
        this.location=location;
        this.rangerName=rangerName;
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
        return rangerName;
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
                    .addParameter("rangerName", this.rangerName)
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
