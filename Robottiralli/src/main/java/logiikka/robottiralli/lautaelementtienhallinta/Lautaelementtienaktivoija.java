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
    Lauta lauta;
    ArrayList<Pelaaja> pelaajat;
    List<String> elementit=Arrays.asList("liukuhihna","tyonnin","kaantaja","murskain","kuoppa","checkpoint", "korjaaja");

    public Lautaelementtienaktivoija(Lauta lauta) {
        this.lauta = lauta;
        
    }

    public void aktivoi(ArrayList<Pelaaja> pelaajat, int vuoro) {
        this.pelaajat=pelaajat;
        for (String elementti : elementit) { 
            for (Pelaaja pelaaja : pelaajat) {
               lauta.aktivoiRuudussa(elementti , pelaaja.getRobotti().getRuutu(), vuoro);        
        }
        }
    }

   
}
