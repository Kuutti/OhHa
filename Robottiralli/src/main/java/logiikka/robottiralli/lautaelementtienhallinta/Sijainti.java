

package logiikka.robottiralli.lautaelementtienhallinta;

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
        return this.y == other.y;
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

    public void asetaSijainti(int x1, int y1){
        x=x1;
        y=y1;
    }
}
