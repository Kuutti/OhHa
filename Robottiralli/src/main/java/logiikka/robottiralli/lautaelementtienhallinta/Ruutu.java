

package logiikka.robottiralli.lautaelementtienhallinta;

import java.util.ArrayList;
import logiikka.robottiralli.robottienhallinta.Robotti;

public class Ruutu {
    /**
     * Monesko ruutu on vaakatasossa laudalla.
     */
    int x;
    /**
     * Monesko ruutu on pystysuorassa laudalla.
     */
    int y;
    /**
     * Robotti, joka on kyseisellä ruudulla.
     */
    Robotti robotti=null; 
    /**
     * Lista ruudussa olevista hologrammiroboteista
     */
    ArrayList<Robotti> holorobot=new ArrayList<>();
    /**
     * Ruudussa oleva lautaelementti
     */
    Ruudunvieva ruudussa;
    
    
    public Ruutu(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    /**
     * Lisää ruutuun lautaelementin
     * @param elementti lisättävä lautaelementti
     */
    public void lisaaElementti(Ruudunvieva elementti){
        ruudussa=elementti;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ruutu other = (Ruutu) obj;
        if (this.x != other.x) {
            return false;
        }
        return this.y == other.y;
    }

    public void setRobotti(Robotti robotti) {
        this.robotti = robotti;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.x;
        hash = 79 * hash + this.y;
        return hash;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Sijainti "+x+","+y;
    }
/**
 * @return palauttaa true, jos ruudussa on robotti. 
 */
    public boolean onRobotti(){
        return robotti != null;
    }

    public Ruudunvieva getRuudussa() {
        return ruudussa;
    }

    public Robotti getRobotti() {
        return robotti;
    }
    /**
     * Lisää robotin hologrammina ruutuun.
     * @param robo Robotti, joka lisätään hologrammina.
     */
    public void lisaaholorobo(Robotti robo){
        holorobot.add(robo);
    }
    /**
     * Poistaa ruudusta hologrammina olevan robotin.
     * @param robo Ruudusta hologrammina poistettava robotti.
     */
    public void poistaholorobo(Robotti robo){
        holorobot.remove(robo);
    }
}
