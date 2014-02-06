

package logiikka.robottiralli.lautaelementtienhallinta;

import logiikka.robottiralli.robottienhallinta.Robotti;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class Lauta {
    int leveys;
    int korkeus;
    Sijainti aloitus;
    Sijainti maali;
    ArrayList<Robotti> robotit=new ArrayList<>();
    ArrayList<Set<Sijainti>> seinat=new ArrayList<>();
    ArrayList<Sijainti> kuopat=new ArrayList<>();
   

    public int getLeveys() {
        return leveys;
    }

    public ArrayList<Set<Sijainti>> getSeinat() {
        return seinat;
    }

    public void AddRobo(Robotti robo){
        robotit.add(robo);
    }
    
    public int getKorkeus() {
        return korkeus;
    }

    public Lauta(int leveys, int korkeus) {
        this.leveys = leveys;
        this.korkeus = korkeus;
    }

    public void setAloitus(int x, int y) {
        if (new Sijainti(x,y).equals(maali)||kuopat.contains(new Sijainti(x,y))) {
            return;
        }
        this.aloitus = new Sijainti(x,y);
    }

    public Sijainti getAloitus() {
        return aloitus;
    }
    
    public void setMaali(int x, int y){
        if (new Sijainti(x,y).equals(aloitus)||kuopat.contains(new Sijainti(x,y))) {
            return;
        }
        maali=new Sijainti(x,y);
    }

    public Sijainti getMaali() {
        return maali;
    }

    public boolean onRobotti(Sijainti ruutu) {
        for (Robotti robotti : robotit) {
            if (robotti.getSijainti().equals(ruutu)&&!robotti.isHolo()) {
                return true;
            }
        }
        return false;
    }

    public void addSeina(Sijainti sijainti, Sijainti seuraava) {
        Set<Sijainti> seina=new HashSet<>();
        seina.add(sijainti);
        seina.add(seuraava);
        seinat.add(seina);
    }

    public Robotti robottiRuudussa(Sijainti ruutu) {
        for (Robotti robotti : robotit) {
            if (robotti.getSijainti().equals(ruutu)) {
               return robotti; 
            }
        }
        return null;
    }

    public void addKuoppa(Sijainti kuoppa){
        if (kuoppa.equals(aloitus)||kuoppa.equals(maali)) {
            return;
        }
        kuopat.add(kuoppa);
    }

    public void onkoRobotitLaudalla() {
        for (Robotti robotti : robotit) {
            if (!robotti.onkoLaudalla(leveys, korkeus)||kuopat.contains(robotti.getSijainti())) {
                robotti.setActive(false);
                if (robotti.getCheckpoint()==null) {
                    robotti.setSijainti(aloitus);
                }
            }
        }
    }
    

    
    
   
   
}
