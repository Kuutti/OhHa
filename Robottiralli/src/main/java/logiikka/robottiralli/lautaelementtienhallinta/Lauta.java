 


package logiikka.robottiralli.lautaelementtienhallinta;

import logiikka.robottiralli.robottienhallinta.Robotti;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

//muutettava vain antamaan ja varastoimaan tietoa

public class Lauta {
    int leveys;
    int korkeus;
    Ruutu aloitus;
    Ruutu maali;
    Ruutu[][] pelilauta;
    ArrayList<Set<Ruutu>>seinat=new ArrayList<>();
    ArrayList<Laser> laserit=new ArrayList<>();

    public ArrayList<Laser> getLaserit() {
        return laserit;
    }
    ArrayList<Robotti> robot=new ArrayList<>();
 
   

    public int getLeveys() {
        return leveys;
    }

    public ArrayList<Set<Ruutu>> getSeinat() {
        return seinat;
    }

    public void AddRobo(Robotti robo){
        robot.add(robo);
    }
    
    public int getKorkeus() {
        return korkeus;
    }

    public Lauta(int leveys, int korkeus) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        pelilauta=new Ruutu[leveys][korkeus];
        for (int i = 0; i < leveys; i++) {
            for (int j = 0; j < korkeus; j++) {
                pelilauta[i][j]=new Ruutu(i,j);
            }
        }
    }

    public void setAloitus(int x, int y) {
        this.aloitus = new Ruutu(x,y);
    }
    
    public Ruutu getAloitus(){
        return aloitus;
    }
    
    public void setMaali(int x, int y){
        maali=new Ruutu(x,y);
    }

    public Ruutu getMaali() {
        return maali;
    }

    //muualle
    public boolean onRobotti(Ruutu ruutu) {
        return pelilauta[ruutu.getX()][ruutu.getY()].onRobotti();
    }

    public void addSeina(Ruutu sijainti, Ruutu seuraava) {
        Set<Ruutu> seina=new HashSet<>();
        seina.add(sijainti);
        seina.add(seuraava);
        seinat.add(seina);
    }

    public boolean onLaudalla(Ruutu sijainti){
        return sijainti.getX()>0&&sijainti.getX()<= leveys && sijainti.getY() > 0 && sijainti.getY() <= korkeus;
    }

    public Ruutu seuraavaRuutu(Ruutu ruutu, int suunta) {
             int vipu=(suunta)%4;
            switch (vipu) {
            case 0: ruutu=pelilauta[ruutu.getX()][ruutu.getY()+1];
                break;
            case 1: ruutu=pelilauta[ruutu.getX()+1][ruutu.getY()];
                break;
            case 2: ruutu=pelilauta[ruutu.getX()][ruutu.getY()-1];
                break;
            case 3: ruutu=pelilauta[ruutu.getX()-1][ruutu.getY()];
                break;
        }
        return ruutu;
    }

    public Robotti robottiRuudussa(Ruutu ruutu) {
        return pelilauta[ruutu.getX()][ruutu.getY()].getRobotti();
    }

    void aktivoiRuudussa(String elementti,Ruutu ruutu, int vuoro) {
        for (Ruudunvieva osa : ruutu.getRuudussa()) {
            if (osa.tyyppi().matches(elementti)) {
                osa.aktivoidu(this, ruutu, vuoro);
            }
        }
    }

    
  
   
   
}
