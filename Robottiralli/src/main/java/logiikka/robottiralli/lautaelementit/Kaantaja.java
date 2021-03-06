/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logiikka.robottiralli.lautaelementit;

import logiikka.robottiralli.lautaelementtienhallinta.Elementti;
import logiikka.robottiralli.robottienhallinta.Robotti;




public class Kaantaja implements Elementti{
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
    public int getGrafiikkaluku() {
       return Kaannosmaara;
    }
    
   
   
    
}
