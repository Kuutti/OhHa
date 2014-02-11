package logiikka.robottiralli.lautaelementtienhallinta;

import logiikka.robottiralli.pelaajienhallinta.Pelaaja;

public interface Ruudunvieva {
    String tyyppi();
    void aktivoidu(Lauta lauta, Ruutu ruutu, int vuoro);
}
