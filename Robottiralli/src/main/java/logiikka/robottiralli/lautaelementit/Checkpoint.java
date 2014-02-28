/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logiikka.robottiralli.lautaelementit;

import logiikka.robottiralli.lautaelementtienhallinta.Elementti;
import logiikka.robottiralli.lautaelementtienhallinta.Ruutu;
import logiikka.robottiralli.robottienhallinta.Robotti;

public class Checkpoint implements Elementti{
    /**
     * Monesko checkpoint on kyseessä.
     */
    int mones;
    /**
     * Seuraava checkpoint
     */
    Ruutu seuraava;

    public Checkpoint(int mones, Ruutu seuraava) {
        this.mones=mones;
        this.seuraava = seuraava;
    }
    
    @Override
    public String tyyppi() {
        return "checkpoint";
    }
/**
 * Jos robotin seuraava checkpoint on tämä, robotin seuraavacp päivittyy
 * seuraavaksi. Jos seuraava on null pelaaja, jonka robotti on kyseessä voittaa.
 * @param robo Tarkasteltava robotti
 * @param vuoro Ei tarvita
 */
    @Override
    public void aktivoidu(Robotti robo, int vuoro) {
        robo.setRespawn(robo.getRuutu());
        if (robo.getSeuraavacp()==robo.getRuutu()) {
            robo.setSeuraavacp(seuraava);

        }
        if (vuoro==5&&robo.isActive()) {
            robo.korjaa(1);
        }
    }
/**
 * @return palauttaa monesko checkpoint on kyseessä.
 */
    @Override
    public int getGrafiikkaluku() {
        return mones;
    }
    
}
