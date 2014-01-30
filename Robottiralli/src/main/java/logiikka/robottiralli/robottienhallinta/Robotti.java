

package logiikka.robottiralli.robottienhallinta;

import logiikka.robottiralli.lautaelementtienhallinta.Sijainti;

public class Robotti {
   Suunta suunta;
   Sijainti sijainti;
   int vahinko;

    public Robotti(int x, int y, int z) {
        sijainti=new Sijainti(x,y);
        suunta=new Suunta(z);
    }
    
    public Robotti(Sijainti sijainti, int z){
        this.sijainti=sijainti;
        suunta=new Suunta(z);
    }

    public void setSijainti(Sijainti sijainti) {
        this.sijainti = sijainti;
    }
    
    public void liiku(int liikuttavasuunta){
        int vipu=(suunta.getX()+liikuttavasuunta)%4;
        switch (vipu) {
            case 0: sijainti.asetaSijainti(sijainti.getX(), sijainti.getY()+1);
                break;
            case 1: sijainti.asetaSijainti(sijainti.getX()+1, sijainti.getY());
                break;
            case 2: sijainti.asetaSijainti(sijainti.getX(), sijainti.getY()-1);
                break;
            case 3: sijainti.asetaSijainti(sijainti.getX()-1,sijainti.getY());
                break;
        }
    }
    
    public boolean onkoLaudalla(int leveys, int korkeus){
        return sijainti.getX() >= 1 && sijainti.getX() <= leveys && sijainti.getY() >= 1 && sijainti.getY() <= korkeus;
    }

    void setSijainti(int x, int y) {
        sijainti=new Sijainti(x, y);
    }
      public int getVahinko() {
        return vahinko;
    }

    public void setVahinko(int vahinko) {
        this.vahinko = vahinko;
    }

    public Suunta getSuunta() {
        return suunta;
    }

    public Sijainti getSijainti() {
        return sijainti;
    }

    public void setSuunta(int x) {
        suunta.setX(x);
    }

    public Sijainti SuunnassaOleva(int x) {
        switch((suunta.getX()+x)%4+1){
            case 1: return new Sijainti(sijainti.getX(),sijainti.getY()+1);  
            case 2: return new Sijainti(sijainti.getX()+1, sijainti.getY());
            case 3: return new Sijainti(sijainti.getX(),sijainti.getY()-1);
            case 4: return new Sijainti(sijainti.getX()-1,sijainti.getY());
      }
        return null;
    }

    public Sijainti edessaOleva() {
        return SuunnassaOleva(0);
    }
    
    public Sijainti takanaOleva(){
        return SuunnassaOleva(2);
    }
}
