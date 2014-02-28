package logiikka.robottiralli.korttienhallinta;

import logiikka.robottiralli.lautaelementtienhallinta.Ruutu;
import logiikka.robottiralli.pelaajienhallinta.Ihmispelaaja;
import logiikka.robottiralli.robottienhallinta.Robotti;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KorttipakkaTest {
    
     Korttipakka pakka;
     Robotti robo;
     Ihmispelaaja peluri;
    
    
    
    
    
    @Before
    public void setUp() {
        pakka=new Korttipakka();
        robo=new Robotti(new Ruutu(2,2),2);
        peluri=new Ihmispelaaja(robo,1);
        robo.otaVahinkoa(1);
    }
    
    @Test
    public void jakaaOikeanMaaran(){
        pakka.jaaKortitPelaajalle(peluri);
        int kortteja=0;
        for (Kortti kortti : peluri.getKasi().keySet()) {
            kortteja+=peluri.getKasi().get(kortti);
        }
        assertEquals(8,kortteja);
    }
    
   
   
}
