
package logiikka.robottiralli.lautaelementit;

import logiikka.robottiralli.lautaelementtienhallinta.Ruutu;
import logiikka.robottiralli.robottienhallinta.Robotti;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TyonninTest {
    
    Tyonnin tyonnin;
    Ruutu ruutu;
    Robotti robo;
    
    @Before
    public void setUp() {
        ruutu=new Ruutu(2,2);
        tyonnin=new Tyonnin(new Ruutu(2,1),2,2);
        robo=new Robotti(ruutu,0);
        ruutu.setRobotti(robo);
    }
    
    @Test
    public void tyyppiOikea(){
        assertEquals("tyonnin",tyonnin.tyyppi());
    }
    
    @Test
    public void tyontaa(){
        tyonnin.aktivoidu(robo, 2);
        assertEquals(robo.getRuutu(),new Ruutu(2,1));
    }
    @Test 
    public void Erikoisint(){
        assertEquals(2,tyonnin.getGrafiikkaluku());
    }
    
}
