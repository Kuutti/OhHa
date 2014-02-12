/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import logiikka.robottiralli.lautaelementtienhallinta.Lauta;

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
        piirraAlku(graphics,1,1);
        piirraSeina(graphics,2,2,3,2);
        piirraSeina(graphics,2,2,2,3);
        piirraKaannin(graphics, 10,10, 2);
        piirraKorjaaja(graphics, 13,14,2);
        
    }

    private void piirraAlku(Graphics g, int x, int y) {
        g.setColor(Color.yellow);
        g.fillOval((x-1)*ruudunkoko, koko-y*ruudunkoko, 36, 36);
        g.setColor(Color.red);
        g.drawString("1", (x-1)*ruudunkoko+15, koko-y*ruudunkoko+21);
    }

    private void piirraSeina(Graphics g, int x, int y, int x1, int y1) {
        g.setColor(Color.black);
        g.fillRect((x-1)*ruudunkoko, koko-y*ruudunkoko, Math.abs(y-y1)*ruudunkoko+3, Math.abs(x-x1)*ruudunkoko+3);
    }

    private void piirraKaannin(Graphics g, int x, int y, int kiertosuunta) {
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
            
        }
    }
    
    
}
