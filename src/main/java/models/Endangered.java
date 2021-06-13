package models;

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
}
