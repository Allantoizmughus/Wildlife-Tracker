package models;

import junit.framework.TestCase;
import org.junit.Rule;
import org.junit.Test;
import org.sql2o.Connection;

import static org.junit.Assert.*;

public class AnimalTest {
    @Rule
    public DatabaseRule databaseRule=new DatabaseRule();
    private Animal animalDao; //ignore me for now. We'll create this soon.
    private Connection conn; //must be sql2o class conn


    public void setUp() throws Exception {
    }

    public void tearDown() throws Exception {
    }

    @Test
    public void returnAllInstancesOfAnimal_true(){
        Animal newAnimal=new Animal("Lion",1);
        assertEquals(true, newAnimal instanceof Animal);
    }

    @Test
    public void returnNameOfAnimal_String(){
        Animal newAnimal=new Animal("Lion",1);
        assertEquals("Lion", newAnimal.getName());

    }
    @Test
    public void returnIdOfAnimal_int(){
        Animal newAnimal=new Animal("Lion",1);
        assertEquals(1,newAnimal.getId());
    }

    @Test
    public void saveAnimalToDatabase(){
        Animal newAnimal=new Animal("Lion",1);
        newAnimal.save();
        assertTrue(Animal.all().get(1).equals(newAnimal));

    }

    @Test
    public void addingSightingSetsId() throws Exception{
        Animal newAnimal=new Animal("Lion",1);
        int originalAnimalId=newAnimal.getId();
        animalDao.add(newAnimal);
        assertNotEquals(originalAnimalId,newAnimal.getId());
    }

    @Test
    public void updateAnimalChanges() throws Exception{
        Animal newAnimal=new Animal("Lion",1);
        animalDao.add(newAnimal);
        animalDao.updateName(newAnimal.getId(),"Zebra");
        Animal updateAnimal=animalDao.findById(newAnimal.getId());
        assertNotEquals(newAnimal,updateAnimal.getName());


    }

    @Test
    public void returnsAllInstancesOfAnimal_true(){
        Animal newAnimal=new Animal("Lion",1);
        Animal newestAnimal=new Animal("Lioness",2);
        assertEquals(true,Animal.all().get(1).equals(newAnimal));
        assertEquals(true,Animal.all().get(2).equals(newestAnimal));

    }

    @Test
    public void findAnimalWithId(){
        Animal newAnimal=new Animal("Lion",1);
        int originalSightingId=newAnimal.getId();
        animalDao.add(newAnimal);
        assertEquals(originalSightingId, animalDao.findById(newAnimal.getId()).getId());


    }



    @Test
    public void deleteAnimal_true(){
        Animal newAnimal=new Animal("Lion",1);
        newAnimal.save();
        newAnimal.delete(1);
        assertEquals(null,Animal.findById(newAnimal.getId()));

    }

}