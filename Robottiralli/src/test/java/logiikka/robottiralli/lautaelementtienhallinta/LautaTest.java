

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
        lauta=new Lauta(10);
    }
    
    @Test
    public void konstruktoriJaGetterit(){
        assertEquals(10,lauta.getKoko());
    }
    @Test
    public void Aloitusruutu(){
        lauta.setAloitus(new Ruutu(2,2));
        assertEquals(new Ruutu(2,2),lauta.getAloitus());
    }
    
    @Test
    public void seinanLisays(){
        lauta.addSeina(new Ruutu(1,1), new Ruutu(1,2));
        Set<Ruutu> test=new HashSet<>();
        test.add(new Ruutu(1,1));
        test.add(new Ruutu(1,2));
        assertEquals(true,lauta.getSeinat().contains(test));
    }
    
     @Test
    public void OikeallaOlevaRuutu(){
        assertEquals(new Ruutu(4,3), lauta.seuraavaRuutu(new Ruutu(3,3),1));
    }
    
    @Test
    public void VasemmallaOlevaRuutu(){
        assertEquals(new Ruutu(2,3),lauta.seuraavaRuutu(new Ruutu(3,3) ,3));
    }
    
    @Test
    public void EdessaOlevaRuutu(){
        assertEquals(new Ruutu(3,4),lauta.seuraavaRuutu(new Ruutu(3,3) ,0));
    }
    
    @Test
    public void TakanaOlevaRuutu(){
        assertEquals(new Ruutu(3,2),lauta.seuraavaRuutu(new Ruutu(3,3),2));
    }
    
//    @Test
//    public void eiLaudallaKunXon0(){
//        assertEquals(false,lauta.onLaudalla(new Ruutu(0,2)));
//    }
//    
//    @Test
//    public void eiLaudallakunYon0(){
//        assertEquals(false,lauta.onLaudalla(new Ruutu(2,0)));
//    }
//    
//    @Test
//    public void onLaudallaOikeallaReunassa(){
//        assertEquals(true,lauta.onLaudalla(new Ruutu(9,9)));
//    }
//    
//    @Test
//    public void onLaudallaYlareunassa(){
//        assertEquals(true,lauta.onLaudalla(new Ruutu(8,10)));
//    }   
    
    @Test
    public void luoOikein(){
        assertEquals(new Ruutu(11,11),lauta.pelilauta[11][11]);
    }
}
