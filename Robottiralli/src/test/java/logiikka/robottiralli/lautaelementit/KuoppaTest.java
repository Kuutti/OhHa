/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logiikka.robottiralli.lautaelementit;

import logiikka.robottiralli.lautaelementtienhallinta.Lauta;
import logiikka.robottiralli.lautaelementtienhallinta.Ruutu;
import logiikka.robottiralli.robottienhallinta.Robotti;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author KOTIPC
 */
public class KuoppaTest {
    
    Kuoppa kuoppa;
    Ruutu ruutu;
    Robotti robo;
    
    @Before
    public void setUp() {
        ruutu=new Ruutu(3,3);
        kuoppa=new Kuoppa(ruutu);
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
        kuoppa.aktivoidu(new Lauta(5,5), ruutu, 2);
        assertEquals(new Ruutu(2,2),robo.getRuutu());
        assertEquals(2,robo.getVahinko());
    }
    
    
}
