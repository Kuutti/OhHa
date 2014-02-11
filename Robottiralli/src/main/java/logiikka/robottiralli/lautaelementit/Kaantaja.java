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




public class Kaantaja implements Ruudunvieva{
    Ruutu sijainti;
    int Kaannossuunta;
    
    public Kaantaja(Ruutu sijainti, int Kaannossuunta) {
        this.sijainti = sijainti;
        this.Kaannossuunta = Kaannossuunta;
    }

    @Override
    public String tyyppi() {
        return "kaantaja";
    }

    @Override
    public void aktivoidu(Lauta lauta, Ruutu ruutu, int vuoro) {
        ruutu.getRobotti().setSuunta(ruutu.getRobotti().getSuunta()+Kaannossuunta);
    }
   
    
}
