/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logiikka.robottiralli.hallinat;

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

    void teeVuorot(ArrayList<Pelaaja> pelaajat, Lautapiirrin piirrin) {
        Lautaelementtienaktivoija aktivoija=new Lautaelementtienaktivoija(lauta);
        RobojenLiikuttaja liikuttaja=new RobojenLiikuttaja(lauta);
        for (int i = 0; i < 5; i++) {
            for (Pelaaja pelaaja : pelaajat) {
                if (pelaaja.getRobotti().isActive()) {
                    liikuttaja.suoritaKomento(pelaaja.getOhjelma().get(i), pelaaja.getRobotti());
                    if (!lauta.onLaudalla(pelaaja.getRobotti().getRuutu())) {
                        pelaaja.getRobotti().tuhoudu();
                    }
                }
            }

            piirrin.repaint();
            try {
                Thread.sleep(1000);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            aktivoija.aktivoi(pelaajat,i+1);
            piirrin.repaint();
            Laserzhallinta hallinta=new Laserzhallinta(lauta);
            hallinta.ammulaserz(pelaajat);
        }
             
    }
    
}
