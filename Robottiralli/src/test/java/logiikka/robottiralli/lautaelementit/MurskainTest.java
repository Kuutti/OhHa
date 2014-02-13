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
public class MurskainTest {
    
    Murskain murskain;
    Ruutu ruutu;
    Robotti robo;
    
    @Before
    public void setUp() {
        ruutu=new Ruutu(3,3);
        murskain=new Murskain(2);
        robo=new Robotti(ruutu,1);
        ruutu.setRobotti(robo);
    }
    
    @Test
    public void tyyppiOikein(){
        assertEquals("murskain",murskain.tyyppi());
    }
    
    @Test
    public void murskaa(){
        robo.setRespawn(new Ruutu(2,3));
        murskain.aktivoidu(robo, 2);
        assertEquals(robo.getRuutu(),new Ruutu(2,3));
        assertEquals(robo.getVahinko(),2);
        assertEquals(null,ruutu.getRobotti());
    }
    
    
    }
    
    
