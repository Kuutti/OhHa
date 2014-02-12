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
public class CheckpointTest {
    
    Checkpoint cp;
    Ruutu ruutu;
    Robotti robo;
  
    @Before
    public void setUp() {
        ruutu=new Ruutu(2,2);
        cp=new Checkpoint(ruutu,new Ruutu(3,3));
        robo=new Robotti(ruutu,3);
        ruutu.setRobotti(robo);
        
    }
    @Test
    public void konstruktori(){
        assertEquals(new Ruutu(2,2),cp.ruutu);
        assertEquals(new Ruutu(3,3),cp.seuraava);
    }
    
    @Test
    public void tyyppiOikein(){
        assertEquals("checkpoint",cp.tyyppi());
    }
    
    @Test
    public void cpvaihtuukuntarve(){
        robo.setSeuraavacp(ruutu);
        cp.aktivoidu(new Lauta(5,5), ruutu, 0);
        assertEquals(new Ruutu(3,3),robo.getSeuraavacp());
    }
    
    @Test
    public void korjaaVuoronlopussa(){
        robo.otaVahinkoa(2);
        cp.aktivoidu(new Lauta(5,5), ruutu, 5);
        assertEquals(1,robo.getVahinko());
    }

    
}