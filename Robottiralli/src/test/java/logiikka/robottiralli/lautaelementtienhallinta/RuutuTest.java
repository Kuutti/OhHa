package logiikka.robottiralli.lautaelementtienhallinta;



import logiikka.robottiralli.lautaelementtienhallinta.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class SijaintiTest {
    
    public SijaintiTest() {
    }
    
    Sijainti sijainti;
    
    @Before
    public void setUp() {
        sijainti=new Sijainti(10,11);
    }
    
    @Test
    public void konstruktorijagetterit(){
        assertEquals(10,sijainti.getX());
        assertEquals(11,sijainti.getY());
    }
    @Test
    public void setterit(){
        sijainti.asetaSijainti(2,3);
        assertEquals(2,sijainti.getX());
        assertEquals(3,sijainti.getY());
    }
    @Test
    public void VerrataanKunXEri(){
        assertEquals(false, sijainti.equals(new Sijainti(9,11)));
    }
    @Test
    public void VerrataanNull(){
        assertEquals(false, sijainti.equals(null));
    }
    @Test 
    public void VerrataanVaaraanLuokkaan(){
        assertEquals(false, sijainti.equals(2));
    }
    @Test
    public void VerrataanKunYEri(){
        assertEquals(false, sijainti.equals(new Sijainti(10,10)));
    }
    @Test 
    public void tostring(){
        assertEquals("Sijainti 10,11",sijainti.toString());
    }
    
}
