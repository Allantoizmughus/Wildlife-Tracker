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

}