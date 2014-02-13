/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logiikka.robottiralli.lautaelementtienhallinta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import logiikka.robottiralli.pelaajienhallinta.Pelaaja;

public class Lautaelementtienaktivoija {
    /**
     * Pelissä käyettävä lauta
     */
    Lauta lauta;
    /**
     * Lista elementeistä, jotka käydään läpi tietyssä järjestyksessä.
     */
    List<String> elementit=Arrays.asList("liukuhihna","tyonnin","kaantaja","murskain","kuoppa","checkpoint", "korjaaja");

    public Lautaelementtienaktivoija(Lauta lauta) {
        this.lauta = lauta;
        
    }
/**
 * Tarkistaa jokaiselta pelaajalta onko pelaajan robotti samassa ruudussa jonkun
 * lautaelementin kanssa. Jos näin on lautaelementti aktivoituu.
 * @param pelaajat Lista pelaajista, jotka pelaavat peliä.
 * @param vuoro Monta korttia pelaajien ohjelmista on paljastettu.
 */
    public void aktivoi(ArrayList<Pelaaja> pelaajat, int vuoro) {
        for (String elementti : elementit) { 
            for (Pelaaja pelaaja : pelaajat) {
                if (pelaaja.getRobotti().getRuutu().getRuudussa()!=null) {
                       if (pelaaja.getRobotti().getRuutu().getRuudussa().tyyppi().matches(elementti)) {
                   pelaaja.getRobotti().getRuutu().getRuudussa().aktivoidu(pelaaja.getRobotti(), vuoro); 
                }
                   
        }
        }
    }  
    }
    
    
}
