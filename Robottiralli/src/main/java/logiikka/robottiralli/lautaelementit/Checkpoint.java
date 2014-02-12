/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logiikka.robottiralli.lautaelementit;

import logiikka.robottiralli.lautaelementtienhallinta.Lauta;
import logiikka.robottiralli.lautaelementtienhallinta.Ruudunvieva;
import logiikka.robottiralli.lautaelementtienhallinta.Ruutu;

/**
 *
 * @author KOTIPC
 */
public class Checkpoint implements Ruudunvieva{

    Ruutu ruutu;
    Ruutu seuraava;

    public Checkpoint(Ruutu ruutu, Ruutu seuraava) {
        this.ruutu = ruutu;
        this.seuraava = seuraava;
    }
    
    @Override
    public String tyyppi() {
        return "checkpoint";
    }

    @Override
    public void aktivoidu(Lauta lauta, Ruutu ruutu, int vuoro) {
        if (ruutu.getRobotti().getSeuraavacp()==this.ruutu) {
            ruutu.getRobotti().setSeuraavacp(seuraava);
        }
        if (vuoro==5) {
            ruutu.getRobotti().otaVahinkoa(ruutu.getRobotti().getVahinko()-1);
        }
    }
    
}
