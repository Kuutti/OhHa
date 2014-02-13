

package logiikka.robottiralli.robottienhallinta;

import java.util.ArrayList;
import logiikka.robottiralli.lautaelementtienhallinta.Ruutu;
import java.util.HashSet;
import java.util.Set;
import logiikka.robottiralli.lautaelementtienhallinta.Lauta;
import logiikka.robottiralli.lautaelementtienhallinta.Lautaelementtienaktivoija;
import logiikka.robottiralli.pelaajienhallinta.Pelaaja;


public class RobojenLiikuttaja {
    /**
     * Lauta, jossa peliä pelataan.
     */
    Lauta lauta;
    
    
    RobojenLiikuttaja(Lauta lauta) {
        this.lauta=lauta;
    }

    /**
     * Laittaa jokaisen pelaajan robotin toimimaan pelaajan ohjelman mukaisesti
     * @param pelaajat Lista pelaajista, joiden robotteja liikutetaan.
     */
    
    void suoritaOhjelmat(ArrayList<Pelaaja> pelaajat) {
        Lautaelementtienaktivoija aktivoija=new Lautaelementtienaktivoija(lauta);
        for (int i = 0; i < 5; i++) {
            for (Pelaaja peluri : pelaajat) {
                if (peluri.getRobotti().isActive()) {
                switch(peluri.getOhjelma().get(i).getToiminto()){                 
                    case KAANNOSOIKEALLE: peluri.getRobotti().setSuunta(peluri.getRobotti().getSuunta()+1);
                        break;
                    case KAANNOSVASEMMALLE:peluri.getRobotti().setSuunta(peluri.getRobotti().getSuunta()+3);
                        break;
                    case UKAANNOS:peluri.getRobotti().setSuunta(peluri.getRobotti().getSuunta()+2);
                        break;
                    case YKSIETEEN: liikuta(peluri.getRobotti(),1, peluri.getRobotti().getSuunta());
                        break;
                    case KAKSIETEEN:liikuta(peluri.getRobotti(),2,peluri.getRobotti().getSuunta());
                        break;
                    case KOLMEETEEN:liikuta(peluri.getRobotti(),3,peluri.getRobotti().getSuunta());
                        break;
                    case PERUUTUS: liikuta(peluri.getRobotti(),1,peluri.getRobotti().getSuunta()+2);
                        break;
                }
                }
            } 
            aktivoija.aktivoi(pelaajat,i+1);
            Laserzhallinta hallinta=new Laserzhallinta(lauta);
            hallinta.ammulaserz(pelaajat);
        }
        
    }

   /**
    * Liikuttaa robottia tiettyyn suuntaan. Jos edessä on robotti, sitä liikutetaan myös.
    * Seinien läpi ei liikuta.
    * @param robo robotti, jota liikutetaan.
    * @param i määrä kuinka paljon liikutetaan.
    * @param suunta mihin suuntaan liikutetaan (kuin kellotaulua, mod 4 ja nolla ylöspäin)
    */
    private void liikuta(Robotti robo, int i, int suunta) {
        for (int j = 0; j < i; j++) {
            Set<Ruutu>ruudut= new HashSet<>(); //bad code
            ruudut.add(robo.getRuutu());
             Ruutu seuraava=lauta.seuraavaRuutu(robo.getRuutu(), suunta);
             ruudut.add(seuraava);
            if (lauta.getSeinat().contains(ruudut)) {
                break;
            } else if (lauta.onRobotti(seuraava)) {
                Robotti tiella=seuraava.getRobotti();
                liikuta(tiella,1,suunta);
            }
           
            robo.setRuutu(seuraava);
            
            
        }
    }

   

    

    


    
}
