package models;

import org.sql2o.Connection;

public class Endangered {
    public String name;
    public int id;
    public boolean endangered;
    public String health;
    public int age;

    public Endangered(String name,int id, boolean endangered, String health, int age){
        this.name=name;
        this.id=id;
        this.endangered=endangered;
        this.health=health;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public boolean isEndangered() {
        return endangered;
    }

    public String getHealth() {
        return health;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object otherEndangeredAnimal) {
        if(!(otherEndangeredAnimal instanceof Endangered)) {
            return false;
        } else {
            Endangered newEndangered = (Endangered) otherEndangeredAnimal;
            return this.getName().equals(newEndangered.getName());
        }
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO endangered_animals (name) VALUES (:name);";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .executeUpdate()
                    .getKey();
        }
    }
}
