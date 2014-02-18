

package logiikka.robottiralli.hallinnat;

import Laudanluonti.RumaaKoodiaEsittelyLaudanluomiseen;
import Kayttoliittyma.Lautaikkuna;
import Kayttoliittyma.Lautapiirrin;
import logiikka.robottiralli.pelaajienhallinta.Pelaaja;
import logiikka.robottiralli.lautaelementtienhallinta.Lauta;
import logiikka.robottiralli.korttienhallinta.Korttipakka;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import kayttoliittyma.Aloitusikkuna;
import logiikka.robottiralli.pelaajienhallinta.Ihmispelaaja;
import logiikka.robottiralli.robottienhallinta.Robotti;


public class Kayttoliittyma {
    /**
     * Pelissä käytettävä lauta.
     */
    Lauta lauta;
    /**
     * Peliä pelaavat pelaajat.
     */
    ArrayList<Pelaaja> pelaajat=new ArrayList<>();
    Lautapiirrin piirrin;
    Lautaikkuna lautaikkuna;
    
    /**
     * Aloittaa pelin kysyen pelaajien lukumäärää, minkä jälkeen luo pelaajat ja laudan.
     */
     public void aloitus(){
        laudanluonti();
        Aloitusikkuna ikkuna=new Aloitusikkuna();
        pelaajienLuonti(ikkuna.aloita());
        piirrin=new Lautapiirrin(lauta,pelaajat);
        lautaikkuna=new Lautaikkuna(piirrin);
        SwingUtilities.invokeLater(lautaikkuna);
        while(!lautaikkuna.isSaaJatkaa());
        pelaus();
         
     }
     /**
      * Luo pelaajat
      */

    private void pelaajienLuonti(int pelaajia) {
        for (int i = 0; i < pelaajia; i++) {
            pelaajat.add(new Ihmispelaaja(new Robotti(lauta.getAloitus(),0),i+1));
            pelaajat.get(i).getRobotti().setSeuraavacp(lauta.getAloitus());
            lauta.getAloitus().getRuudussa().aktivoidu(pelaajat.get(i).getRobotti(),0);
            lauta.getPelilauta()[lauta.getAloitus().getX()][lauta.getAloitus().getY()].lisaaholorobo(pelaajat.get(i).getRobotti());
        }
    }

    /**
     * Luo pelissä käytettävän laudan lautaelementteineen.
     */
    private void laudanluonti() {
        lauta=new Lauta(24);
        RumaaKoodiaEsittelyLaudanluomiseen luoja=new RumaaKoodiaEsittelyLaudanluomiseen();
        luoja.teeLauta(lauta);
    }
/**
 * Aloittaa pelin pelauksen.
 */
    private void pelaus() {
        Vuorontoteuttaja toteuttaja=new Vuorontoteuttaja(lauta);  
        Korttipakka pakka =new Korttipakka();
        while (true){
          for (Pelaaja pelaaja : pelaajat) {
            pelaaja.ohjelmaTyhjaksi();
            pakka.jaaKortitPelaajalle(pelaaja);
            lautaikkuna.ohjelmanTeko((Ihmispelaaja) pelaaja); 
        }
          toteuttaja.teeVuorot(pelaajat,piirrin);
          
          epilogi();
        }
        
    }
/**
 * Huolehtii vuoron lopussa, että kaikki robotit ovat aktiivisia ja eivät ole
 * hologrammeja, jos mahdollista.
 */
    private void epilogi() {
        for (Pelaaja pelaaja : pelaajat) {
            pelaaja.getRobotti().setActive(Boolean.TRUE);
            if (pelaaja.getRobotti().isHolo()&&!pelaaja.getRobotti().getRuutu().onRobotti()) {
                pelaaja.getRobotti().setHolo(false);
                pelaaja.getRobotti().getRuutu().setRobotti(pelaaja.getRobotti());
            }
        }
    }

     
    
}
