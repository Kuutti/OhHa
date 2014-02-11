

package logiikka.robottiralli.lautaelementtienhallinta;

import java.util.HashSet;
import java.util.Set;
import logiikka.robottiralli.lautaelementit.Kaantaja;
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
        assertEquals(new Ruutu(2,2),lauta.getAloitus());
    }
    @Test
    public void maali(){
        lauta.setMaali(2, 3);
        assertEquals(new Ruutu(2,3),lauta.getMaali());
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
    public void lisaaRobotin(){
        lauta.AddRobo(new Robotti(new Ruutu(2,2),2));
        assertEquals(1,lauta.robot.size());
    }
    @Test
    public void eiVoiTormataHolona(){
        Robotti testirobo=new Robotti(new Ruutu(2,2),2);
        lauta.AddRobo(testirobo);
        assertEquals(false,lauta.onRobotti(lauta.pelilauta[2][2]));
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
    
    @Test
    public void eiLaudallaKunXon0(){
        assertEquals(false,lauta.onLaudalla(new Ruutu(0,2)));
    }
    
    @Test
    public void eiLaudallakunYon0(){
        assertEquals(false,lauta.onLaudalla(new Ruutu(2,0)));
    }
    
    @Test
    public void onLaudallaOikeallaReunassa(){
        assertEquals(true,lauta.onLaudalla(new Ruutu(9,9)));
    }
    
    @Test
    public void onLaudallaYlareunassa(){
        assertEquals(true,lauta.onLaudalla(new Ruutu(8,10)));
    }
    
    @Test
    public void ruudussaRobo(){
       Robotti robo=new Robotti(new Ruutu(2,2),2);
       lauta.pelilauta[2][2].setRobotti(robo);
       assertEquals(robo,lauta.robottiRuudussa(new Ruutu(2,2)));
    }
    
    @Test
    public void ruudussaElementti(){
        Ruutu ruutu=new Ruutu(2,2);
        Robotti robo=new Robotti(ruutu,0);
        ruutu.setRobotti(robo);
        Kaantaja kaannin=new Kaantaja(ruutu,1);
        ruutu.lisaaElementti(kaannin);
        lauta.pelilauta[2][2]=ruutu;
        lauta.aktivoiRuudussa("kaantaja", ruutu,1);
        assertEquals(1,robo.getSuunta());
    }

    
}
