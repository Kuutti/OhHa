

package logiikka.robottiralli.robottienhallinta;

import logiikka.robottiralli.lautaelementtienhallinta.Sijainti;
import logiikka.robottiralli.korttienhallinta.Kortti;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import logiikka.robottiralli.lautaelementtienhallinta.Lauta;
import logiikka.robottiralli.pelaajienhallinta.Pelaaja;


public class RobojenLiikuttaja {
    
    Lauta lauta;
    
    
    RobojenLiikuttaja(Lauta lauta) {
        this.lauta=lauta;
    }

    void toteutaOhjelmat(HashMap<Pelaaja, List<Kortti>> ohjelmat) {
        for (int i = 0; i < 5; i++) {
            for (Pelaaja peluri : ohjelmat.keySet()) {
                if (peluri.getRobotti().isActive()) {
                switch(ohjelmat.get(peluri).get(i).getToiminto()){                 
                    case KAANNOSOIKEALLE: peluri.getRobotti().getSuunta().kaannyOikealle();
                        break;
                    case KAANNOSVASEMMALLE:peluri.getRobotti().getSuunta().kaannyVasemmalle();
                        break;
                    case UKAANNOS:peluri.getRobotti().getSuunta().uKaannos();
                        break;
                    case YKSIETEEN: liikuta(peluri.getRobotti(),1, peluri.getRobotti().getSuunta().getX());
                        break;
                    case KAKSIETEEN:liikuta(peluri.getRobotti(),2,peluri.getRobotti().getSuunta().getX());
                        break;
                    case KOLMEETEEN:liikuta(peluri.getRobotti(),3,peluri.getRobotti().getSuunta().getX());
                        break;
                    case PERUUTUS: liikuta(peluri.getRobotti(),1,peluri.getRobotti().getSuunta().getX()+2);
                        break;
                }
                }
            }            
        }
        kaikkiRobotitAktiivisiksi(ohjelmat);
    }

    private void liikuta(Robotti robo, int i, int suunta) {
        for (int j = 0; j < i; j++) {
            Set<Sijainti>ruudut= new HashSet<>();
            ruudut.add(robo.getSijainti());
            Sijainti seuraavaRuutu=robo.SuunnassaOlevaRuutu(suunta);
            ruudut.add(seuraavaRuutu);
            if (lauta.getSeinat().contains(ruudut)) {
                break;
            } else if (lauta.onRobotti(seuraavaRuutu)) {
                Robotti tiella=lauta.robottiRuudussa(seuraavaRuutu);
                liikuta(tiella,1,suunta);
            }
            robo.liiku(suunta);
            lauta.onkoRobotitLaudalla();
        }
    }

    private void kaikkiRobotitAktiivisiksi(HashMap<Pelaaja, List<Kortti>> ohjelmat) {
        for (Pelaaja peluri : ohjelmat.keySet()) {
            peluri.getRobotti().setActive(true);
        }
    }


    
}
