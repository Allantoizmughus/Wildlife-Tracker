package models;

import junit.framework.TestCase;
import org.junit.Test;

import java.sql.Timestamp;

public class SightingTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    @Test
    public void returnInstancesOfSighting() throws Exception{
        Sighting newSighting=new Sighting(1,"River","Kulu",1);
        assertEquals(true,newSighting instanceof Sighting);
    }

    @Test
    public void returnAnimal_IdOfSighting_int(){
        Sighting newSighting=new Sighting(1,"River","Kulu",1);
        assertEquals(1,newSighting.getAnimal_id());
    }

}