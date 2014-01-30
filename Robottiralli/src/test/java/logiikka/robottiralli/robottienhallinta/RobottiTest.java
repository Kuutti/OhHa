package logiikka.robottiralli.robottienhallinta;





import logiikka.robottiralli.lautaelementtienhallinta.Sijainti;
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
    
    @Before
    public void setUp() {
        robo=new Robotti(3,3,0);
    }
    
    @Test
    public void getteritJaKonstruktori(){
        assertEquals(new Sijainti(3,3), robo.getSijainti());
        assertEquals(new Suunta(0), robo.getSuunta());
    }
    
    @Test
    public void Setterit(){
        robo.setSijainti(new Sijainti(2,2));
        robo.setSuunta(1);
        assertEquals(new Suunta(1),robo.getSuunta());
        assertEquals(new Sijainti(2,2), robo.getSijainti());
    }
    
    @Test
    public void LiikuOikealle(){
        robo.setSuunta(1);
        robo.liiku(0);
        assertEquals(new Sijainti(4,3),robo.getSijainti());
    }
    @Test
    
    public void LiikuAlas(){
        robo.setSuunta(2);
        robo.liiku(0);
        assertEquals(new Sijainti(3,2),robo.getSijainti());
    }
    
    @Test
    public void LiikuVasemmalle(){
        robo.setSuunta(3);
        robo.liiku(0);
        assertEquals(new Sijainti(2,3), robo.getSijainti());
    }
    
    @Test 
    public void LiikuYlos(){
        robo.liiku(0);
        assertEquals(new Sijainti (3,4),robo.getSijainti());
    }
    
    @Test
    public void ToinenKonstruktori(){
       Robotti r=new Robotti(new Sijainti(2,2),1);
       assertEquals(new Sijainti(2,2),r.getSijainti());
       assertEquals(new Suunta(1),r.getSuunta());
   }
    
    @Test
    public void OnLaudalla(){
        assertEquals(true,robo.onkoLaudalla(4, 4));
    }
    
    @Test
    public void Ylareunalla(){
        assertEquals(true,robo.onkoLaudalla(4, 3));
    }
    
    @Test
    public void Alareunalla(){
        robo.setSijainti(3,1);
        assertEquals(true,robo.onkoLaudalla(4, 4));
    }
    
    @Test
    public void OikeallaReunalla(){
        assertEquals(true, robo.onkoLaudalla(3, 4));
    }
    
    @Test
    public void VasemmallaReunalla(){
        robo.setSijainti(1, 3);
        assertEquals(true,robo.onkoLaudalla(4, 4));
    }
    
    @Test
    public void vahinko(){
        robo.setVahinko(3);
        assertEquals(3,robo.getVahinko());
    }
    
    @Test
    public void edessaOlevaRuutu(){
        assertEquals(new Sijainti(3,4),robo.edessaOleva());
    }
    
    @Test
    public void TakanaOlevaRuutu(){
        assertEquals(new Sijainti(3,2),robo.takanaOleva());
    }
    
    @Test
    public void OikeallaOlevaRuutu(){
        assertEquals(new Sijainti(4,3), robo.SuunnassaOleva(1));
    }
    
    @Test
    public void VasemmallaOlevaRuutu(){
        assertEquals(new Sijainti(2,3),robo.SuunnassaOleva(3));
    }




}
