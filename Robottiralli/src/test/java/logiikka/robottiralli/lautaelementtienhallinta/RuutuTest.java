package logiikka.robottiralli.lautaelementtienhallinta;



import logiikka.robottiralli.lautaelementtienhallinta.*;
import logiikka.robottiralli.robottienhallinta.Robotti;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class RuutuTest {
    
    public RuutuTest() {
    }
    
    Ruutu ruutu;
    
    @Before
    public void setUp() {
        ruutu=new Ruutu(10,11);
    }
    
    @Test
    public void konstruktorijagetterit(){
        assertEquals(10,ruutu.getX());
        assertEquals(11,ruutu.getY());
    }

    @Test
    public void VerrataanKunXEri(){
        assertEquals(false, ruutu.equals(new Ruutu(9,11)));
    }
    @Test
    public void VerrataanNull(){
        assertEquals(false, ruutu.equals(null));
    }
    @Test 
    public void VerrataanVaaraanLuokkaan(){
        assertEquals(false, ruutu.equals(2));
    }
    @Test
    public void VerrataanKunYEri(){
        assertEquals(false, ruutu.equals(new Ruutu(10,10)));
    }
    @Test 
    public void tostring(){
        assertEquals("Ruutu 10,11",ruutu.toString());
    }
    
    @Test
    public void Hashkoodia(){
        assertEquals(43767,new Ruutu(1,1).hashCode());
    }
    
    @Test
    public void holorobonLisaysjapoisto(){
        Robotti robo=new Robotti(ruutu,1);
        ruutu.lisaaholorobo(robo);
        ruutu.poistaholorobo(robo);
        assertEquals(false,ruutu.holorobot.contains(robo));
    }
    
    @Test
    public void eiRobottia(){
        assertEquals(false,ruutu.onRobotti());
    }
    
    
}
