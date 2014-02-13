/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logiikka.robottiralli.lautaelementit;

import logiikka.robottiralli.lautaelementtienhallinta.Ruudunvieva;
import logiikka.robottiralli.lautaelementtienhallinta.Ruutu;
import logiikka.robottiralli.robottienhallinta.Robotti;

/**
 *
 * @author KOTIPC
 */
public class Checkpoint implements Ruudunvieva{

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
        if (robo.getSeuraavacp()==robo.getRuutu()) {
            if (seuraava==null) {
                //voitto
            }
            robo.setSeuraavacp(seuraava);
        }
        if (vuoro==5) {
            robo.korjaa(1);
        }
    }
/**
 * @return palauttaa monesko checkpoint on kyseessä.
 */
    @Override
    public Integer getErikoisint() {
        return mones;
    }
    
}
