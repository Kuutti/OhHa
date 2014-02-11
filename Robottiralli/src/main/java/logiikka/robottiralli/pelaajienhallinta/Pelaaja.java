

package logiikka.robottiralli.pelaajienhallinta;

import java.util.ArrayList;
import java.util.HashMap;
import logiikka.robottiralli.robottienhallinta.Robotti;
import logiikka.robottiralli.korttienhallinta.Kortti;
import java.util.List;


public interface Pelaaja {
    void otaKortti(Kortti kortti);
    Robotti getRobotti();
    void teeOhjelma();
    ArrayList<Kortti> getOhjelma();
    void setOhjelma(ArrayList<Kortti> ohjelma);
    ArrayList<Kortti> getKasi();
}
