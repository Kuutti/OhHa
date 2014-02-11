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
public class LiukuhihnaTest {
    
    Liukuhihna hihna;
    Ruutu ruutu;
    Robotti robo;
    
    @Before
    public void setUp() {
        ruutu=new Ruutu(3,3);
        hihna=new Liukuhihna(ruutu,new Ruutu(3,2),1);
        robo=new Robotti(ruutu,2);
        ruutu.setRobotti(robo);
    }
    
    @Test
    public void tyyppiOikein(){
        assertEquals("liukuhihna",hihna.tyyppi());
    }
    
    @Test
    public void liikuttaaOikein(){
        hihna.aktivoidu(new Lauta(4,4), ruutu, 2);
        assertEquals(new Ruutu(3,2),robo.getRuutu());
        assertEquals(3,robo.getSuunta());
        assertEquals(robo, hihna.seuraava.getRobotti());
        
    }
    
    
}
