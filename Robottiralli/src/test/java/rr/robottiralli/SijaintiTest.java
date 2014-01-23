package rr.robottiralli;



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
        sijainti.setX(2);
        sijainti.setY(3);
        assertEquals(2,sijainti.getX());
        assertEquals(3,sijainti.getY());
    }
    @Test
    public void Ylosliikkuminen(){
        sijainti.ylospain(2);
        assertEquals(13,sijainti.getY());
    }
    @Test
    public void alasliikkuminen(){
        sijainti.alaspain(1);
        assertEquals(10,sijainti.getY());
    }
    @Test
    public void oikealleliike(){
        sijainti.oikealle(3);
        assertEquals(13, sijainti.getX());
    }
    @Test
    public void vasemmalleliikkuminne(){
        sijainti.vasemmalle(4);
        assertEquals(6,sijainti.getX());
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
    
    
}
