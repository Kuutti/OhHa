package rr.robottiralli;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class SuuntaTest {
   
    Suunta suunta;
    
    
    @Before
    public void setUp() {
        suunta=new Suunta(4);
    }
    
     @Test
     public void TestaaKonstruktori() {
     assertEquals(0,suunta.getX());}
     
     @Test
     public void TestaaOikeallekaannos(){
         suunta.kaannyOikealle();
         assertEquals(1,suunta.getX());
     }
     @Test
     public void TestaaVasemmallekaannos(){
         suunta.kaannyVasemmalle();
         assertEquals(3,suunta.getX());
     }
     @Test
     public void Ukaannos(){
         suunta.uKaannos();
         assertEquals(2,suunta.getX());
     }
     @Test
     public void VertaaNull(){
         assertEquals(false, suunta.equals(null));
     }
     @Test
     public void VertaaEriLuokkaan(){
         assertEquals(false,suunta.equals(2));
     }
     @Test
     public void VertaaEriSuuntaan(){
         assertEquals(false,suunta.equals(new Suunta(2)));
     }
     
}
