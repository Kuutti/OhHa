

package logiikka.robottiralli;

import Laudanluonti.RumaaKoodiaEsittelyLaudanluomiseen;
import Kayttoliittyma.Lautaikkuna;
import logiikka.robottiralli.pelaajienhallinta.Pelaaja;
import logiikka.robottiralli.lautaelementtienhallinta.Lauta;
import logiikka.robottiralli.korttienhallinta.Korttipakka;
import java.util.ArrayList;
import javax.swing.SwingUtilities;


public class Kayttoliittyma {
    /**
     * Pelissä käytettävä lauta.
     */
    Lauta lauta;
    /**
     * Peliä pelaavat pelaajat.
     */
    ArrayList<Pelaaja> pelaajat=new ArrayList<>();
    /**
     * Pelaavien pelaajien lukumäärä
     */
    int pelaajia;
    /**
     * Pelissä käytettävä korttipakka korttien generoimiseen.
     */
    Korttipakka pakka;
    
    /**
     * Aloittaa pelin kysyen pelaajien lukumäärää, minkä jälkeen luo pelaajat ja laudan.
     */
     public void aloitus(){
        
       // Aloitusikkuna ikkuna=new Aloitusikkuna();
       //pelaajienLuonti();
       
         laudanluonti();
        Lautaikkuna lautaikkuna=new Lautaikkuna(lauta);
        SwingUtilities.invokeLater(lautaikkuna);
        
         
     }
     /**
      * Luo pelaajat
      */

    private void pelaajienLuonti() {
        
        
    }

    /**
     * Luo pelissä käytettävän laudan lautaelementteineen.
     */
    private void laudanluonti() {
        lauta=new Lauta(24,24);
        RumaaKoodiaEsittelyLaudanluomiseen luoja=new RumaaKoodiaEsittelyLaudanluomiseen();
        luoja.teeLauta(lauta);
    }

//    private void pelaus() {
//        RobojenLiikuttaja liikuttaja=new RobojenLiikuttaja(lauta);
//        
//        liikuttaja.liikuta(pelaajat);
//    }

     
    
}
