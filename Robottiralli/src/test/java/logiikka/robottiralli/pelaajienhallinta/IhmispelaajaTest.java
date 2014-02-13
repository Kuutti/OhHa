/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logiikka.robottiralli.pelaajienhallinta;

import java.util.ArrayList;
import logiikka.robottiralli.korttienhallinta.Kortti;
import logiikka.robottiralli.robottienhallinta.Robotti;
import java.util.Arrays;
import java.util.List;
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
    Kortti kortti;
    
    @Before
    public void setUp() {
        robo=new Robotti(new Ruutu(2,2),2);
        peluri=new Ihmispelaaja(robo);
        kortti=new Kortti();
    }
    
    @Test
    public void KorttejaYksi(){
        peluri.otaKortti(kortti);
        assertEquals(1,peluri.kasikortit.size());
    }
    @Test
    public void OikeaRobotti(){
        assertEquals(robo,peluri.getRobotti());
    }
    @Test
    public void kasikorttejaOikeaMaara(){
        peluri.otaKortti(kortti);
        assertEquals(1, peluri.kasikortit.size());
    }
    @Test
    public void nullListanullia(){
        List<Kortti> test=peluri.nullLista();
        assertEquals(null,test.get(1));
    }
    @Test
    public void ohjelmavalmis(){
        List<Kortti> test=Arrays.asList(kortti,kortti,kortti,kortti,kortti);
        assertEquals(false,peluri.ohjelmaEiValmis((ArrayList<Kortti>) test));
    }
    @Test
    public void ohjelmaEiValmis(){
        List<Kortti> lista=peluri.nullLista();
        assertEquals(true,peluri.ohjelmaEiValmis((ArrayList<Kortti>) lista));
    }
    @Test
    public void nullListanKokoOikea(){
        List<Kortti> lista=peluri.nullLista();
        assertEquals(5,lista.size());
    }
}
