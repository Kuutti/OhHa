package logiikka.robottiralli.robottienhallinta;
public class Suunta {
    int x;

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
        final Suunta other = (Suunta) obj;
        return this.x == other.x;
    }

    public Suunta(int X) {
        this.x = X%4;
    }
    
    public void kaannyOikealle(){
        x=(x+1)%4;
    }

    @Override
    public String toString() {
        return "Suunta on "+x;
    }

    public void setX(int x) {
        this.x = x%4;
    }
    
    public void kaannyVasemmalle(){
        x=(x+3)%4;
    }
    
    public void uKaannos(){
        x=(x+2)%4;
    }
    
}
