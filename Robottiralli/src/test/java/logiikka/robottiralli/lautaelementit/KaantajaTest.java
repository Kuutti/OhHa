
package logiikka.robottiralli.lautaelementit;

import logiikka.robottiralli.lautaelementtienhallinta.Ruutu;
import logiikka.robottiralli.robottienhallinta.Robotti;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KaantajaTest {
    
    Kaantaja kaannin;
    Robotti robo;
    Ruutu ruutu;
    
    @Before
    public void setUp() {
        ruutu=new Ruutu(3,3);
        kaannin=new Kaantaja(1);
        robo=new Robotti(ruutu,2);
        ruutu.setRobotti(robo);
    }
    
    @Test
    public void tyyppiOikein(){
        assertEquals("kaantaja",kaannin.tyyppi());
    }
    
    @Test
    public void kaantaa(){
        kaannin.aktivoidu(robo, 0);
        assertEquals(3,robo.getSuunta());
    }
    
    @Test
    public void tarkistakaannos(){
        assertEquals(1,kaannin.getGrafiikkaluku());
    }
}
