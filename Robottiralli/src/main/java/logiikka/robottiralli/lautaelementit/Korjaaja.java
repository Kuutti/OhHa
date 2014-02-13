/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logiikka.robottiralli.lautaelementit;

import logiikka.robottiralli.lautaelementtienhallinta.Lauta;
import logiikka.robottiralli.lautaelementtienhallinta.Ruudunvieva;
import logiikka.robottiralli.lautaelementtienhallinta.Ruutu;
import logiikka.robottiralli.robottienhallinta.Robotti;

/**
 *
 * @author KOTIPC
 */
public class Korjaaja implements Ruudunvieva{
    
    /**
     * Kuinka tehkkaasti robottia korjataan
     */
    int teho;

    public Korjaaja(int i) {
        teho=i;
    }
    

    @Override
    public String tyyppi() {
        return "korjaaja";
    }
/**
 * Asettaa robotin respawnin Korjaajan ruutun ja, jos vuoro on viisi,
 * korjaa robottia tehon verran.
 * @param robo Robotti, jonka respawn vaihdetaan ja jota korjataan.
 * @param vuoro monta ohjelman käskyä on suoritettu.
 */
    @Override
    public void aktivoidu(Robotti robo, int vuoro) {
        robo.setRespawn(robo.getRuutu());
        if (vuoro==5) {
            robo.korjaa(teho);
        }
    }
/**
 * @return palauttaa Korjaajan tehon.
 */
    @Override
    public Integer getErikoisint() {
        return teho;
    }
    
}
