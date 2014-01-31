

package logiikka.robottiralli.korttienhallinta;

import logiikka.robottiralli.pelaajienhallinta.Pelaaja;

public class Korttipakka {

    public Korttipakka() {
    }
    
    public void jaaKortitPelaajalle(Pelaaja pelaaja){
      int k=9-pelaaja.getRobotti().getVahinko();
        for (int i = 0; i < k; i++) {
            pelaaja.otaKortti(new Kortti());
       }
    }
    
    
}
