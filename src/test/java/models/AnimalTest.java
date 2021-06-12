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
        Animal animal=new Animal("Lion");
        assertEquals(true, animal instanceof Animal);
    }

    @Test
    public void returnNameOfAnimal_String(){
        Animal animal=new Animal("Lion");
        assertEquals("Lion", animal.getName());

    }
    @Test
    public void returnIdOfAnimal_int(){
        Animal animal=new Animal("Lion");
        assertEquals(1,animal.getId());
    }

}