

package rr.robottiralli;

import java.util.ArrayList;

public class Kayttoliittyma {
    Lauta lauta;
    ArrayList<Pelaaja> pelaajat=new ArrayList<>();
    Korttipakka pakka;
    
     public void aloitus(){
         laudanluonti();
         pelaajienLuonti();
         
     }

    private void pelaajienLuonti() {
        int ihmispelaajia=1;
        for (int i = 0; i < ihmispelaajia; i++) {
          Ihmispelaaja peluri=new Ihmispelaaja(new Robotti(lauta.getAloitus(),0));
          pelaajat.add(peluri);  
        }
        
    }

    private void laudanluonti() {
        lauta=new Lauta(10,10);
        lauta.setAloitus(1, 1);
        lauta.setMaali(10, 10);
    }
}
