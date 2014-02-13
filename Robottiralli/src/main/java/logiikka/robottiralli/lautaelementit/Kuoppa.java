/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logiikka.robottiralli.lautaelementit;

import logiikka.robottiralli.lautaelementtienhallinta.Ruudunvieva;
import logiikka.robottiralli.robottienhallinta.Robotti;

/**
 *
 * @author KOTIPC
 */
public class Kuoppa implements Ruudunvieva{
    
  
    public Kuoppa() {
    }

    @Override
    public String tyyppi() {
        return "kuoppa";
    }
/**
 * Tuhoaa kuopan päällä olevan robotin.
 * @param robo Tuhottava robotti
 * @param vuoro Ei tarvita
 */
    @Override
    public void aktivoidu(Robotti robo, int vuoro) {
        robo.tuhoudu(); 
    }

    /**
     * Ei tarvita
     * @return 
     */
    @Override
    public Integer getErikoisint() {
        return 0;
    }
    
}
