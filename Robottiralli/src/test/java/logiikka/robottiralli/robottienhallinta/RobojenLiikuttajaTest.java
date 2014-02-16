/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logiikka.robottiralli.robottienhallinta;

import java.util.ArrayList;
import java.util.LinkedList;
import logiikka.robottiralli.lautaelementtienhallinta.Ruutu;
import logiikka.robottiralli.lautaelementtienhallinta.Lauta;
import logiikka.robottiralli.korttienhallinta.KortinToiminto;
import logiikka.robottiralli.korttienhallinta.Kortti;
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
        robo=new Robotti(new Ruutu(10,10),0);
        peluri=new Ihmispelaaja(robo,1);
        lauta=new Lauta(30);
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
    public void VainEteen1(){
         LinkedList<Kortti> ohjelma= new  LinkedList<>();
        for (int i = 0; i < 5; i++) {
            ohjelma.add(eteen1);
        }
        OhjelmanToteutus(ohjelma);
        assertEquals(new Ruutu(10,15),robo.getRuutu());
        assertEquals(0,robo.getSuunta());
    }
    
    @Test
    public void VainEteen2(){
         LinkedList<Kortti> ohjelma= new  LinkedList<>();
        for (int i = 0; i < 5; i++) {
            ohjelma.add(eteen2);
        }
        OhjelmanToteutus(ohjelma);
        assertEquals(new Ruutu(10,20),robo.getRuutu());
        assertEquals(0,robo.getSuunta());
    }
    
    @Test
    public void VainEteen3(){
         LinkedList<Kortti> ohjelma= new  LinkedList<>();
        for (int i = 0; i < 5; i++) {
            ohjelma.add(eteen3);
        }
        OhjelmanToteutus(ohjelma);
        assertEquals(new Ruutu(10,25),robo.getRuutu());
        assertEquals(0,robo.getSuunta());
    }
    
    @Test
    public void VainPeruutus(){
         LinkedList<Kortti> ohjelma= new  LinkedList<>();
        for (int i = 0; i < 5; i++) {
            ohjelma.add(peruutus);
        }
        OhjelmanToteutus(ohjelma);
        assertEquals(new Ruutu(10,5),robo.getRuutu());
        assertEquals(0,robo.getSuunta());
    }
    
    @Test
    public void VainOikealle(){
         LinkedList<Kortti> ohjelma= new  LinkedList<>();
        for (int i = 0; i < 5; i++) {
            ohjelma.add(oikealle);
        }
        OhjelmanToteutus(ohjelma);
        assertEquals(new Ruutu(10,10),robo.getRuutu());
        assertEquals(1,robo.getSuunta());
    }
    
    @Test
    public void VainVasemalle(){
         LinkedList<Kortti> ohjelma= new  LinkedList<>();
        for (int i = 0; i < 5; i++) {
            ohjelma.add(vasemmalle);
        }
        OhjelmanToteutus(ohjelma);
        assertEquals(new Ruutu(10,10),robo.getRuutu());
        assertEquals(3,robo.getSuunta());
    }
    
    @Test
    public void VainUkaannos(){
        LinkedList<Kortti> ohjelma= new  LinkedList<>();
        for (int i = 0; i < 5; i++) {
            ohjelma.add(ukaannos);
        }
        OhjelmanToteutus(ohjelma);
        assertEquals(new Ruutu(10,10),robo.getRuutu());
        assertEquals(2,robo.getSuunta());
    }

    
//    @Test 
//    public void SeinaanTormays(){
//        ArrayList<Kortti>ohjelma=new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            ohjelma.add(eteen1);
//        }
//        lauta.addSeina(robo.getSijainti(),new Ruutu(10,11));
//        OhjelmanToteutus(ohjelma);
//        assertEquals(new Ruutu(10,10),robo.getSijainti());
//        assertEquals(new Suunta(0),robo.getSuunta());
//    }
//
//    
//    @Test
//    public void RobottiinTormays(){  //badcode doing lists
//        ArrayList<Kortti>ohjelma=new ArrayList<>();
//        ohjelma.add(eteen1);
//        ohjelma.add(ukaannos);
//        ohjelma.add(ukaannos);
//        ohjelma.add(ukaannos);
//        ohjelma.add(ukaannos);
//        Robotti testirobo=new Robotti(10,11,1);
//        lauta.AddRobo(testirobo);
//        OhjelmanToteutus(ohjelma);
//        assertEquals(new Ruutu(10,11),robo.getSijainti());
//        assertEquals(new Suunta(0),robo.getSuunta());
//        assertEquals(new Ruutu(10,12),testirobo.getSijainti());
//        assertEquals(new Suunta(1),testirobo.getSuunta());
//    }
    
    
    
    
    private void OhjelmanToteutus(LinkedList<Kortti> ohjelma) {
        peluri.setOhjelma( (LinkedList<Kortti>) ohjelma);
        ArrayList<Pelaaja> lista=new ArrayList<>();
        lista.add(peluri);
        liikuttaja.suoritaOhjelmat(lista);
    }
}
