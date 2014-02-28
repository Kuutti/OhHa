
package logiikka.robottiralli.lautaelementit;

import logiikka.robottiralli.lautaelementtienhallinta.Ruutu;
import logiikka.robottiralli.robottienhallinta.Robotti;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KuoppaTest {
    
    Kuoppa kuoppa;
    Ruutu ruutu;
    Robotti robo;
    
    @Before
    public void setUp() {
        ruutu=new Ruutu(3,3);
        kuoppa=new Kuoppa();
        robo=new Robotti(ruutu,2);
        ruutu.setRobotti(robo);
    }
    
    @Test
    public void tyyppiOikein(){
        assertEquals("kuoppa",kuoppa.tyyppi());
    }
    
    @Test
    public void robottiTuhoutuu(){
        robo.setRespawn(new Ruutu(2,2));
        kuoppa.aktivoidu(robo, 2);
        assertEquals(new Ruutu(2,2),robo.getRuutu());
        assertEquals(2,robo.getVahinko());
    }
    
    @Test
    public void Erikoisint(){
        assertEquals(0,kuoppa.getGrafiikkaluku());
    }
    
    
}
