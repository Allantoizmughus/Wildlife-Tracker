//package models;
//
//import junit.framework.TestCase;
//import org.junit.Test;
//
//import java.sql.Timestamp;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
//public class SightingTest {
//
//    public void setUp() throws Exception {
//    }
//
//    public void tearDown() throws Exception {
//    }
//
//    @Test
//    public void returnInstancesOfSighting() throws Exception{
//        Sighting newSighting=new Sighting(1,"River","Kulu",1);
//        assertEquals(true,newSighting instanceof Sighting);
//    }
//
//    @Test
//    public void returnAnimal_IdOfSighting_int(){
//        Sighting newSighting=new Sighting(1,"River","Kulu",1);
//        assertEquals(1,newSighting.getAnimal_id());
//    }
//
//    @Test
//    public void returnLocationOfSighting_String(){
//        Sighting newSighting=new Sighting(1,"River","Kulu",1);
//        assertEquals("River",newSighting.getLocation());
//    }
//
//    @Test
//    public void returnRangerNameOfSighting_String(){
//        Sighting newSighting=new Sighting(1,"River","Kulu",1);
//        assertEquals("Kulu",newSighting.getRangerName());
//    }
//
//    @Test
//    public void returnIdOfSighting_int(){
//        Sighting newSighting=new Sighting(1,"River","Kulu",1);
//        assertEquals(1,newSighting.getId());
//    }
//
//    @Test
//    public void saveSightingToDatabase(){
//        Sighting newSighting=new Sighting(1,"River","Kulu",1);
//        newSighting.save();
//        assertTrue(Sighting.all().get(1).equals(newSighting));
//
//    }
//
//
//
//    @Test
//    public void returnAllInstancesOfSighting(){
//        Sighting newSighting=new Sighting(1,"River","Kulu",1);
//        Sighting newestSighting=new Sighting(2,"BlackForest","Nana",2);
//        assertEquals(true,Sighting.all().get(1).equals(newSighting));
//        assertEquals(true,Sighting.all().get(2).equals(newestSighting));
//
//    }
//}