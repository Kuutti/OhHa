

package logiikka.robottiralli;

import logiikka.robottiralli.pelaajienhallinta.Pelaaja;
import logiikka.robottiralli.pelaajienhallinta.Ihmispelaaja;
import logiikka.robottiralli.lautaelementtienhallinta.Lauta;
import logiikka.robottiralli.robottienhallinta.Robotti;
import logiikka.robottiralli.korttienhallinta.Korttipakka;
import java.util.ArrayList;
import kayttoliittyma.Aloitusikkuna;
import kayttoliittyma.Lautaikkuna;

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
        Lautaikkuna lautaikkuna=new Lautaikkuna();
        lautaikkuna.setVisible(true);
        lautaikkuna.luoLauta(lauta, pelaajia);
         System.out.println("s");
         
     }

    private void pelaajienLuonti() {
        for (int i = 0; i < pelaajia; i++) {
          Ihmispelaaja peluri=new Ihmispelaaja(new Robotti(lauta.getAloitus(),0));
          pelaajat.add(peluri);  
        }
        
    }

    private void laudanluonti() {
        lauta=new Lauta(24,24);
        lauta.setAloitus(1, 1);
        lauta.setMaali(24, 24);
    }

//    private void pelaus() {
//        RobojenLiikuttaja liikuttaja=new RobojenLiikuttaja(lauta);
//        HashMap<Pelaaja,List<Kortti>> ohjelmat=new HashMap();
//        for (Pelaaja pelaaja : pelaajat) {
//            ohjelmat.put(pelaaja, pelaaja.teeOhjelma());
//        }
//        liikuttaja.liikuta(ohjelmat);
//    }

     
    
}
