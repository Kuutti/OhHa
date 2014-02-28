
package logiikka.robottiralli.hallinnat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import logiikka.robottiralli.lautaelementtienhallinta.Laser;
import logiikka.robottiralli.lautaelementtienhallinta.Lauta;
import logiikka.robottiralli.lautaelementtienhallinta.Ruutu;
import logiikka.robottiralli.pelaajienhallinta.Ihmispelaaja;
import logiikka.robottiralli.pelaajienhallinta.Pelaaja;
import logiikka.robottiralli.robottienhallinta.Robotti;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LaserzhallintaTest {
    
    
    Lauta lauta;
    Laserzhallinta hallinta;
    Robotti robo;
    
    @Before
    public void setUp() {
        lauta=new Lauta(10);
        hallinta=new Laserzhallinta(lauta);
        robo=new Robotti(new Ruutu(2,4),0);
        lauta.addLaser(new Laser(lauta.getPelilauta()[2][2],0));
    }

    @Test
    public void oikeaLauta(){
        assertEquals(lauta,hallinta.lauta);
    }
    
     @Test
     public void edessaEiMitaan(){
         assertEquals(0,hallinta.onkoEdessarobottia(lauta.getPelilauta()[2][2], 0).size());
     }
     
     @Test
     public void edessaSeina(){
         Set<Ruutu> seina=new HashSet<>();
         seina.add(new Ruutu(2,4));
         seina.add(new Ruutu(2,5));
         assertEquals(0,hallinta.onkoEdessarobottia(lauta.getPelilauta()[2][2], 0).size());
     }
     
     @Test
     public void edessaRobotti(){
         lauta.getPelilauta()[2][4].setRobotti(robo);
         robo.setHolo(false);
         assertEquals(1,hallinta.onkoEdessarobottia(lauta.getPelilauta()[2][2], 0).size());
     }
     
     @Test
     public void edessaHolorobotti(){
         lauta.getPelilauta()[2][4].lisaaholorobo(robo);
         assertEquals(1,hallinta.onkoEdessarobottia(lauta.getPelilauta()[2][2], 0).size());
     }
     
     @Test
     public void osuuRobottiin(){
         lauta.getPelilauta()[2][4].setRobotti(robo);
         hallinta.ampuminen(lauta.getPelilauta()[2][2], 0);
         assertEquals(1,robo.getVahinko());
     }
     @Test
     public void laserOsuuSamassaRuudussaOlevaanholoon(){
         robo.setRuutu(lauta.getPelilauta()[2][2]);
         System.out.println(lauta.getPelilauta()[2][2].getRobotti());
         hallinta.laseritAmpuu();
         assertEquals(1,robo.getVahinko());
     }
     
     @Test
     public void laserOsuuKauempaanRobottiin(){
         lauta.getPelilauta()[2][4].setRobotti(robo);
         hallinta.laseritAmpuu();
         assertEquals(1,robo.getVahinko());
     }
     
     @Test
     public void laserOsuusamassaRuudussaOlevaan(){
         robo.setHolo(false);
         lauta.getPelilauta()[2][2].setRobotti(robo);
         hallinta.laseritAmpuu();
         assertEquals(1,robo.getVahinko());
     }
     
     @Test
     public void RobottiosuuRobottiin(){
        Robotti kohde=new Robotti(lauta.getPelilauta()[2][6],2);
        kohde.setRuutu(lauta.getPelilauta()[2][6]);
        robo.setActive(Boolean.TRUE);
        robo.setHolo(false);
        ArrayList<Pelaaja> pelaajat=new ArrayList<>();
        Pelaaja pelaaja=new Ihmispelaaja(robo,1);
        pelaajat.add(pelaaja);
        hallinta.robotAmpuu(pelaajat);
        assertEquals(1,kohde.getVahinko());
     }


    
    @Test
    public void kaikkiAmpuu(){
       lauta.getPelilauta()[2][4].setRobotti(robo);
       Robotti kohde=new Robotti(lauta.getPelilauta()[2][6],2);
       kohde.setRuutu(lauta.getPelilauta()[2][6]);
       robo.setActive(Boolean.TRUE);
       robo.setHolo(false);
       ArrayList<Pelaaja> pelaajat=new ArrayList<>();
       Pelaaja pelaaja=new Ihmispelaaja(robo,1);
       pelaajat.add(pelaaja);
       hallinta.ammulaserz(pelaajat);
       assertEquals(1,robo.getVahinko());
       assertEquals(1,kohde.getVahinko());
    }
}
