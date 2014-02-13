/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logiikka.robottiralli.robottienhallinta;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import logiikka.robottiralli.lautaelementtienhallinta.Laser;
import logiikka.robottiralli.lautaelementtienhallinta.Lauta;
import logiikka.robottiralli.lautaelementtienhallinta.Ruutu;
import logiikka.robottiralli.pelaajienhallinta.Pelaaja;



public class Laserzhallinta {
/**
 * Pelissä käytettävä lauta
 */
    Lauta lauta;
    
   
    
    Laserzhallinta(Lauta lauta) {
        this.lauta=lauta;
        
    }
/**
 * Huolehditaan, että pelaajat ja laudalla olevat laserit ampuvat.
 * @param pelaajat joiden robotit ampuvat.
 */
    public void ammulaserz(ArrayList<Pelaaja> pelaajat) {
        robotAmpuu(pelaajat);
        laseritAmpuu();
    }
/**
 * Hoidetaan pelaajien robottien ampuminen.
 * @param pelaajat joiden robotit ampuvat.
 */
    private void robotAmpuu(ArrayList<Pelaaja> pelaajat) {
        for (Pelaaja pelaaja : pelaajat) {
            if (pelaaja.getRobotti().isActive()&&!pelaaja.getRobotti().isHolo()) {
                ampuminen(pelaaja.getRobotti().getRuutu(),pelaaja.getRobotti().getSuunta());  
            }
        }
    }
/**
 * Ammutaan ruudusta tiettyyn suuntaan ja jos osutaan robottiin, se ottaa vahingon.
 * @param ruutu Ruutu, josta ammutaan.
 * @param suunta Suunta, johon ammutaan.
 */
    private void ampuminen(Ruutu ruutu, int suunta) {
        Robotti kohde=null;
        kohde=onkoEdessärobottia(ruutu, suunta);
        if (kohde!=null) {
            kohde.otaVahinkoa(kohde.getVahinko()+1);
        }
    }

    /**
     * Palautetaan olion edessä oleva robotti, jos ei ole robottia, palautetaan null.
     * @param ruutu ruutu, jossa  olio on
     * @param suunta Suunta, johon olio katsoo.
     * @return 
     */
    private Robotti onkoEdessärobottia(Ruutu ruutu, int suunta) {
        Set<Ruutu>ruudut= new HashSet<>(); //bad code            
            ruudut.add(ruutu);
             Ruutu next=lauta.seuraavaRuutu(ruutu, suunta);
            ruudut.add(next);
            if (lauta.getSeinat().contains(ruudut)||!lauta.onLaudalla(next)) {
                return null;
            } else if (next.getRobotti()!=null) {                
                return next.getRobotti();
            }
        return onkoEdessärobottia(next,suunta);
    }
/**
 * Hoidetaan laudalla olevien laserien ampuminen ja päivitetään robotin vahinko
 * tarvittaessa.
 */
    private void laseritAmpuu() {
        for (Laser laser : lauta.getLaserit()) {
            if (laser.getRuutu().onRobotti()) {
                laser.getRuutu().getRobotti().otaVahinkoa(1);
            } else {
                ampuminen(laser.getRuutu(),laser.getSuunta());
            }
        }
    }

    
    
}
