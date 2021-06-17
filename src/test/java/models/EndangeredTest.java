package models;

import junit.framework.TestCase;
import org.junit.Test;

public class EndangeredTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    @Test
    public void returnInstancesOfEndangered_true() throws Exception{
        Endangered newEndangered=new Endangered("white Rhino",1,true,"Okay","YoungOne");
        assertEquals(true,newEndangered instanceof Endangered);
    }

    @Test
    public void returnNameOfEndangered_String() throws Exception{
        Endangered newEndangered=new Endangered("white Rhino",1,true,"Okay","YoungOne");
        assertEquals("Rhino",newEndangered.getName());
    }

    @Test
    public void returnIdOfEndangered_int() throws Exception{
        Endangered newEndangered=new Endangered("white Rhino",1,true,"Okay","YoungOne");
        assertEquals(1,newEndangered.getId());
    }


    @Test
    public void returnEndangeredOfEndangered_boolean() throws Exception{
        Endangered newEndangered=new Endangered("white Rhino",1,true,"Okay","YoungOne");
        assertEquals(true,newEndangered.isEndangered());
    }


    @Test
    public void returnHealthOfEndangered_String() throws Exception{
        Endangered newEndangered=new Endangered("white Rhino",1,true,"Okay","YoungOne");
        assertEquals("okay",newEndangered.getHealth());
    }

    @Test
    public void returnAgeOfEndangered_String() throws Exception{
        Endangered newEndangered=new Endangered("white Rhino",1,true,"Okay","YoungOne");
        assertEquals(20,newEndangered.getAge());
    }

    @Test
    public void saveEndangeredToDatabase() throws Exception{
        Endangered newEndangered=new Endangered("white Rhino",1,true,"Okay","YoungOne");
        newEndangered.save();
        assertTrue(Endangered.all().get(1).equals(newEndangered));

    }

    @Test
    public void returnAllInstancesOfEndangered() throws Exception{
        Endangered newEndangered=new Endangered("white Rhino",1,true,"Okay","YoungOne");
        Endangered newestEndangered=new Endangered("Impala",2,true,"Okay","NewBorn");
        assertEquals(true,Endangered.all().get(1).equals(newEndangered));
        assertEquals(true,Endangered.all().get(2).equals(newestEndangered));

    }

}