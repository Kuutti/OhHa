/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logiikka.robottiralli.lautaelementtienhallinta;

import logiikka.robottiralli.hallinnat.Lautaelementtienaktivoija;
import java.util.ArrayList;
import logiikka.robottiralli.lautaelementit.Kaantaja;
import logiikka.robottiralli.pelaajienhallinta.Ihmispelaaja;
import logiikka.robottiralli.pelaajienhallinta.Pelaaja;
import logiikka.robottiralli.robottienhallinta.Robotti;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author KOTIPC
 */
public class LautaelementtienaktivoijaTest {
    
    Lautaelementtienaktivoija aktivoija;
    ArrayList<Pelaaja> pelaajat=new ArrayList<>();
    
    @Before
    public void setUp() {
        Lauta lauta=new Lauta(10);
        Ruutu ruutu=new Ruutu(2,2);
        Kaantaja kaantaja=new Kaantaja(1);
        ruutu.lisaaElementti(kaantaja);
        Robotti robo=new Robotti(ruutu,2);
        pelaajat.add(new Ihmispelaaja(robo,1));
        ruutu.setRobotti(robo);
        lauta.pelilauta[2][2]=ruutu;
        aktivoija=new Lautaelementtienaktivoija(lauta);
    }
    
    @Test
    public void toimii(){
        aktivoija.aktivoi(pelaajat, 1);
        assertEquals(3,pelaajat.get(0).getRobotti().getSuunta());
    }
    
    
    
}
