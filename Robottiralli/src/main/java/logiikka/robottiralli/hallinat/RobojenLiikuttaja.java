

package logiikka.robottiralli.hallinat;

import logiikka.robottiralli.hallinat.Laserzhallinta;
import java.util.ArrayList;
import logiikka.robottiralli.lautaelementtienhallinta.Ruutu;
import java.util.HashSet;
import java.util.Set;
import logiikka.robottiralli.lautaelementtienhallinta.Lauta;
import logiikka.robottiralli.hallinat.Lautaelementtienaktivoija;
import logiikka.robottiralli.korttienhallinta.Kortti;
import logiikka.robottiralli.pelaajienhallinta.Pelaaja;
import logiikka.robottiralli.robottienhallinta.Robotti;


public class RobojenLiikuttaja {
    /**
     * Lauta, jossa peliä pelataan.
     */
    Lauta lauta;
    
    
    public RobojenLiikuttaja(Lauta lauta) {
        this.lauta=lauta;
    }

    /**
     * Laittaa jokaisen pelaajan robotin toimimaan pelaajan ohjelman mukaisesti
     * @param pelaajat Lista pelaajista, joiden robotteja liikutetaan.
     */
    
    public void suoritaKomento(Kortti kortti, Robotti robo) {
                switch(kortti.getToiminto()){                 
                    case KAANNOSOIKEALLE: robo.setSuunta(robo.getSuunta()+1);
                        break;
                    case KAANNOSVASEMMALLE:robo.setSuunta(robo.getSuunta()+3);
                        break;
                    case UKAANNOS:robo.setSuunta(robo.getSuunta()+2);
                        break;
                    case YKSIETEEN: liikuta(robo,1,robo.getSuunta());
                        break;
                    case KAKSIETEEN:liikuta(robo,2,robo.getSuunta());
                        break;
                    case KOLMEETEEN:liikuta(robo,3,robo.getSuunta());
                        break;
                    case PERUUTUS: liikuta(robo,1,robo.getSuunta()+2);
                        break;
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
            Set<Ruutu>ruudut= new HashSet<>(); 
            ruudut.add(robo.getRuutu());
             Ruutu seuraava=lauta.seuraavaRuutu(robo.getRuutu(), suunta);
             ruudut.add(seuraava);
            if (lauta.getSeinat().contains(ruudut)) {
                break;
            } else if (lauta.onRobotti(seuraava)&&!robo.isHolo()) {
                Robotti tiella=seuraava.getRobotti();
                liikuta(tiella,1,suunta);
            }
           
            if (seuraava == null) {
                robo.tuhoudu();
            } else {
            robo.setRuutu(seuraava);
            }
            if (robo.getRuutu().getRuudussa()!=null) {
                if (robo.getRuutu().getRuudussa().tyyppi().equals("kuoppa")||!lauta.onLaudalla(robo.getRuutu())) {
                robo.tuhoudu();
            }
            } 
        }
    }

   

    

    


    
}
