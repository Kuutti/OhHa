/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logiikka.robottiralli.hallinnat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import logiikka.robottiralli.lautaelementtienhallinta.Laser;
import logiikka.robottiralli.lautaelementtienhallinta.Lauta;
import logiikka.robottiralli.lautaelementtienhallinta.Ruutu;
import logiikka.robottiralli.pelaajienhallinta.Pelaaja;
import logiikka.robottiralli.robottienhallinta.Robotti;



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
    public void robotAmpuu(ArrayList<Pelaaja> pelaajat) {
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
    public void ampuminen(Ruutu ruutu, int suunta) {
       // ArrayList<Robotti>kohteet=new ArrayList<>();
        Set<Robotti>kohteet=onkoEdessarobottia(ruutu, suunta);
        for (Robotti robotti : kohteet) {
            robotti.otaVahinkoa(1);
        }
    }

    /**
     * Palautetaan olion edessä oleva robotti, jos ei ole robottia, palautetaan null.
     * @param ruutu ruutu, jossa  olio on
     * @param suunta Suunta, johon olio katsoo.
     * @return 
     */
    public Set<Robotti> onkoEdessarobottia(Ruutu ruutu, int suunta) {
            Set<Ruutu>ruudut= new HashSet<>(); //bad code            
            ruudut.add(ruutu);
            Ruutu next=lauta.seuraavaRuutu(ruutu, suunta);
            ruudut.add(next);
            if (lauta.getSeinat().contains(ruudut)||!lauta.onLaudalla(next)) {
                return new HashSet<>();
            } else if (next.getRobotti()!=null||!next.getHolorobot().isEmpty()) { 
                Set<Robotti> kohteet=new HashSet<>();
                for (Robotti robotti : next.getHolorobot()) {
                    kohteet.add(robotti);
                }
                if (next.getRobotti()!=null) {
                    kohteet.add(next.getRobotti());
                }
                return kohteet;
            }
        return onkoEdessarobottia(next,suunta);
    }
/**
 * Hoidetaan laudalla olevien laserien ampuminen ja päivitetään robotin vahinko
 * tarvittaessa.
 */
    public void laseritAmpuu() {
        for (Laser laser : lauta.getLaserit()) {
            if (laser.getRuutu().onRobotti()||!laser.getRuutu().getHolorobot().isEmpty()) {
                if (laser.getRuutu().onRobotti()) {
                    laser.getRuutu().getRobotti().otaVahinkoa(1);
                }
                for (Robotti robotti : laser.getRuutu().getHolorobot()) {
                    robotti.otaVahinkoa(1);
                }
            } else {
                ampuminen(laser.getRuutu(),laser.getSuunta());
            }
        }
    }

    
    
}
