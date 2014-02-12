package logiikka.robottiralli.korttienhallinta;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import logiikka.robottiralli.lautaelementtienhallinta.Ruutu;
import logiikka.robottiralli.pelaajienhallinta.Ihmispelaaja;
import logiikka.robottiralli.robottienhallinta.Robotti;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author KOTIPC
 */
public class KorttipakkaTest {
    
     Korttipakka pakka;
     Robotti robo;
     Ihmispelaaja peluri;
    
    
    
    
    
    @Before
    public void setUp() {
        pakka=new Korttipakka();
        robo=new Robotti(new Ruutu(2,2),2);
        peluri=new Ihmispelaaja(robo);
    }
    
    @Test
    public void oikeaMaaraKorttejaEiVahinkoa(){
        pakka.jaaKortitPelaajalle(peluri);
        assertEquals(9,peluri.getKasi().size());
    }
    
    @Test
    public void oikeaMaaraKorttejaKaksiVahinkoa(){
        robo.otaVahinkoa(2);
        pakka.jaaKortitPelaajalle(peluri);
        assertEquals(7,peluri.getKasi().size());
    }
    
   
   
}
