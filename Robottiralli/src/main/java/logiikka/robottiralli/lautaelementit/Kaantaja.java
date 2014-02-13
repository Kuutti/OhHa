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




public class Kaantaja implements Ruudunvieva{
   /**
    * Kuinka paljon robottia käännetään oikealle.
    */
    int Kaannosmaara;
    
    public Kaantaja( int Kaannossuunta) {
        this.Kaannosmaara = Kaannossuunta;
    }

    @Override
    public String tyyppi() {
        return "kaantaja";
    }

    /**
     *Robottia kaannosmaaran verran.
     * @param robo Kaannettava robotti.
     * @param vuoro Ei tarvita
     */
    @Override
    public void aktivoidu(Robotti robo, int vuoro) {
        robo.setSuunta(robo.getSuunta()+Kaannosmaara);
    }
 /**
  * @return  palauttaa kaannosmaaran.
  */
    @Override
    public int getErikoisint() {
       return Kaannosmaara;
    }
    
   
   
    
}
