

package logiikka.robottiralli.pelaajienhallinta;

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
    /**
     * Tyhjentää pelajaan käden korteista.
     */
    public void kasiTyhjaksi();
    public int getMones();
    /**
     * Tyhjentää pelaajan ohjelman, mutta jättää lukittuneet kortit paikoilleen.
     */
    public void ohjelmaTyhjaksi();
    /**
     * Asettaa pelaajan Robotin shutdown-tilaan.
     */
    public void setShutdown();
    /**
     * Poistaa ohjelmasta viimeisimmän kortin. Palauttaa True, kortti ei ole lukittunut.
     * @return onnistuiko kortin poisto.
     */
    public boolean poistaKortti();

}
