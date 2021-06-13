package models;

import junit.framework.TestCase;
import org.junit.Test;

public class AnimalTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    @Test
    public void returnAllInstancesOfAnimal_true(){
        Animal newAnimal=new Animal("Lion");
        assertEquals(true, newAnimal instanceof Animal);
    }

    @Test
    public void returnNameOfAnimal_String(){
        Animal newAnimal=new Animal("Lion");
        assertEquals("Lion", newAnimal.getName());

    }
    @Test
    public void returnIdOfAnimal_int(){
        Animal newAnimal=new Animal("Lion");
        assertEquals(1,newAnimal.getId());
    }

    @Test
    public void saveAnimalToDatabase(){
        Animal newAnimal=new Animal("Lion");
        newAnimal.save();
        assertTrue(Animal.all().get(0).equals(newAnimal));

    }

    @Test
    public void returnsAllInstancesOfAnimal_true(){
        Animal newAnimal=new Animal("Lion");
        Animal newestAnimal=new Animal("Lioness");
        assertEquals(true,Animal.all().get(0).equals(newAnimal));
        assertEquals(true,Animal.all().get(1).equals(newestAnimal));

    }

    @Test
    public void findAnimalWithId(){
        Animal newAnimal=new Animal("Lion");
        newAnimal.save();
        Animal newestAnimal=new Animal("Lioness");
        newestAnimal.save();
        assertEquals(Animal.find(newestAnimal.getId()),newestAnimal);
    }

    @Test
    public void deleteAnimal_true(){
        Animal newAnimal=new Animal("Lion");
        newAnimal.save();
        newAnimal.delete();
        assertEquals(null,Animal.find(newAnimal.getId()));

    }

}