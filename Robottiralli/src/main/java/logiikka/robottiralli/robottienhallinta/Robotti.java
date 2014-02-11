

package logiikka.robottiralli.robottienhallinta;

import logiikka.robottiralli.lautaelementtienhallinta.Ruutu;

public class Robotti {
   int suunta;
   int vahinko=0;
   Ruutu seuraavacp;
   Ruutu respawn=null;
   Boolean active=true;
   Boolean holo=true;
   Ruutu ruutu;

    

    public void setRuutu(Ruutu ruutu) {
        this.ruutu.setRobotti(null);
        this.ruutu = ruutu;
        this.ruutu.setRobotti(this);
    }

    public Ruutu getSeuraavacp() {
        return seuraavacp;
    }

    public void setSeuraavacp(Ruutu seuraavacp) {
        this.seuraavacp = seuraavacp;
    }
    
    
    
    public Boolean isActive() {
        return active;
    }

    public Robotti (Ruutu ruutu, int z) {
        this.ruutu=ruutu;
        suunta=z%4;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean isHolo() {
        return holo;
    }

    public Ruutu getRespawn() {
        return respawn;
    }

    public void setHolo(Boolean holo) {
        this.holo = holo;
    }
    
    public void setRespawn(Ruutu respawn)  {   
            this.respawn = respawn;
    }

    public Ruutu Respawn(){
        return respawn;
    }

    public void tuhoudu(){
        holo=true;
        active=false;
        vahinko=2;
    }   
    
    public int getVahinko() {
        return vahinko;
    }

    public void setVahinko(int vahinko) {
        this.vahinko = Math.max(vahinko, 0);
    }

    public int getSuunta() {
        return suunta;
    }

    public void setSuunta(int x) {
        suunta=x%4;
    }

    public Ruutu getRuutu() {
        return ruutu;
    }

    public void korjaa(int teho) {
        vahinko=vahinko-2;
    }

    

    

    
}
