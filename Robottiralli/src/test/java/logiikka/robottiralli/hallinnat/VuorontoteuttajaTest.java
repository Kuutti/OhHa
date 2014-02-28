
package logiikka.robottiralli.hallinnat;

import java.util.ArrayList;
import logiikka.robottiralli.lautaelementtienhallinta.Lauta;
import logiikka.robottiralli.lautaelementtienhallinta.Ruutu;
import logiikka.robottiralli.pelaajienhallinta.Ihmispelaaja;
import logiikka.robottiralli.pelaajienhallinta.Pelaaja;
import logiikka.robottiralli.robottienhallinta.Robotti;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VuorontoteuttajaTest {
    Vuorontoteuttaja toteuttaja;
    ArrayList<Pelaaja> pelaajat;
    
    @Before
    public void setUp() {
        Lauta lauta=new Lauta(10);
        toteuttaja=new Vuorontoteuttaja(lauta);
        pelaajat=new ArrayList<>();
    }

     @Test
     public void shutdowntarkistus() {
     Pelaaja pelaaja=teePelaaja();
     pelaaja.setShutdown();
     
     pelaajat.add(pelaaja);
     toteuttaja.tarkistaShutdown(pelaajat);
     assertEquals(0,pelaaja.getRobotti().getVahinko());
     }
     
     
    public Pelaaja teePelaaja() {
        Robotti robo=new Robotti(new Ruutu(2,2),1);
        robo.otaVahinkoa(3);
        Pelaaja pelaaja=new Ihmispelaaja(robo,1);
        return pelaaja;
    }
}
