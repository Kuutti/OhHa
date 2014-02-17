

package logiikka.robottiralli.pelaajienhallinta;

import java.util.ArrayList;
import java.util.HashMap;
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
    LinkedList<Kortti> getOhjelma();
    HashMap<Kortti,Integer> getKasi();
    void setOhjelma(LinkedList<Kortti> ohjelma);
    public void kasiTyhjaksi();
    public int getMones();
    public void ohjelmaTyhjaksi();

    public void setShutdown();

    public boolean poistaKortti();

}
