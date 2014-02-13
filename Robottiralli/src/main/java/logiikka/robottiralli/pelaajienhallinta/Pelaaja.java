

package logiikka.robottiralli.pelaajienhallinta;

import java.util.ArrayList;
import logiikka.robottiralli.robottienhallinta.Robotti;
import logiikka.robottiralli.korttienhallinta.Kortti;


public interface Pelaaja {
    /**
     * Pelaaja ottaa vastaan korttipakan jakaman kortin.
     * @param kortti Korttipakan jakama kortti.
     */
    void otaKortti(Kortti kortti);
    Robotti getRobotti();
    /**
     * Pelaaja tekee korteistansa ohjelman.
     */
    void teeOhjelma();
    ArrayList<Kortti> getOhjelma();
    void setOhjelma(ArrayList<Kortti> ohjelma);
    ArrayList<Kortti> getKasi();
}
