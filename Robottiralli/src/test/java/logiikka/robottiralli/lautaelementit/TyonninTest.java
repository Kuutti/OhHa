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
public class TyonninTest {
    
    Tyonnin tyonnin;
    Ruutu ruutu;
    Robotti robo;
    
    @Before
    public void setUp() {
        ruutu=new Ruutu(2,2);
        ArrayList<Integer> lista=new ArrayList<>();
        lista.add(2);
        tyonnin=new Tyonnin(ruutu,new Ruutu(2,1),lista);
        robo=new Robotti(ruutu,0);
        ruutu.setRobotti(robo);
    }
    
    @Test
    public void tyyppiOikea(){
        assertEquals("tyonnin",tyonnin.tyyppi());
    }
    
    @Test
    public void tyontaa(){
        tyonnin.aktivoidu(new Lauta(5,5), ruutu, 2);
        assertEquals(robo.getRuutu(),new Ruutu(2,1));
    }
    
    
}
