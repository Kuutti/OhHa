/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logiikka.robottiralli.lautaelementit;

import java.util.ArrayList;
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
public class MurskainTest {
    
    Murskain murskain;
    Ruutu ruutu;
    Robotti robo;
    
    @Before
    public void setUp() {
        ruutu=new Ruutu(3,3);
        ArrayList<Integer> lista=new ArrayList<>();
        lista.add(2);
        murskain=new Murskain(ruutu,lista);
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
        murskain.aktivoidu(new Lauta(5,5), ruutu, 2);
        assertEquals(robo.getRuutu(),new Ruutu(2,3));
        assertEquals(robo.getVahinko(),2);
        assertEquals(null,ruutu.getRobotti());
    }
    
    
    }
    
    
