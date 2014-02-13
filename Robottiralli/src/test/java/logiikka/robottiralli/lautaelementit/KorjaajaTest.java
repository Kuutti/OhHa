/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logiikka.robottiralli.lautaelementit;

import logiikka.robottiralli.lautaelementtienhallinta.Ruutu;
import logiikka.robottiralli.robottienhallinta.Robotti;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author KOTIPC
 */
public class KorjaajaTest {
    
    Korjaaja korjaaja;
    Ruutu ruutu;
    Robotti robo;
    
    @Before
    public void setUp() {
        ruutu=new Ruutu(3,3);
        korjaaja=new Korjaaja(2);
        robo=new Robotti(ruutu,2);
        ruutu.setRobotti(robo);
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
        assertEquals(2,korjaaja.getErikoisint());
    }
    
    @Test
    public void Respawntarkistus(){
        korjaaja.aktivoidu(robo, 5);
        assertEquals(ruutu,robo.getRespawn());
    }
    

}
