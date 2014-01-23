

package rr.robottiralli;

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

    public void setSijainti(Sijainti sijainti) {
        this.sijainti = sijainti;
    }
    
    public void liiku(int m){
        int vipu=suunta.getX();
        switch (vipu) {
            case 0: sijainti.ylospain(m);
                break;
            case 1: sijainti.oikealle(m);
                break;
            case 2: sijainti.alaspain(m);
                break;
            case 3: sijainti.vasemmalle(m);
                break;
        }
    }
    
    public boolean onkoLaudalla(int leveys, int korkeus){
        return sijainti.getX() >= 1 && sijainti.getX() <= leveys && sijainti.getY() >= 1 && sijainti.getY() <= korkeus;
    }

    void setSijainti(int x, int y) {
        sijainti=new Sijainti(x, y);
    }
}
