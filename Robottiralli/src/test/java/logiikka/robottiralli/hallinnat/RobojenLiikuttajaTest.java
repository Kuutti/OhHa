/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logiikka.robottiralli.hallinnat;

import logiikka.robottiralli.korttienhallinta.KortinToiminto;
import logiikka.robottiralli.korttienhallinta.Kortti;
import logiikka.robottiralli.lautaelementit.Kuoppa;
import logiikka.robottiralli.lautaelementtienhallinta.Lauta;
import logiikka.robottiralli.lautaelementtienhallinta.Ruutu;
import logiikka.robottiralli.robottienhallinta.Robotti;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author KOTIPC
 */
public class RobojenLiikuttajaTest {
    
    Lauta lauta;
    RobojenLiikuttaja liikuttaja;
    Robotti robo;
    
    @Before
    public void setUp() {
        lauta=new Lauta(10);
        liikuttaja=new RobojenLiikuttaja(lauta);
        robo=new Robotti(lauta.getPelilauta()[5][5],0);
        robo.setRespawn(lauta.getPelilauta()[2][2]);
        robo.setHolo(false);
    }
    
    @Test
    public void roboLiikkuu() {
        liikuttaja.liiku(lauta.getPelilauta()[6][5], robo);
        assertEquals(new Ruutu(6,5),robo.getRuutu());
    }
    
    @Test
    public void tuhoutuuJosLiikkuuNull(){
        liikuttaja.liiku(null, robo);
        assertEquals(2,robo.getVahinko());
    }
    
    @Test
    public void tuhoutuuJosKuoppaan(){
        lauta.getPelilauta()[6][5].lisaaElementti(new Kuoppa());
        liikuttaja.liiku(lauta.getPelilauta()[6][5], robo);
        assertEquals(2,robo.getVahinko());
    }
    
    @Test
    public void tuhoutuuJosEiLaudalla(){
        robo.setRuutu(lauta.getPelilauta()[1][1]);
        liikuttaja.liiku(lauta.getPelilauta()[0][1], robo);
        System.out.println(lauta.onLaudalla(robo.getRuutu()));
        assertEquals(2,robo.getVahinko());
    }
    
    @Test
    public void kaantaaOikealle(){
        liikuttaja.suoritaKomento(new Kortti(KortinToiminto.KAANNOSOIKEALLE), robo);
        assertEquals(1,robo.getSuunta());
    }
    
    @Test
    public void kaantaaVasemmalle(){
        liikuttaja.suoritaKomento(new Kortti(KortinToiminto.KAANNOSVASEMMALLE), robo);
        assertEquals(3,robo.getSuunta());
    }
    
    @Test
    public void tekeeUKaannos(){
        liikuttaja.suoritaKomento(new Kortti(KortinToiminto.UKAANNOS), robo);
        assertEquals(2,robo.getSuunta());
    }
    
    @Test
    public void liikkuuYksi(){
        liikuttaja.suoritaKomento(new Kortti(KortinToiminto.YKSIETEEN), robo);
        assertEquals(new Ruutu(5,6),robo.getRuutu());
    }
    
    @Test
    public void liikkuuKaksi(){
        liikuttaja.suoritaKomento(new Kortti(KortinToiminto.KAKSIETEEN),robo);
        assertEquals(new Ruutu(5,7),robo.getRuutu());
    }
    
    @Test
    public void liikkuuKolme(){
        liikuttaja.suoritaKomento(new Kortti(KortinToiminto.KOLMEETEEN), robo);
        assertEquals(new Ruutu(5,8),robo.getRuutu());
    }
    
    @Test
    public void peruuttaa(){
        liikuttaja.suoritaKomento(new Kortti(KortinToiminto.PERUUTUS), robo);
        assertEquals(new Ruutu(5,4),robo.getRuutu());
    }
    
    @Test
    public void tormaaSeinaan(){
        lauta.addSeina(lauta.getPelilauta()[5][5], lauta.getPelilauta()[5][6]);
        liikuttaja.suoritaKomento(new Kortti(KortinToiminto.KOLMEETEEN), robo);
        assertEquals(new Ruutu(5,5),robo.getRuutu());
    }
    
    @Test
    public void tormaaRobottiin(){
        Robotti tiella=new Robotti(lauta.getPelilauta()[5][6],1);
        tiella.setHolo(false);
        liikuttaja.suoritaKomento(new Kortti(KortinToiminto.YKSIETEEN), robo);
        assertEquals(new Ruutu(5,6),robo.getRuutu());
        assertEquals(new Ruutu(5,7),tiella.getRuutu());
        assertEquals(1,tiella.getSuunta());
    }
    
    @Test
    public void tormaaRobottiinJonkaTakanaSeina(){
        Robotti tiella=new Robotti(lauta.getPelilauta()[5][6],1);
        tiella.setHolo(false);
        lauta.addSeina(lauta.getPelilauta()[5][7], lauta.getPelilauta()[5][6]);
        liikuttaja.suoritaKomento(new Kortti(KortinToiminto.KOLMEETEEN), robo);
        System.out.println(lauta.getPelilauta()[5][5].getRobotti());
        System.out.println(tiella);
        System.out.println(robo);
        //assertEquals(new Ruutu(5,5),robo.getRuutu());
        assertEquals(new Ruutu(5,6),tiella.getRuutu());
        assertEquals(1,tiella.getSuunta());
        assertEquals(0,robo.getSuunta());
    }
}

