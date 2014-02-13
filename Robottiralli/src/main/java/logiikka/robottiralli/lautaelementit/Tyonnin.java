/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logiikka.robottiralli.lautaelementit;

import java.util.ArrayList;
import logiikka.robottiralli.lautaelementtienhallinta.Lauta;
import logiikka.robottiralli.lautaelementtienhallinta.Ruudunvieva;
import logiikka.robottiralli.lautaelementtienhallinta.Ruutu;
import logiikka.robottiralli.robottienhallinta.Robotti;

/**
 *
 * @author KOTIPC
 */
public class Tyonnin implements Ruudunvieva{
/**
 * Ruutu, johon työnnin työntää robotin.
 */
    Ruutu tyonnettavaRuutu;
    /**
     * Ilmaisee aktivoituuko työnnin parillisilla vai parittomilla vuoroilla
     */
    Integer aktivoituu;
    /**
     * Piirtämistä varten suunta johon työnnetään robotti.
     */
    Integer suunta;
    
    @Override
    public String tyyppi() {
        return "tyonnin";
    }

    public Tyonnin(Ruutu tyonnettavaRuutu, Integer aktivoituu, Integer suunta) {
        this.tyonnettavaRuutu = tyonnettavaRuutu;
        this.aktivoituu = aktivoituu;
        this.suunta=suunta;
    }

    /**
     * Siirtää robotin työnnettävään ruutuun, jossa vuoro on oikea.
     * @param robo Robotti, jota työnnetään
     * @param vuoro monta ohjelman käskyä on toteutettu
     */
    @Override
    public void aktivoidu(Robotti robo, int vuoro) {
        if (aktivoituu%2==vuoro%2) {
           robo.setRuutu(tyonnettavaRuutu);
        }
    }
/**  
 * @return palauttaa suunnan, joka on välillä 0-3, kun työnnin aktivoituu
 * parillisilla vuoroilla ja 4-7, kun aktivoituu parittomilla.
 */
    @Override
    public int getErikoisint() {
        return 4*(aktivoituu%2)+suunta;
    }
    
}
