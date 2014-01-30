

package logiikka.robottiralli.pelaajienhallinta;

import java.util.HashMap;
import logiikka.robottiralli.robottienhallinta.Robotti;
import logiikka.robottiralli.korttienhallinta.Kortti;
import java.util.List;


public interface Pelaaja {
    void otaKortti(Kortti kortti);
    Robotti getRobotti();
    List<Kortti> teeOhjelma();
    HashMap<Kortti, Integer> getKasikortit();
    
}
