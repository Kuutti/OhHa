/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logiikka.robottiralli.hallinnat;

import Kayttoliittyma.Lautapiirrin;
import java.util.ArrayList;
import logiikka.robottiralli.lautaelementtienhallinta.Lauta;
import logiikka.robottiralli.pelaajienhallinta.Pelaaja;

/**
 *
 * @author KOTIPC
 */
public class Vuorontoteuttaja {

    Lauta lauta;
    
    Vuorontoteuttaja(Lauta lauta) {
        this.lauta=lauta;
    }
    /**
     * Toteuttaa Vuoron aikana tarvittavat asiat.
     * @param pelaajat
     * @param piirrin 
     */
    void teeVuorot(ArrayList<Pelaaja> pelaajat, Lautapiirrin piirrin) {
        Lautaelementtienaktivoija aktivoija=new Lautaelementtienaktivoija(lauta);
        RobojenLiikuttaja liikuttaja=new RobojenLiikuttaja(lauta);
        tarkistaShutdown(pelaajat);
        for (int i = 0; i < 5; i++) {
            suoritaKomennot(pelaajat, liikuttaja, i);
            piirrin.repaint();
            odota(1000);
            aktivoija.aktivoi(pelaajat,i+1);
            piirrin.repaint();
            Laserzhallinta hallinta=new Laserzhallinta(lauta);
            hallinta.ammulaserz(pelaajat);
        }
             
    }

    /**
     * Odottaa parametrina annetun ajan, jotta pelaajat ehtivät
     * huomata mitä laudalla tapahtuu.
     * @param odotus 
     */
    public void odota(int odotus) {
        try {
            Thread.sleep(odotus);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Suorittaa pelaajien antaman koodin robotille kortti kerrallaan.
     * @param pelaajat
     * @param liikuttaja
     * @param i 
     */
    public void suoritaKomennot(ArrayList<Pelaaja> pelaajat, RobojenLiikuttaja liikuttaja, int i) {
        for (Pelaaja pelaaja : pelaajat) {
            if (pelaaja.getRobotti().isActive()) {
                liikuttaja.suoritaKomento(pelaaja.getOhjelma().get(i), pelaaja.getRobotti());
                if (!lauta.onLaudalla(pelaaja.getRobotti().getRuutu())) {
                    pelaaja.getRobotti().tuhoudu();
                }
            }
        }
    }

    /**
     * Tarkistaa onko pelaajilla shutdown-tilassa olevia robotteja. Jos
     * näin on robotit korjataan.
     * @param pelaajat 
     */
    private void tarkistaShutdown(ArrayList<Pelaaja> pelaajat) {
        for (Pelaaja pelaaja : pelaajat) {
            if (!pelaaja.getRobotti().isActive()) {
                pelaaja.getRobotti().korjaa(10);
            }
        }
    }


    
}
