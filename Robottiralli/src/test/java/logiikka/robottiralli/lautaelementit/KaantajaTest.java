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
public class KaantajaTest {
    
    Kaantaja kaannin;
    Robotti robo;
    Ruutu ruutu;
    
    @Before
    public void setUp() {
        ruutu=new Ruutu(3,3);
        kaannin=new Kaantaja(ruutu,1);
        robo=new Robotti(ruutu,2);
        ruutu.setRobotti(robo);
    }
    
    @Test
    public void tyyppiOikein(){
        assertEquals("kaantaja",kaannin.tyyppi());
    }
    
    @Test
    public void kaantaa(){
        kaannin.aktivoidu(new Lauta(3,3), ruutu, 0);
        assertEquals(robo.getSuunta(),3);
    }
    
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
