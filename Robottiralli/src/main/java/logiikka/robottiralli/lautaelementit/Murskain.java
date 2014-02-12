/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logiikka.robottiralli.lautaelementit;

import java.util.ArrayList;
import logiikka.robottiralli.lautaelementtienhallinta.Lauta;
import logiikka.robottiralli.lautaelementtienhallinta.Ruudunvieva;
import logiikka.robottiralli.lautaelementtienhallinta.Ruutu;


public class Murskain implements Ruudunvieva{
    
    Ruutu sijainti;
    ArrayList<Integer> aktivoituu;

    public Murskain(Ruutu sijainti, ArrayList<Integer> aktivoituu) {
        this.sijainti = sijainti;
        this.aktivoituu = aktivoituu;
    }

    @Override
    public String tyyppi() {
        return "murskain";
    }

    @Override
    public void aktivoidu(Lauta lauta, Ruutu ruutu, int vuoro) {
        if (aktivoituu.contains(vuoro)) {
        ruutu.getRobotti().tuhoudu();  
        ruutu.getRobotti().setRuutu(ruutu.getRobotti().getRespawn()); 
        }
    }
    
}
