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
import logiikka.robottiralli.pelaajienhallinta.Pelaaja;

/**
 *
 * @author KOTIPC
 */
public class Tyonnin implements Ruudunvieva{

    Ruutu ruutu;
    Ruutu tyonnettavaRuutu;
    ArrayList<Integer> aktivoituu;
    
    @Override
    public String tyyppi() {
        return "tyonnin";
    }

    public Tyonnin(Ruutu ruutu, Ruutu tyonnettavaRuutu, ArrayList<Integer> aktivoituu) {
        this.ruutu = ruutu;
        this.tyonnettavaRuutu = tyonnettavaRuutu;
        this.aktivoituu = aktivoituu;
    }

    @Override
    public void aktivoidu(Lauta lauta, Ruutu ruutu, int vuoro) {
        if (aktivoituu.contains(vuoro)) {
            ruutu.getRobotti().setRuutu(tyonnettavaRuutu);
        }
    }
    
}
