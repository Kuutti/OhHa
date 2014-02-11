/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logiikka.robottiralli.lautaelementtienhallinta;

public class Laser {
    Ruutu ruutu;
    int suunta;
    int vahinko;

    public Ruutu getRuutu() {
        return ruutu;
    }

    public int getSuunta() {
        return suunta;
    }

    public int getVahinko() {
        return vahinko;
    }

    public Laser(Ruutu ruutu, int suunta, int vahinko) {
        this.ruutu = ruutu;
        this.suunta = suunta;
        this.vahinko = vahinko;
    }
}
