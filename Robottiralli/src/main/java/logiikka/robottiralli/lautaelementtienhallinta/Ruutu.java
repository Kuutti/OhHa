

package logiikka.robottiralli.lautaelementtienhallinta;

import java.util.ArrayList;
import logiikka.robottiralli.robottienhallinta.Robotti;

public class Ruutu {
    int x;
    int y;
    Robotti robotti=null; 
    ArrayList<Robotti> holorobot=new ArrayList<>();
    ArrayList<Ruudunvieva> ruudussa=new ArrayList<>();
    
    
    public Ruutu(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void lisaaElementti(Ruudunvieva elementti){
        ruudussa.add(elementti);
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

    public boolean onRobotti(){
        return robotti != null;
    }

    public ArrayList<Ruudunvieva> getRuudussa() {
        return ruudussa;
    }

    public Robotti getRobotti() {
        return robotti;
    }
    
    public void lisaaholorobo(Robotti robo){
        holorobot.add(robo);
    }
    
    public void poistaholorobo(Robotti robo){
        holorobot.remove(robo);
    }

   
}
