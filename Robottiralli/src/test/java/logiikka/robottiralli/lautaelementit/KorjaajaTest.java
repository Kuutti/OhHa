
package logiikka.robottiralli.lautaelementit;

import logiikka.robottiralli.lautaelementtienhallinta.Ruutu;
import logiikka.robottiralli.robottienhallinta.Robotti;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KorjaajaTest {
    
    Korjaaja korjaaja;
    Ruutu ruutu;
    Robotti robo;
    
    @Before
    public void setUp() {
        ruutu=new Ruutu(3,3);
        korjaaja=new Korjaaja(2);
        ruutu.lisaaElementti(korjaaja);
        robo=new Robotti(ruutu,2);
        ruutu.setRobotti(robo);
        robo.setRespawn(new Ruutu(3,2));
    }
    
    @Test
    public void tyyppiOikein(){
        assertEquals("korjaaja",korjaaja.tyyppi());
    }
    
    @Test
    public void korjaa(){
        robo.otaVahinkoa(4);
        korjaaja.aktivoidu(robo, 5);
        assertEquals(2,robo.getVahinko());
    }
    
    @Test
    public void korjausget(){
        assertEquals(2,korjaaja.getGrafiikkaluku());
    }
    
    @Test
    public void Respawntarkistus(){
        korjaaja.aktivoidu(robo, 5);
        assertEquals(ruutu,robo.getRespawn());
    }
    
    
    

}
