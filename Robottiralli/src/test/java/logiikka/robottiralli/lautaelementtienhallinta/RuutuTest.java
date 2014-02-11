package logiikka.robottiralli.lautaelementtienhallinta;



import logiikka.robottiralli.lautaelementtienhallinta.*;
import logiikka.robottiralli.robottienhallinta.Robotti;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class RuutuTest {
    
    public RuutuTest() {
    }
    
    Ruutu sijainti;
    
    @Before
    public void setUp() {
        sijainti=new Ruutu(10,11);
    }
    
    @Test
    public void konstruktorijagetterit(){
        assertEquals(10,sijainti.getX());
        assertEquals(11,sijainti.getY());
    }

    @Test
    public void VerrataanKunXEri(){
        assertEquals(false, sijainti.equals(new Ruutu(9,11)));
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
        assertEquals(false, sijainti.equals(new Ruutu(10,10)));
    }
    @Test 
    public void tostring(){
        assertEquals("Sijainti 10,11",sijainti.toString());
    }
    
    @Test
    public void Hashkoodia(){
        assertEquals(43767,new Ruutu(1,1).hashCode());
    }
    
    @Test
    public void holorobonLisaysjapoisto(){
        Robotti robo=new Robotti(sijainti,1);
        sijainti.lisaaholorobo(robo);
        sijainti.poistaholorobo(robo);
        assertEquals(false,sijainti.holorobot.contains(robo));
    }
    
    
    
}
