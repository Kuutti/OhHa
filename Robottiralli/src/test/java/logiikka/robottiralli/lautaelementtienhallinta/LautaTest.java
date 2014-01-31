

package logiikka.robottiralli.lautaelementtienhallinta;

import java.util.HashSet;
import java.util.Set;
import logiikka.robottiralli.robottienhallinta.Robotti;
import org.junit.Before;
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
    
    @Test
    public void seinanLisays(){
        lauta.addSeina(new Sijainti(1,1), new Sijainti(1,2));
        Set<Sijainti> test=new HashSet<>();
        test.add(new Sijainti(1,1));
        test.add(new Sijainti(1,2));
        assertEquals(true,lauta.getSeinat().contains(test));
    }
    @Test
    public void lisaaRobotin(){
        lauta.AddRobo(new Robotti(2,2,2));
        assertEquals(1,lauta.robotit.size());
    }
    @Test
    public void tunnistaaRobon(){
        Robotti testirobo=new Robotti(2,2,2);
        lauta.AddRobo(testirobo);
        assertEquals(true,lauta.onRobotti(new Sijainti(2,2)));
    }

    
}
