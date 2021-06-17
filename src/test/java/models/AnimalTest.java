package models;

import junit.framework.TestCase;
import org.junit.Rule;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class AnimalTest {
    @Rule
    public DatabaseRule databaseRule=new DatabaseRule();
    private Animal animalDao; //ignore me for now. We'll create this soon.
    private Connection conn; //must be sql2o class conn


    public void setUp() throws Exception {
        String connectionString="jdbc:postgresql://localhost:5432/wildlife_tracker_test";
        Sql2o sql2o=new Sql2o(connectionString,"","");
        animalDao=new Animal("lion",0);
        conn = sql2o.open();

    }

    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void returnAllInstancesOfAnimal_true(){
        Animal newAnimal=new Animal("Lion",0);
        assertEquals(true, newAnimal instanceof Animal);
    }

    @Test
    public void returnNameOfAnimal_String(){
        Animal newAnimal=new Animal("Lion",0);
        assertEquals("Lion", newAnimal.getName());

    }
    @Test
    public void returnIdOfAnimal_int(){
        Animal newAnimal=new Animal("Lion",0);
        assertEquals(0,newAnimal.getId());
    }

    @Test
    public void saveAnimalToDatabase(){
        Animal newAnimal=new Animal("Lion",0);
        newAnimal.save();
        assertTrue(Animal.all().get(0).equals(newAnimal));

    }

    @Test
    public void addingSightingSetsId() throws Exception{
        Animal newAnimal=new Animal("Lion",0);
        int originalAnimalId=newAnimal.getId();
        animalDao.add(newAnimal);
        assertNotEquals(originalAnimalId,newAnimal.getId());
    }

    @Test
    public void updateAnimalChanges() throws Exception{
        Animal newAnimal=new Animal("Lion",0);
        animalDao.add(newAnimal);
        animalDao.updateName(newAnimal.getId(),"Zebra");
        Animal updateAnimal=animalDao.findById(newAnimal.getId());
        assertNotEquals(newAnimal,updateAnimal.getName());


    }

    @Test
    public void returnsAllInstancesOfAnimal_true(){
        Animal newAnimal=new Animal("Lion",0);
        Animal newestAnimal=new Animal("Lioness",1);
        assertTrue(Animal.all().contains(newAnimal));
        assertTrue(Animal.all().contains(newestAnimal));

    }

    @Test
    public void findAnimalWithId(){
        Animal newAnimal=new Animal("Lion",0);
        int originalSightingId=newAnimal.getId();
        animalDao.add(newAnimal);
        assertEquals(originalSightingId, animalDao.findById(newAnimal.getId()).getId());


    }



    @Test
    public void deleteAnimal_true(){
        Animal newAnimal=new Animal("Lion",0);
        newAnimal.save();
        newAnimal.delete(4);
        assertEquals(null,Animal.findById(newAnimal.getId()));

    }

}