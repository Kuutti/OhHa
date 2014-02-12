package logiikka.robottiralli.robottienhallinta;





import logiikka.robottiralli.lautaelementtienhallinta.Lauta;
import logiikka.robottiralli.lautaelementtienhallinta.Ruutu;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author KOTIPC
 */
public class RobottiTest {
    
    public RobottiTest() {
    }
    
    Robotti robo;
    Lauta lauta;
    
    @Before
    public void setUp() {
        robo=new Robotti(new Ruutu(3,3),0);
        lauta=new Lauta(10,10);
    }
    
    @Test
    public void getteritJaKonstruktori(){
        assertEquals(new Ruutu(3,3), robo.getRuutu());
        assertEquals(0, robo.getSuunta());
    }
    
    @Test
    public void Setterit(){
        robo.setRuutu(new Ruutu(2,2));
        robo.setSuunta(1);
        assertEquals(1,robo.getSuunta());
        assertEquals(new Ruutu(2,2), robo.getRuutu());
    }
    
    @Test
    public void ToinenKonstruktori(){
       Robotti r=new Robotti(new Ruutu(2,2),1);
       assertEquals(new Ruutu(2,2),r.getRuutu());
       assertEquals(1,r.getSuunta());
   }
     
    @Test
    public void vahinko(){
        robo.otaVahinkoa(3);
        assertEquals(3,robo.getVahinko());
    }
    

   




}
