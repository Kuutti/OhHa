

package rr.robottiralli;

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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void ylospain(int m){
        y=y+m;
    }
    public void alaspain(int m){
        y=y-m;
    }
    public void oikealle(int m){
        x=x+m;
    }
    public void vasemmalle(int m){
        x=x-m;
    }
}
