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
public class KaantajaTest {
    
    Kaantaja kaannin;
    Robotti robo;
    Ruutu ruutu;
    
    @Before
    public void setUp() {
        ruutu=new Ruutu(3,3);
        kaannin=new Kaantaja(1);
        robo=new Robotti(ruutu,2);
        ruutu.setRobotti(robo);
    }
    
    @Test
    public void tyyppiOikein(){
        assertEquals("kaantaja",kaannin.tyyppi());
    }
    
    @Test
    public void kaantaa(){
        kaannin.aktivoidu(robo, 0);
        assertEquals(robo.getSuunta(),3);
    }
    
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
