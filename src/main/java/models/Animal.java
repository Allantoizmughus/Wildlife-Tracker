package models;

import dao.AnimalInterface;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;

public class Animal implements AnimalInterface {
    public String name;
    public int id;

    public Animal(String name,int id){
        this.name=name;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object otherAnimal) {
        if(!(otherAnimal instanceof Animal)) {
            return false;
        } else {
            Animal newAnimal = (Animal) otherAnimal;
            return this.getName().equals(newAnimal.getName());
        }
    }

    @Override
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name) VALUES (:name);";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .executeUpdate()
                    .getKey();
        }
    }

    @Override
    public void add(Animal newAnimal) {

        String sql = "INSERT INTO animals (name,id) VALUES (:name, :id)"; //raw sql
        try(Connection con = DB.sql2o.open()){ //try to open a connection
            int id = (int) con.createQuery(sql, true) //make a new variable
                    .addParameter("name",this.name)
                    .addParameter("id",this.id)
                    .bind(newAnimal)
                    .executeUpdate() //run it all
                    .getKey(); //int id is now the row number (row “key”) of db
            newAnimal.setId(id); //update object to set id now from database)
        } catch (Sql2oException ex) {
            System.out.println(ex); //oops we have an error!
        }
    }

    @Override
    public void setId(int id) {

    }

    @Override
    public void delete(int id) {

        try(Connection con = DB.sql2o.open()) {
            String sql = "DELETE FROM animals WHERE id = :id;";
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

    public static List<Animal> all() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals;";
            return con.createQuery(sql)
                    .executeAndFetch(Animal.class);
        }
    }

    public static Animal findById(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals WHERE id = :id;";
            Animal animal = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Animal.class);
            return animal;
        } catch (IndexOutOfBoundsException exception) {
            return null;
        }
    }

    public void updateName(int id,String name) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "UPDATE animals SET name = :name WHERE id = :id;";
            con.createQuery(sql)
                    .addParameter("id", id)
                    .addParameter("name", name)
                    .executeUpdate();
        }catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

//    public void delete() {
//        try(Connection con = sql2o.open()) {
//            String sql = "DELETE FROM animals WHERE id = :id;";
//            con.createQuery(sql)
//                    .addParameter("id", id)
//                    .executeUpdate();
//        }catch (Sql2oException ex) {
//            System.out.println(ex);
//        }
//    }

    public List<Sighting> getSightings() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings WHERE animal_id = :id;";
            List<Sighting> sightings = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetch(Sighting.class);
            return sightings;
        }
    }

}
