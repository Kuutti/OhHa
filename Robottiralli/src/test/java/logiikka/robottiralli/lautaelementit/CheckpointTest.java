
package logiikka.robottiralli.lautaelementit;

import logiikka.robottiralli.lautaelementtienhallinta.Ruutu;
import logiikka.robottiralli.robottienhallinta.Robotti;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CheckpointTest {
    
    Checkpoint cp;
    Ruutu ruutu;
    Robotti robo;
  
    @Before
    public void setUp() {
        ruutu=new Ruutu(2,2);
        cp=new Checkpoint(2,new Ruutu(3,3));
        robo=new Robotti(ruutu,3);
        ruutu.setRobotti(robo);
        
    }
    @Test
    public void konstruktori(){
        assertEquals(new Ruutu(3,3),cp.seuraava);
    }
    
    @Test
    public void tyyppiOikein(){
        assertEquals("checkpoint",cp.tyyppi());
    }
    
    @Test
    public void cpvaihtuukuntarve(){
        robo.setSeuraavacp(ruutu);
        cp.aktivoidu(robo, 0);
        assertEquals(new Ruutu(3,3),robo.getSeuraavacp());
    }
    
    @Test
    public void korjaaVuoronlopussa(){
        robo.otaVahinkoa(2);
        cp.aktivoidu(robo, 5);
        assertEquals(1,robo.getVahinko());
    }
    
    @Test
    public void tarkistaMones(){
        assertEquals(2,cp.getGrafiikkaluku());
    }
    
    @Test
    public void vaihtaaRespawn(){
       cp.aktivoidu(robo, 1);
       assertEquals(ruutu,robo.getRespawn());
    }
    

    
    
}
