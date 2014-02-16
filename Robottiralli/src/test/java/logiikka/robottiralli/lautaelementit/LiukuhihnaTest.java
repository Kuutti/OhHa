/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logiikka.robottiralli.lautaelementit;

import logiikka.robottiralli.lautaelementtienhallinta.Lauta;
import logiikka.robottiralli.lautaelementtienhallinta.Ruutu;
import logiikka.robottiralli.robottienhallinta.Robotti;
import org.junit.Before;
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
    Lauta lauta;
    
    @Before
    public void setUp() {
        ruutu=new Ruutu(3,3);
        hihna=new Liukuhihna(new Ruutu(3,2),1,2);
        robo=new Robotti(ruutu,2);
        ruutu.setRobotti(robo);
        lauta=new Lauta(20);
        lauta.getPelilauta()[3][3].lisaaElementti(hihna);
    }
    
    @Test
    public void tyyppiOikein(){
        assertEquals("liukuhihna",hihna.tyyppi());
    }
    
    @Test
    public void liikuttaaOikein(){
        hihna.aktivoidu(robo, 2);
        assertEquals(new Ruutu(3,2),robo.getRuutu());
        assertEquals(3,robo.getSuunta());
    }
    @Test
    public void Erikoisint(){
        assertEquals(2,hihna.getErikoisint());
    }
    
    
    
}
