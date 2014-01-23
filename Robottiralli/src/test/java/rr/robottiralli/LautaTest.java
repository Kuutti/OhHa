

package rr.robottiralli;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class LautaTest {
    
    Lauta lauta;
    
    @Before
    public void setUp() {
        lauta=new Lauta(9,10);
    }
    
    @Test
    public void konstruktoriJaGetterit(){
        assertEquals(9,lauta.getLeveys());
        assertEquals(10,lauta.getKorkeus());
    }
    @Test
    public void Aloitusruutu(){
        lauta.setAloitus(2,2);
        assertEquals(new Sijainti(2,2),lauta.getAloitus());
    }
    @Test
    public void maali(){
        lauta.setMaali(2, 3);
        assertEquals(new Sijainti(2,3),lauta.getMaali());
    }

    
}
