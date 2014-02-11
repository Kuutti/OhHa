/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logiikka.robottiralli.lautaelementit;

import logiikka.robottiralli.lautaelementtienhallinta.Lauta;
import logiikka.robottiralli.lautaelementtienhallinta.Ruudunvieva;
import logiikka.robottiralli.lautaelementtienhallinta.Ruutu;
import logiikka.robottiralli.pelaajienhallinta.Pelaaja;
import logiikka.robottiralli.robottienhallinta.Robotti;

/**
 *
 * @author KOTIPC
 */
public class Kuoppa implements Ruudunvieva{
    
    Ruutu ruutu;

    public Kuoppa(Ruutu ruutu) {
        this.ruutu = ruutu;
    }

    @Override
    public String tyyppi() {
        return "kuoppa";
    }

    @Override
    public void aktivoidu(Lauta lauta, Ruutu ruutu, int vuoro) {
        ruutu.getRobotti().tuhoudu();
        ruutu.getRobotti().setRuutu(ruutu.getRobotti().getRespawn()); 
    }
    
}
