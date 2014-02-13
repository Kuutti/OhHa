/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JPanel;
import logiikka.robottiralli.lautaelementtienhallinta.Laser;
import logiikka.robottiralli.lautaelementtienhallinta.Lauta;
import logiikka.robottiralli.lautaelementtienhallinta.Ruudunvieva;
import logiikka.robottiralli.lautaelementtienhallinta.Ruutu;

/**
 *
 * @author guest-UJ7Q9p
 */
public class Lautapiirrin extends JPanel{
    
    Lauta lauta;
    int koko=912;
    int ruudunkoko=38;
    
    Lautapiirrin(Lauta lauta) {
        super.setBackground(Color.gray);
        this.lauta=lauta;
    }
    
    @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        int alku=0;
        for (int i = 0; i < 25; i++) {
            alku=i*(koko/24);
            graphics.drawLine(alku, 0, alku, koko);
            graphics.drawLine(0, alku, koko, alku);
        }
        for (Ruutu[] ruutu1 :lauta.getPelilauta()) {
            for (Ruutu ruutu : ruutu1) {
                Ruudunvieva elementti=ruutu.getRuudussa();
                    if (elementti==null) {
                }
                   else if ("liukuhihna".equals(elementti.tyyppi())){
                        piirraLiukuhihna(graphics,ruutu.getX(),ruutu.getY(),elementti.getErikoisint());
                    } else if ("kuoppa".equals(elementti.tyyppi())) {
                        piirraKuoppa(graphics,ruutu.getX(),ruutu.getY());
                    } else if ("checkpoint".equals(elementti.tyyppi())){
                        piirraCheckpoint(graphics,ruutu.getX(),ruutu.getY(),elementti.getErikoisint());
                    } else if ("korjaaja".equals((elementti.tyyppi()))){
                        piirraKorjaaja(graphics,ruutu.getX(),ruutu.getY(),elementti.getErikoisint());
                    } else if ("kaantaja".equals(elementti.tyyppi())){
                        piirraKaantaja(graphics,ruutu.getX(),ruutu.getY(),elementti.getErikoisint());
                    } else if ("murskain".equals(elementti.tyyppi())){
                        piirraMurskain(graphics,ruutu.getX(),ruutu.getY(),elementti.getErikoisint());
                    } else if ("tyonnin".equals(elementti.tyyppi())){
                        piirraTyonnin(graphics,ruutu.getX(),ruutu.getY(),elementti.getErikoisint());
                    }
                        
                
            } 
        }
        for (HashSet<Ruutu> seina : lauta.getSeinat()) {
             Ruutu[] ruudut=seina.toArray(new Ruutu[0]);
             piirraSeina(graphics,ruudut[0].getX(),ruudut[0].getY(),ruudut[1].getX(),ruudut[1].getY());
             
                
            }
            for (Laser laser : lauta.getLaserit()) {
                piirraLaser(graphics,laser.getRuutu().getX(),laser.getRuutu().getY(),laser.getSuunta());
            }
    }

    private void piirraCheckpoint(Graphics g, int x, int y, int mones) {
        g.setColor(Color.yellow);
        g.fillOval((x-1)*ruudunkoko, koko-y*ruudunkoko, 36, 36);
        g.setColor(Color.red);
        
        g.drawString(""+mones, (x-1)*ruudunkoko+15, koko-y*ruudunkoko+21);
    }

    private void piirraSeina(Graphics g, int x, int y, int x1, int y1) {
        g.setColor(Color.black);
        g.fillRect((x-(x-x1+1)/2)*ruudunkoko, koko-(y-(y-y1+1)/2)*(ruudunkoko), -Math.abs(y-y1)*ruudunkoko+3, Math.abs(x-x1)*ruudunkoko+3);
    }

    private void piirraKaantaja(Graphics g, int x, int y, int kiertosuunta) {
        g.setColor(Color.cyan);
        g.drawArc((x-1)*ruudunkoko, koko-y*ruudunkoko+2, 32, ruudunkoko, 0, 130);
        g.drawArc((x-1)*ruudunkoko+6, koko-y*ruudunkoko-3, 31, ruudunkoko, 180, 130);
        if (kiertosuunta==1){
            int [] xeka ={(x-1)*ruudunkoko+1,(x-1)*ruudunkoko+17,(x-1)*ruudunkoko+6};
            int [] yeka= {koko-y*ruudunkoko+17,koko-y*ruudunkoko+19,koko-y*ruudunkoko+10};
            g.fillPolygon(xeka, yeka, 3);
            int [] xtoka={(x-1)*ruudunkoko+35,(x-1)*ruudunkoko+27,(x-1)*ruudunkoko+31};
            int [] ytoka={koko-y*ruudunkoko+22,koko-y*ruudunkoko+22,koko-y*ruudunkoko+28};
            g.fillPolygon(xtoka, ytoka, 3);}
        else {
            int [] xeka ={(x-1)*ruudunkoko+4,(x-1)*ruudunkoko+17,(x-1)*ruudunkoko+6};
            int [] yeka= {koko-y*ruudunkoko+7,koko-y*ruudunkoko+9,koko-y*ruudunkoko};
            g.fillPolygon(xeka, yeka, 3);
            int [] xtoka={(x-1)*ruudunkoko+35,(x-1)*ruudunkoko+27,(x-1)*ruudunkoko+32};
            int [] ytoka={koko-y*ruudunkoko+34,koko-y*ruudunkoko+27,koko-y*ruudunkoko+24};
            g.fillPolygon(xtoka, ytoka, 3);}
    }

    private void piirraKorjaaja(Graphics g, int x, int y, int teho) {
        g.setColor(Color.BLACK);
        g.drawLine((x-1)*ruudunkoko+10, koko-y*ruudunkoko+10, (x-1)*ruudunkoko+31, koko-y*ruudunkoko+31);
        g.drawLine((x-1)*ruudunkoko+10, koko-y*ruudunkoko+10, (x-1)*ruudunkoko+5, koko-y*ruudunkoko+10);
        g.drawLine((x-1)*ruudunkoko+10, koko-y*ruudunkoko+10, (x-1)*ruudunkoko+10, koko-y*ruudunkoko+5);
        g.drawLine((x-1)*ruudunkoko+5, koko-y*ruudunkoko+10, (x-1)*ruudunkoko+5, (koko-y*ruudunkoko+8));
        g.drawLine((x-1)*ruudunkoko+10, koko-y*ruudunkoko+5, (x-1)*ruudunkoko+8, koko-y*ruudunkoko+5);
        if (teho==2) {
            g.drawLine((x-1)*ruudunkoko+7, koko-y*ruudunkoko+31, (x-1)*ruudunkoko+28, koko-y*ruudunkoko+10);
            g.drawLine((x-1)*ruudunkoko+28, koko-y*ruudunkoko+10, (x-1)*ruudunkoko+32, koko-y*ruudunkoko+10);
            g.drawLine((x-1)*ruudunkoko+28, koko-y*ruudunkoko+10, (x-1)*ruudunkoko+28, koko-y*ruudunkoko+5);
            g.drawLine((x-1)*ruudunkoko+32, koko-y*ruudunkoko+10, (x-1)*ruudunkoko+32, koko-y*ruudunkoko+8);
            g.drawLine((x-1)*ruudunkoko+28, koko-y*ruudunkoko+5, (x-1)*ruudunkoko+30, koko-y*ruudunkoko+5);
        }
    }

    private void piirraKuoppa(Graphics g, int x, int y) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect((x-1)*ruudunkoko, koko-y*ruudunkoko, ruudunkoko, ruudunkoko);
    }

    private void piirraLiukuhihna(Graphics g, int x, int y, int suunta) {
        g.setColor(Color.black);
        if (suunta%2==0) {
            g.drawLine((x-1)*ruudunkoko+19, koko-y*ruudunkoko+7, (x-1)*ruudunkoko+19, koko-y*ruudunkoko+29);
            if (suunta==0) {
                g.drawLine((x-1)*ruudunkoko+19, koko-y*ruudunkoko+7, (x-1)*ruudunkoko+13, koko-y*ruudunkoko+12);
                g.drawLine((x-1)*ruudunkoko+19, koko-y*ruudunkoko+7,(x-1)*ruudunkoko+23, koko-y*ruudunkoko+12);
            } else {
                g.drawLine((x-1)*ruudunkoko+19, koko-y*ruudunkoko+29,(x-1)*ruudunkoko+13, koko-y*ruudunkoko+24);
                g.drawLine((x-1)*ruudunkoko+19, koko-y*ruudunkoko+29,(x-1)*ruudunkoko+23, koko-y*ruudunkoko+24);
            }
        }
        else {
            g.drawLine((x-1)*ruudunkoko+7, koko-y*ruudunkoko+19, (x-1)*ruudunkoko+29, koko-y*ruudunkoko+19);
            if (suunta==1) {
                g.drawLine((x-1)*ruudunkoko+29, koko-y*ruudunkoko+19, (x-1)*ruudunkoko+22, koko-y*ruudunkoko+24);
                g.drawLine((x-1)*ruudunkoko+29, koko-y*ruudunkoko+19,(x-1)*ruudunkoko+22,koko-y*ruudunkoko+14);
            } else {
                g.drawLine((x-1)*ruudunkoko+7, koko-y*ruudunkoko+19, (x-1)*ruudunkoko+13, koko-y*ruudunkoko+14);
                g.drawLine((x-1)*ruudunkoko+7, koko-y*ruudunkoko+19, (x-1)*ruudunkoko+13, koko-y*ruudunkoko+24);
            }
        }
    }

    private void piirraMurskain(Graphics g, int x , int y, int kumpi) {
        String string="";
        if (kumpi%2==0) {
            string="2 4";
        } else {
            string="1 3 5";
        }
        g.setColor(Color.black);
        g.fillOval((x-1)*ruudunkoko, koko-y*ruudunkoko, 36, 25);
        g.setColor(Color.red);
        g.fillOval((x-1)*ruudunkoko+4, koko-y*ruudunkoko+4, 27, 17);
        g.setColor(Color.black);
        g.fillOval((x-1)*ruudunkoko+6, koko-y*ruudunkoko+6, 22, 13);
        g.drawString(string, (x-1)*ruudunkoko+5, koko-y*ruudunkoko+35);
    }

    private void piirraTyonnin(Graphics g, int x, int y, int data) {
        int seina=data%4;
        List<Integer>lukuja=new ArrayList<>();
        if (data<4) {
            lukuja.add(2);
            lukuja.add(4);
        } else {
            lukuja.add(1);
            lukuja.add(3);
            lukuja.add(5);
        }
        g.setColor(Color.black);
        if (seina==3) {
            g.fillRect((x)*ruudunkoko-7, koko-y*ruudunkoko+2, 5, 35);
            g.drawLine((x)*ruudunkoko-7, koko-y*ruudunkoko+9, (x)*ruudunkoko, koko-y*ruudunkoko+9);
            g.drawLine((x)*ruudunkoko-7, koko-y*ruudunkoko+30, (x)*ruudunkoko, koko-y*ruudunkoko+30);
            int i=1;
            for (Integer integer : lukuja) {
                g.drawString(integer.toString(), (x-1)*ruudunkoko+4, koko-y*ruudunkoko+11*i);
                i=i+1;
            }
            g.setColor(Color.yellow);
            g.fillRect((x)*ruudunkoko-7, koko-y*ruudunkoko+9, 5, 7);
            g.fillRect((x)*ruudunkoko-7, koko-y*ruudunkoko+23, 5, 7);
        } else if (seina==1){
            g.fillRect((x-1)*ruudunkoko+5, koko-y*ruudunkoko+2, 5, 35);
            g.drawLine((x-1)*ruudunkoko+5, koko-y*ruudunkoko+9, (x-1)*ruudunkoko, koko-y*ruudunkoko+9);
            g.drawLine((x-1)*ruudunkoko+7, koko-y*ruudunkoko+30, (x-1)*ruudunkoko, koko-y*ruudunkoko+30);
            int i=1;
            for (Integer integer : lukuja) {
                g.drawString(integer.toString(), x*ruudunkoko-10, koko-y*ruudunkoko+11*i);
                i++;
            }
            g.setColor(Color.yellow);
            g.fillRect((x-1)*ruudunkoko+5, koko-y*ruudunkoko+9, 5, 7);
            g.fillRect((x-1)*ruudunkoko+5, koko-y*ruudunkoko+23, 5, 7);
        } else if (seina==2){
            g.fillRect((x-1)*ruudunkoko+2, koko-y*ruudunkoko+7, 35, 5);
            g.drawLine((x-1)*ruudunkoko+9, koko-y*ruudunkoko+7,(x-1)*ruudunkoko+9, koko-y*ruudunkoko);
            g.drawLine((x-1)*ruudunkoko+30, koko-y*ruudunkoko+7,(x-1)*ruudunkoko+30, koko-y*ruudunkoko);
            String luvut="";
            for (Integer integer : lukuja) {
                luvut=luvut+integer+" ";
            }
            g.drawString(luvut, (x-1)*ruudunkoko+2, koko-y*ruudunkoko+30);
            g.setColor(Color.yellow);
            g.fillRect((x-1)*ruudunkoko+9, koko-y*ruudunkoko+7, 7, 5);
            g.fillRect((x-1)*ruudunkoko+23, koko-y*ruudunkoko+7, 7, 5);
        } else {
            g.fillRect((x-1)*ruudunkoko+2, koko-y*ruudunkoko+30, 35, 5);
            g.drawLine((x-1)*ruudunkoko+9, koko-y*ruudunkoko+30,(x-1)*ruudunkoko+9, koko-y*ruudunkoko+40);
            g.drawLine((x-1)*ruudunkoko+30, koko-y*ruudunkoko+30,(x-1)*ruudunkoko+30, koko-y*ruudunkoko+40);
            String luvut="";
            for (Integer integer : lukuja) {
                luvut=luvut+integer+" ";
            }
            g.drawString(luvut, (x-1)*ruudunkoko+2, koko-y*ruudunkoko+12);
            g.setColor(Color.yellow);
            g.fillRect((x-1)*ruudunkoko+9, koko-y*ruudunkoko+30, 7, 5);
            g.fillRect((x-1)*ruudunkoko+23, koko-y*ruudunkoko+30, 7, 5);
        }
    }

    private void piirraLaser(Graphics g, int x, int y, int suunta) {
        g.setColor(Color.black);
        int pituus=etsiPituus(x,y,suunta,1);  
        if (suunta==2) {
            int [] xeka={(x-1)*ruudunkoko+15,(x-1)*ruudunkoko+23,(x-1)*ruudunkoko+21,(x-1)*ruudunkoko+17};
            int [] yeka={koko-y*ruudunkoko,koko-y*ruudunkoko,koko-y*ruudunkoko+6,koko-y*ruudunkoko+6};
            g.fillPolygon(xeka, yeka, 4);
            g.setColor(Color.red);
            g.drawLine((x-1)*ruudunkoko+19, koko-y*ruudunkoko+6, (x-1)*ruudunkoko+19, koko-y*ruudunkoko+ruudunkoko*(pituus-2));
        } else if (suunta==0){
            int [] xeka={(x-1)*ruudunkoko+15,(x-1)*ruudunkoko+23,(x-1)*ruudunkoko+21,(x-1)*ruudunkoko+17};
            int [] yeka={koko-(y-1)*ruudunkoko,koko-(y-1)*ruudunkoko,koko-(y-1)*ruudunkoko-4,koko-(y-1)*ruudunkoko-4};
            g.fillPolygon(xeka, yeka, 4);
            g.setColor(Color.red);
            System.out.println(pituus);
            g.drawLine((x-1)*ruudunkoko+19, koko-(y-1)*ruudunkoko-4, (x-1)*ruudunkoko+19, koko-(y-1)*ruudunkoko-ruudunkoko*(pituus)+3);  
        } else if (suunta==1){
            int [] xeka={(x-1)*ruudunkoko,(x-1)*ruudunkoko,(x-1)*ruudunkoko+6,(x-1)*ruudunkoko+6};
            int [] yeka={koko-y*ruudunkoko+15,koko-y*ruudunkoko+23,koko-y*ruudunkoko+21,koko-y*ruudunkoko+17};
            g.fillPolygon(xeka, yeka, 4);
            g.setColor(Color.red);
            g.drawLine((x-1)*ruudunkoko+6,koko-y*ruudunkoko+19, (x-1)*ruudunkoko+(pituus)*ruudunkoko, koko-y*ruudunkoko+19);
        } else {
            int [] xeka={(x-1)*ruudunkoko+38,(x-1)*ruudunkoko+38,(x-1)*ruudunkoko+32,(x-1)*ruudunkoko+32};
            int [] yeka={koko-y*ruudunkoko+15,koko-y*ruudunkoko+23,koko-y*ruudunkoko+21,koko-y*ruudunkoko+17};
            g.fillPolygon(xeka, yeka, 4);
            g.setColor(Color.red);
            g.drawLine((x-1)*ruudunkoko+32,koko-y*ruudunkoko+19, (x-1)*ruudunkoko-(pituus)*ruudunkoko, koko-y*ruudunkoko+19);
           
        }
        
    }

    private int etsiPituus(int x, int y, int suunta, int pituus) {
        Ruutu nyky=new Ruutu(x,y);
        while (true){
            Ruutu seuraava=lauta.seuraavaRuutu(nyky, suunta);
            if (seuraava==null) {
                return pituus+1;
            } 
            Set<Ruutu> seina=new HashSet<>();
            seina.add(seuraava);
            seina.add(nyky);
            if (lauta.getSeinat().contains(seina)) {
                break;
            }
            nyky=seuraava;
            pituus++;
        }
        return pituus;
    }
    
    
}
