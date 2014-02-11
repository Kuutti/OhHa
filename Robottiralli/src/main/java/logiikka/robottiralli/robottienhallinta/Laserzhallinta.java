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

    Lauta lauta;
    
   
    
    Laserzhallinta(Lauta lauta) {
        this.lauta=lauta;
        
    }

    public void ammulaserz(ArrayList<Pelaaja> pelaajat) {
        robotAmpuu(pelaajat);
        laseritAmpuu();
    }

    private void robotAmpuu(ArrayList<Pelaaja> pelaajat) {
        for (Pelaaja pelaaja : pelaajat) {
            if (pelaaja.getRobotti().isActive()&&!pelaaja.getRobotti().isHolo()) {
                ampuminen(pelaaja.getRobotti().getRuutu(),pelaaja.getRobotti().getSuunta());  
            }
        }
    }

    private void ampuminen(Ruutu ruutu, int suunta) {
        Robotti kohde=null;
        kohde=onkoEdessärobottia(ruutu, suunta);
        if (kohde!=null) {
            kohde.setVahinko(kohde.getVahinko()+1);
        }
    }

    private Robotti onkoEdessärobottia(Ruutu sija, int suunta) {
        Set<Ruutu>ruudut= new HashSet<>(); //bad code            
            ruudut.add(sija);
             Ruutu next=lauta.seuraavaRuutu(sija, suunta);
            ruudut.add(next);
            if (lauta.getSeinat().contains(ruudut)||!lauta.onLaudalla(next)) {
                return null;
            } else if (lauta.onRobotti(next)&&!lauta.robottiRuudussa(next).isHolo()) {                
                return lauta.robottiRuudussa(next);
            }
        return onkoEdessärobottia(next,suunta);
    }

    private void laseritAmpuu() {
        for (Laser laser : lauta.getLaserit()) {
            if (laser.getRuutu().onRobotti()) {
                laser.getRuutu().getRobotti().setVahinko(laser.getVahinko()+laser.getRuutu().getRobotti().getVahinko());
            } else {
                ampuminen(laser.getRuutu(),laser.getSuunta());
            }
        }
    }

    
    
}
