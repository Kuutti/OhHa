/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logiikka.robottiralli.lautaelementit;

import java.util.ArrayList;
import logiikka.robottiralli.lautaelementtienhallinta.Lauta;
import logiikka.robottiralli.lautaelementtienhallinta.Elementti;
import logiikka.robottiralli.lautaelementtienhallinta.Ruutu;
import logiikka.robottiralli.robottienhallinta.Robotti;


public class Murskain implements Elementti{
    
    /**
     * Luku, joka kertoo aktivoituuko parittomilla tai parillisilla vuoroilla.
     */
    Integer aktivoituu;

    public Murskain( Integer aktivoituu) {
        this.aktivoituu = aktivoituu;
    }

    @Override
    public String tyyppi() {
        return "murskain";
    }
/**
 * Jos vuoron modulo 2 on sama kuin aktivoitumisen robotti tuhotaan.
 * @param robo Robotti, joka tuhotaan, jos vuoro on oikea.
 * @param vuoro monta ohjelman käskyä on toteutettu
 */
    @Override
    public void aktivoidu(Robotti robo, int vuoro) {
        if (aktivoituu%2==vuoro%2) {
        robo.tuhoudu();  
        }
    }
/**
 * @return palauttaa aktivoituuko parittomilla via parillisilla vuoroilla 
 */
    @Override
    public int getGrafiikkaluku() {
        return aktivoituu;
    }
    
}
