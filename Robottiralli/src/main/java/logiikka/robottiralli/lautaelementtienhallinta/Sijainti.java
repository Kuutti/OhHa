

package logiikka.robottiralli.lautaelementtienhallinta;

import logiikka.robottiralli.robottienhallinta.*;

public class Sijainti {
    int x;
    int y;

    public Sijainti(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sijainti other = (Sijainti) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Sijainti "+x+","+y;
    }

    public void asetaSijainti(int x1, int y1){
        x=x1;
        y=y1;
    }
}
