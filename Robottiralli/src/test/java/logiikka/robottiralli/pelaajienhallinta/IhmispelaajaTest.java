/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logiikka.robottiralli.pelaajienhallinta;

import java.util.ArrayList;
import logiikka.robottiralli.korttienhallinta.Kortti;
import logiikka.robottiralli.robottienhallinta.Robotti;
import java.util.List;
import logiikka.robottiralli.korttienhallinta.KortinToiminto;
import logiikka.robottiralli.korttienhallinta.Korttipakka;
import logiikka.robottiralli.lautaelementtienhallinta.Ruutu;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author KOTIPC
 */
public class IhmispelaajaTest {
    
    Ihmispelaaja peluri;
    Robotti robo;
    Korttipakka pakka;
    
    @Before
    public void setUp() {
        robo=new Robotti(new Ruutu(2,2),2);
        peluri=new Ihmispelaaja(robo,1);
        pakka=new Korttipakka();
        
    }
  
    @Test
    public void OikeaRobotti(){
        assertEquals(robo,peluri.getRobotti());
    }

    @Test
    public void monesOikein(){
        assertEquals(1,peluri.getMones());
    }
    
    @Test
    public void tyhjentaaOhjelman(){
        List<Kortti> testi=new ArrayList<>();
        testi.add(new Kortti());
        peluri.ohjelma.addAll(testi);
        peluri.getRobotti().otaVahinkoa(4);
        peluri.ohjelmaTyhjaksi();
        assertEquals(0,peluri.getOhjelma().size());
    }
    
    @Test
    public void lukittaa(){
        jaaKortit();
        peluri.getRobotti().otaVahinkoa(5);
        peluri.ohjelmaTyhjaksi();
       assertEquals(1,peluri.getOhjelma().size());        
    }
    
    @Test
    public void shutdownOikein(){
        jaaKortit();
        peluri.setShutdown();
        assertEquals(false,peluri.getRobotti().isActive());
        assertEquals(new Kortti(KortinToiminto.NULL),peluri.ohjelma.getLast());
    }

    public void jaaKortit() {
        List<Kortti> testi=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            testi.add(new Kortti());
        }
        peluri.ohjelma.addAll(testi);
    }
    
    @Test
    public void poistaaKortitVahinkoaNelja(){
        jaaKortit();
        peluri.getRobotti().otaVahinkoa(4);
        assertEquals(true,peluri.poistaKortti());
        assertEquals(4,peluri.ohjelma.size());
        
    }
    
    @Test
    public void lisaaPoistetunKortinKateen(){
        jaaKortit();
        peluri.poistaKortti();
        int kasikortteja=0;
        for (Kortti kortti : peluri.kasikortit.keySet()) {
            kasikortteja=kasikortteja+peluri.kasikortit.get(kortti);
        }
        assertEquals(1,kasikortteja);
    }
    
    @Test
    public void eiPoistaKunVahinkoaViisi(){
        jaaKortit();
        peluri.getRobotti().otaVahinkoa(5);
        for (int i = 0; i < 4; i++) {
            peluri.poistaKortti();
        }
        assertEquals(false,peluri.poistaKortti());
    }

}
