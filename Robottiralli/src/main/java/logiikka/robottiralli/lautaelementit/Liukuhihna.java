

package logiikka.robottiralli.lautaelementit;

import logiikka.robottiralli.lautaelementtienhallinta.Lauta;
import logiikka.robottiralli.lautaelementtienhallinta.Ruudunvieva;
import logiikka.robottiralli.lautaelementtienhallinta.Ruutu;
import logiikka.robottiralli.robottienhallinta.Robotti;


public class Liukuhihna implements Ruudunvieva{
    Ruutu seuraava;
    Ruutu sijainti;
    int kaantaminen;

    public Liukuhihna(Ruutu sijainti, Ruutu seuraava, int kaantaminen) {
        this.seuraava = seuraava;
        this.sijainti = sijainti;
        this.kaantaminen=kaantaminen;
    }

    @Override
    public String tyyppi() {
        return "liukuhihna";
    }

    @Override
    public void aktivoidu(Lauta lauta, Ruutu ruutu, int vuoro) {
        Robotti robo=ruutu.getRobotti();
        robo.setSuunta(robo.getSuunta()+kaantaminen);
        ruutu.getRobotti().setRuutu(seuraava);
    }

    
    
}
