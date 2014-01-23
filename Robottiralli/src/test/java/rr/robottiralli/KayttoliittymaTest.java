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
public class KayttoliittymaTest {
    
    Kayttoliittyma kayttis;
    
    @Before
    public void setUp() {
        kayttis=new Kayttoliittyma();
        kayttis.aloitus();
    }
    
    @Test
    public void lautaOikeaaKokoa(){
        assertEquals(10,kayttis.lauta.getKorkeus());
        assertEquals(10,kayttis.lauta.leveys);
    }
    @Test
    public void aloitusOikeassaPaikassa(){
        assertEquals(new Sijainti(1,1),kayttis.lauta.getAloitus());
    }
    @Test
    public void maaliOikeassaPaikassa(){
        assertEquals(new Sijainti(10,10),kayttis.lauta.getMaali());
    }
    
   
}
