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
    public void returnInstancesOfEndangered_true(){
        Endangered newEndangered=new Endangered("white Rhino",1,true,"Okay",20);
        assertEquals(true,newEndangered instanceof Endangered);
    }

    @Test
    public void returnNameOfEndangered_String(){
        Endangered newEndangered=new Endangered("white Rhino",1,true,"Okay",20);
        assertEquals("Rhino",newEndangered.getName());
    }

    @Test
    public void returnIdOfEndangered_int(){
        Endangered newEndangered=new Endangered("white Rhino",1,true,"Okay",20);
        assertEquals(1,newEndangered.getId());
    }


    @Test
    public void returnEndangeredOfEndangered_boolean(){
        Endangered newEndangered=new Endangered("white Rhino",1,true,"Okay",20);
        assertEquals(true,newEndangered.isEndangered());
    }


    @Test
    public void returnHealthOfEndangered_String(){
        Endangered newEndangered=new Endangered("white Rhino",1,true,"Okay",20);
        assertEquals("okay",newEndangered.getHealth());
    }

    @Test
    public void returnAgeOfEndangered_String(){
        Endangered newEndangered=new Endangered("white Rhino",1,true,"Okay",20);
        assertEquals(20,newEndangered.getAge());
    }

    @Test
    public void saveEndangeredToDatabase(){
        Endangered newEndangered=new Endangered("white Rhino",1,true,"Okay",20);
        newEndangered.save();
        assertTrue(Endangered.all().get(1).equals(newEndangered));

    }

    @Test
    public void returnAllInstancesOfEndangered(){
        Endangered newEndangered=new Endangered("white Rhino",1,true,"Okay",20);
        Endangered newestEndangered=new Endangered("Impala",2,true,"Okay",10);
        assertEquals(true,Endangered.all().get(1).equals(newEndangered));
        assertEquals(true,Endangered.all().get(2).equals(newestEndangered));

    }

}