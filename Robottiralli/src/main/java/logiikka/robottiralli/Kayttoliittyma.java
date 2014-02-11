

package logiikka.robottiralli;

import Kayttoliittyma.Lautaikkuna;
import logiikka.robottiralli.pelaajienhallinta.Pelaaja;
import logiikka.robottiralli.pelaajienhallinta.Ihmispelaaja;
import logiikka.robottiralli.lautaelementtienhallinta.Lauta;
import logiikka.robottiralli.robottienhallinta.Robotti;
import logiikka.robottiralli.korttienhallinta.Korttipakka;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import kayttoliittyma.Aloitusikkuna;


public class Kayttoliittyma {
    Lauta lauta;
    ArrayList<Pelaaja> pelaajat=new ArrayList<>();
    int pelaajia;
    Korttipakka pakka;
    
     public void aloitus(){
        
        Aloitusikkuna ikkuna=new Aloitusikkuna();
        pelaajia=ikkuna.aloita();
        laudanluonti();
        pelaajienLuonti();
        Lautaikkuna lautaikkuna=new Lautaikkuna(lauta);
        SwingUtilities.invokeLater(lautaikkuna);
        
         
     }

    private void pelaajienLuonti() {
        
        
    }

    private void laudanluonti() {
        lauta=new Lauta(24,24);
        lauta.setAloitus(1, 1);
        lauta.setMaali(24, 24);
    }

//    private void pelaus() {
//        RobojenLiikuttaja liikuttaja=new RobojenLiikuttaja(lauta);
//        
//        liikuttaja.liikuta(pelaajat);
//    }

     
    
}
