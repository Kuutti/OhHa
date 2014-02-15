

package logiikka.robottiralli.pelaajienhallinta;

import java.util.ArrayList;
import java.util.LinkedList;
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
    LinkedList<Kortti> getOhjelma();
    ArrayList<Kortti> getKasi();
    void setOhjelma(LinkedList<Kortti> ohjelma);
}
