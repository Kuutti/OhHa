 


package logiikka.robottiralli.lautaelementtienhallinta;

import java.util.ArrayList;
import java.util.HashSet;



public class Lauta {
    int koko;
    /**
     * Aloitusruutu, josta kisa alkaa.
     */
    Ruutu aloitus;
    /**
     * Taulukko pelilaudalla olevista ruuduista. 0-rivillä olevat ruudut
     * ovat tyhjiä.
     */
    Ruutu[][] pelilauta;
    /**
     * Lista laudalla olevista seinistä. Seinä on ilmoitettu kahdella
     * ruudulla, joiden väliin seinä jää.
     */
    ArrayList<HashSet<Ruutu>>seinat=new ArrayList<>();
    /**
     * Lista laudalla olevista lasereista.
     */
    ArrayList<Laser> laserit=new ArrayList<>();
 
    public ArrayList<Laser> getLaserit() {
        return laserit;
    }

    

    public ArrayList<HashSet<Ruutu>> getSeinat() {
        return seinat;
    }
    
   

    public Lauta(int koko) {
        this.koko=koko;
        pelilauta=new Ruutu[koko+2][koko+2];
        for (int i = 0; i < koko+2; i++) {
            for (int j = 0; j < koko+2; j++) {
                pelilauta[i][j]=new Ruutu(i,j);
            }
        }
    }

    public void setAloitus(Ruutu ruutu) {
        this.aloitus = ruutu;
    }
    
    public Ruutu getAloitus(){
        return aloitus;
    }
   
    public boolean onRobotti(Ruutu ruutu) {
        return pelilauta[ruutu.getX()][ruutu.getY()].onRobotti();
    }

    public void addSeina(Ruutu sijainti, Ruutu seuraava) {
        HashSet<Ruutu> seina=new HashSet<>();
        seina.add(sijainti);
        seina.add(seuraava);
        seinat.add(seina);
    }
/**
 * Tarkistaa onko sijainti laudalla. Palauttaa true, jos on laudalla.
 * @param sijainti Tarkastettava sijainti.
 * @return Jos sijainti on laudalla palauttaa truen;
 */
    public boolean onLaudalla(Ruutu sijainti){
        return sijainti.getX()>0&&sijainti.getX()<= koko && sijainti.getY() > 0 && sijainti.getY() <= koko;
    }
/**
 * Palauttaa annettua ruutua annetussa suunnassa olevan ruudun.
 * @param ruutu Ruutu, jonka viereistä ruutua halutaan selville.
 * @param suunta Suunta, josta viereistä ruutua halutaan
 * @return Palauttaa annettua ruutua annetussa suunnassa olevan ruudun.
 */
    public Ruutu seuraavaRuutu(Ruutu ruutu, int suunta) {
             int vipu=(suunta)%4;
            switch (vipu) {
            case 0: if (ruutu.getY()==koko-1) {
                    return null;
                }
                ruutu=pelilauta[ruutu.getX()][ruutu.getY()+1];
                break;
            case 1: if (ruutu.getX()==koko-1) {
                    return null;
                }
                ruutu=pelilauta[ruutu.getX()+1][ruutu.getY()];
                break;
            case 2: if (ruutu.getY()<1) {
                    return null;
                }
                ruutu=pelilauta[ruutu.getX()][ruutu.getY()-1];
                break;
            case 3: if (ruutu.getX()<1) {
                    return null;
                }
                ruutu=pelilauta[ruutu.getX()-1][ruutu.getY()];
                break;
        }
        return ruutu;
    }

    public void addLaser(Laser laser){
        laserit.add(laser);
    }
    
    public Ruutu[][] getPelilauta() {
        return pelilauta;
    }

    public int getKoko() {
        return koko;
    }
    
    

    
  
   
   
}
