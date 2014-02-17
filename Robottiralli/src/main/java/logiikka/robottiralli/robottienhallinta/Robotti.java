

package logiikka.robottiralli.robottienhallinta;

import logiikka.robottiralli.lautaelementtienhallinta.Ruutu;

public class Robotti {
    /**
     * Suunta, johon robotti katsoo. 0 ylös, 1 oikealle jne
     */
   int suunta;
   /**
    * Paljonko vahinkoa robotti on ottanut
    */
   int vahinko=0;
   int seuraavacpnumero=0;
   /**
    * Seuraava ruutu, johon robotin on mentävä radalla
    */
   Ruutu seuraavacp;
   /**
    * Robotin kuoltua, robotti joutuu tänne hologrammina
    */
   Ruutu respawn=null;
   /**
    * Voiko robotti liikkua ja ampua vai ei
    */
   Boolean active=true;
   /**
    * Onko robotti hologrammina jolloin ei voi törmätä
    */
   Boolean holo=true;
   /**
    * Ruutu, jolla robotti on
    */
   Ruutu ruutu;

    
/**
 * Asettaa robotin tiettyyn ruutuun ja päivittää samalla ruudun tiedot.
 * Jos liikkuminen on tapahtunut tuhoutumisen yhteydessä robotti "syntyy"
 * hologrammina
 * @param ruutu sijainti johon robo liikkuu 
 */
    public void setRuutu(Ruutu ruutu) {
        this.ruutu.setRobotti(null);
        this.ruutu = ruutu;
        if (holo) {
            this.ruutu.lisaaholorobo(this);
        } else {
            this.ruutu.setRobotti(this);
        }
    }

    public Ruutu getSeuraavacp() {
        return seuraavacp;
    }

    public void setSeuraavacp(Ruutu seuraavacp) {
        this.seuraavacp = seuraavacp;
        seuraavacpnumero++;
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

    /**
     * Muuttaa robotin hologrammiksi, ei aktiiviseksi, asettaa robotin ot-
     * taman vahingon kahteen ja antaa setRuudulle komennon liikuttaa ro-
     * botti respawnille.
     */
    
    public void tuhoudu(){
        holo=true;
        active=false;
        vahinko=2;
        setRuutu(respawn);
    }   
    
    public int getVahinko() {
        return vahinko;
    }
/**
 * Lisää robotin ottamaa vahinkoa ja jos otettu vahinko on yli 9 robotti
 * tuhotaan.
 * 
 * @param vahinko robottin ottama vahinko
 */
    public void otaVahinkoa(int vahinko) {
        this.vahinko =this.vahinko+vahinko;
        if (vahinko>9) {
            tuhoudu();
        }
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
    /**
     * Korjaa robottia korjauksen tehon verran. Jos vahinko menee negatiiviselle
     * vahingoksi laitetaan nolla.
     * 
     * @param teho Kuinka paljon robottia korjataan.
     */
    public void korjaa(int teho) {
        vahinko=Math.max(0, vahinko-teho);
    }

    public int getSeuraavacpnumero() {
        return seuraavacpnumero;
    }

    

    

    
}
