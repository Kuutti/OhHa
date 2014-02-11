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
public class Korjaaja implements Ruudunvieva{
    
    Ruutu ruutu;
    int teho;

    Korjaaja(Ruutu ruutu, int i) {
        this.ruutu=ruutu;
        teho=i;
    }
    

    @Override
    public String tyyppi() {
        return "korjaaja";
    }

    @Override
    public void aktivoidu(Lauta lauta, Ruutu ruutu, int vuoro) {
        if (vuoro==5) {
            ruutu.getRobotti().korjaa(teho);
        }
    }
    
}
