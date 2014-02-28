
package logiikka.robottiralli.lautaelementtienhallinta;

import logiikka.robottiralli.robottienhallinta.Robotti;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LaserTest {
    
    Laser laser;
    Ruutu ruutu;
    Robotti robo;
    
    @Before
    public void setUp() {
        ruutu=new Ruutu(3,3);
        laser=new Laser(ruutu,2);
        robo=new Robotti(ruutu,1);
    }
    
    @Test
    public void luoOikein(){
        assertEquals(new Ruutu(3,3),laser.getRuutu());
        assertEquals(2,laser.getSuunta());
    }
    
}