

package logiikka.robottiralli.lautaelementtienhallinta;

import logiikka.robottiralli.robottienhallinta.Robotti;
import java.util.ArrayList;
import java.util.Set;


public class Lauta {
    int leveys;
    int korkeus;
    Sijainti aloitus;
    Sijainti maali;
    ArrayList<Robotti> robotit;
    ArrayList<Set<Sijainti>> seinat=new ArrayList<>();

    public int getLeveys() {
        return leveys;
    }

    public ArrayList<Set<Sijainti>> getSeinat() {
        return seinat;
    }

    public int getKorkeus() {
        return korkeus;
    }

    public Lauta(int leveys, int korkeus) {
        this.leveys = leveys;
        this.korkeus = korkeus;
    }

    public void setAloitus(int x, int y) {
        //erroria jos aloitus ei laudalla
        this.aloitus = new Sijainti(x,y);
    }

    public Sijainti getAloitus() {
        return aloitus;
    }
    
    public void setMaali(int x, int y){
        //erroria jos maali ei laudalla
        maali=new Sijainti(x,y);
    }

    public Sijainti getMaali() {
        return maali;
    }
    
   
   
}
