

package logiikka.robottiralli.lautaelementit;

import logiikka.robottiralli.lautaelementtienhallinta.Lauta;
import logiikka.robottiralli.lautaelementtienhallinta.Elementti;
import logiikka.robottiralli.lautaelementtienhallinta.Ruutu;
import logiikka.robottiralli.robottienhallinta.Robotti;


public class Liukuhihna implements Elementti{
    /**
     * Ruutu johon liukuhihna vie
     */
    Ruutu seuraava;
    /**
     * Ilmoittaa kuinka paljon robottia käännetään
     */
    int kaantaminen;
    /**
     * Ilmoittaa suunnan, johon liukuhihna vie. Tarvitaan
     * grafiikassa.
     */
    int suunta;

    public Liukuhihna(Ruutu seuraava, int kaantaminen, int suunta) {
        this.seuraava = seuraava;
        this.kaantaminen=kaantaminen;
        this.suunta=suunta;
    }

    @Override
    public String tyyppi() {
        return "liukuhihna";
    }

    /**
     * Liikuttaa robotin seuraavaan ruutun ja kääntää tarvittaessa.
     * @param robo Liikutettava robotti.
     * @param vuoro Ei tarvita.
     */
    @Override
    public void aktivoidu(Robotti robo, int vuoro) {
        robo.setSuunta(robo.getSuunta()+kaantaminen);
        robo.setRuutu(seuraava);
    }
/**
 * @return Palauttaa suunnan, johon liukuhihna vie.
 */
    @Override
    public int getGrafiikkaluku() {
        return suunta;
    }

    
    
}
