package dao;

import models.Sighting;

import java.util.List;

public interface SightingInterface {
    // LIST
    List<Sighting> getAll();

    // CREATE
    void add(Sighting sighting);

    // READ
    Sighting findById(int id);

    // UPDATE
    void update(int id, String content);

    // DELETE
    void deleteById(int id);
    void clearAllTasks();
}
