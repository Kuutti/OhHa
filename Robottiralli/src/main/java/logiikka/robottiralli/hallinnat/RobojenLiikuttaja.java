

package logiikka.robottiralli.hallinnat;

import logiikka.robottiralli.lautaelementtienhallinta.Ruutu;
import java.util.HashSet;
import java.util.Set;
import logiikka.robottiralli.lautaelementtienhallinta.Lauta;
import logiikka.robottiralli.korttienhallinta.Kortti;
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
     * Laittaa robotin toimimaan komennon mukaisesti.
     */
    
    public void suoritaKomento(Kortti kortti, Robotti robo) {
                switch(kortti.getToiminto()){                 
                    case KAANNOSOIKEALLE: robo.setSuunta(robo.getSuunta()+1);
                        break;
                    case KAANNOSVASEMMALLE:robo.setSuunta(robo.getSuunta()+3);
                        break;
                    case UKAANNOS:robo.setSuunta(robo.getSuunta()+2);
                        break;
                    case YKSIETEEN: etsiRuutuJaLiiku(robo,1,robo.getSuunta());
                        break;
                    case KAKSIETEEN:etsiRuutuJaLiiku(robo,2,robo.getSuunta());
                        break;
                    case KOLMEETEEN:etsiRuutuJaLiiku(robo,3,robo.getSuunta());
                        break;
                    case PERUUTUS: etsiRuutuJaLiiku(robo,1,robo.getSuunta()+2);
                        break;
                }
                }
            
            
            
        
        
    

   /**
    * Etsii robotille ruudun johon, robotti liikkuu ja huolehtii tämän jälkeen
    * liikkumisesta. Seinän läpi ei kuitenkaan päästä ja edessä olevat robotit työnnetään.
    * @param robo robotti, jota liikutetaan.
    * @param i määrä kuinka paljon liikutetaan.
    * @param suunta mihin suuntaan liikutetaan (kuin kellotaulua, mod 4 ja nolla ylöspäin)
    */
    private boolean etsiRuutuJaLiiku(Robotti robo, int i, int suunta) {
        for (int j = 0; j < i; j++) {
            Set<Ruutu>ruudut= new HashSet<>(); 
            ruudut.add(robo.getRuutu());
             Ruutu seuraava=lauta.seuraavaRuutu(robo.getRuutu(), suunta);
             ruudut.add(seuraava);
            if (lauta.getSeinat().contains(ruudut)) {
                return false;
            } else if (lauta.onRobotti(seuraava)&&!robo.isHolo()) {
                Robotti tiella=seuraava.getRobotti();
                if (etsiRuutuJaLiiku(tiella,1,suunta)) {
                    liiku(seuraava, robo);
                }
                
            } else {
            liiku(seuraava, robo);
            }
        }
        return true;
    }
    /**
    * Liikuttaa robotin parametrina annettuun ruutuun. Jos ruutu ei ole 
    * laudalla tai on kuoppa robotti tuohoutuu.
    * @param seuraava
    * @param robo 
    */
    public void liiku(Ruutu seuraava, Robotti robo) {
        if (seuraava == null) {
            robo.tuhoudu();
        } else {
            robo.setRuutu(seuraava);
        }
        if (robo.getRuutu().getRuudussa()!=null) {
            if (robo.getRuutu().getRuudussa().tyyppi().equals("kuoppa")) {
                robo.tuhoudu();
            }
        } else {
            if (!lauta.onLaudalla(robo.getRuutu())) {
                robo.tuhoudu();
            }
        }
    }

   

    

    


    
}
