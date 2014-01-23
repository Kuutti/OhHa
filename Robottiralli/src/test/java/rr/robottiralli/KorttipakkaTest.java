package rr.robottiralli;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class KorttipakkaTest {
    
     Korttipakka pakka;
     Robotti robo;
     Ihmispelaaja peluri;
    
    
    
    
    
    @Before
    public void setUp() {
        pakka=new Korttipakka();
        robo=new Robotti(2,2,2);
        peluri=new Ihmispelaaja(robo);
    }
    
    @Test
    public void pelaajalleOikeaMaaraKortteja9(){
        pakka.jaaKortitPelaajalle(peluri);
        assertEquals(9,peluri.kortit.size());
    }
    @Test public void pelaajalleOikeaMaaraKortteja7(){
        robo.setVahinko(2);
        pakka.jaaKortitPelaajalle(peluri);
        assertEquals(7,peluri.kortit.size());
    }
   
}
