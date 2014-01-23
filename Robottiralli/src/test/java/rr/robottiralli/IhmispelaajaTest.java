/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rr.robottiralli;

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
public class IhmispelaajaTest {
    
    Ihmispelaaja peluri;
    Robotti robo;
    
    @Before
    public void setUp() {
        robo=new Robotti(2,2,2);
        peluri=new Ihmispelaaja(robo);
    }
    
    @Test
    public void KorttejaYksi(){
        peluri.otaKortti(new Kortti());
        assertEquals(1,peluri.kortit.size());
    }
    @Test
    public void OikeaRobotti(){
        assertEquals(robo,peluri.getRobotti());
    }
}
