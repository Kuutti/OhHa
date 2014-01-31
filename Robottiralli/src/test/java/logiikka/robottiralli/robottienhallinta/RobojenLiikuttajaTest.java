/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logiikka.robottiralli.robottienhallinta;

import logiikka.robottiralli.lautaelementtienhallinta.Sijainti;
import logiikka.robottiralli.lautaelementtienhallinta.Lauta;
import logiikka.robottiralli.korttienhallinta.KortinToiminto;
import logiikka.robottiralli.korttienhallinta.Kortti;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import logiikka.robottiralli.pelaajienhallinta.Ihmispelaaja;
import logiikka.robottiralli.pelaajienhallinta.Pelaaja;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author KOTIPC
 */
public class RobojenLiikuttajaTest {
    
    RobojenLiikuttaja liikuttaja;
    Lauta lauta;
    Ihmispelaaja peluri;
    Robotti robo;
    Kortti peruutus;
    Kortti eteen1;
    Kortti eteen2;
    Kortti eteen3;
    Kortti vasemmalle;
    Kortti oikealle;
    Kortti ukaannos;
   
    @Before
    public void setUp() {
        robo=new Robotti(10,10,0);
        peluri=new Ihmispelaaja(robo);
        lauta=new Lauta(20,20);
        liikuttaja=new RobojenLiikuttaja(lauta);
        peruutus=new Kortti(KortinToiminto.PERUUTUS);
        eteen1=new Kortti(KortinToiminto.YKSIETEEN);
        eteen2=new Kortti(KortinToiminto.KAKSIETEEN);
        eteen3=new Kortti(KortinToiminto.KOLMEETEEN);
        vasemmalle=new Kortti(KortinToiminto.KAANNOSVASEMMALLE);
        oikealle=new Kortti(KortinToiminto.KAANNOSOIKEALLE);
        ukaannos=new Kortti(KortinToiminto.UKAANNOS);
    }
    
    @Test
    public void konstruktori(){
        assertEquals(lauta,liikuttaja.lauta);
    }
    
    @Test
    public void OhjelmanJalkeenRobo3Oikealleja3Ylhaalle(){
        List<Kortti> ohjelma=Arrays.asList(eteen2,oikealle,eteen3,vasemmalle,eteen1);
        HashMap<Pelaaja,List<Kortti>> test= new HashMap<>();
        test.put(peluri, ohjelma);
        liikuttaja.toteutaOhjelmat(test);
        assertEquals(new Sijainti(13,13),robo.getSijainti());
        assertEquals(new Suunta(0),robo.getSuunta());
    }
    
    @Test
    public void OhjelmanJalkeen4Alhaalla(){
        List<Kortti>ohjelma=Arrays.asList(peruutus,ukaannos,eteen1,eteen1,eteen1);
        OhjelmanToteutus(ohjelma);
        assertEquals(new Sijainti(10,6),robo.getSijainti());
        assertEquals(new Suunta(2),robo.getSuunta());
    }
    @Test 
    public void SeinaanTormays(){
        List<Kortti>ohjelma=Arrays.asList(eteen1,eteen1,eteen1,eteen1,eteen1);
        lauta.addSeina(robo.getSijainti(),new Sijainti(10,11));
        OhjelmanToteutus(ohjelma);
        assertEquals(new Sijainti(10,10),robo.getSijainti());
        assertEquals(new Suunta(0),robo.getSuunta());
    }

    
    @Test
    public void RobottiinTormays(){
        List<Kortti>ohjelma=Arrays.asList(eteen1,ukaannos,ukaannos,ukaannos,ukaannos);
        Robotti testirobo=new Robotti(10,11,1);
        lauta.AddRobo(testirobo);
        OhjelmanToteutus(ohjelma);
        assertEquals(new Sijainti(10,11),robo.getSijainti());
        assertEquals(new Suunta(0),robo.getSuunta());
        assertEquals(new Sijainti(10,12),testirobo.getSijainti());
        assertEquals(new Suunta(1),testirobo.getSuunta());
    }
    
    
    
    
    private void OhjelmanToteutus(List<Kortti> ohjelma) {
        HashMap<Pelaaja,List<Kortti>> test=new HashMap<>();
        test.put(peluri, ohjelma);
        liikuttaja.toteutaOhjelmat(test);
    }
}
