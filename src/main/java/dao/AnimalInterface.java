package dao;

import models.Animal;

import java.util.List;

public interface AnimalInterface {
    void save();

    //CREATE
    void add(Animal newAnimal);

    //UPDATE
    void updateName(int id,String name);

    void setId(int id);

    //    // LIST
    //List<Animal> all();
//    // READ
    static Animal findById(int id) {
        return null;
    }
//
//    // DELETE
    void delete(int id);
//    void clearAllTasks();

}
