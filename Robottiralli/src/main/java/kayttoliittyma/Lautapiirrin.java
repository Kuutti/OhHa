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
    
    Lautapiirrin(Lauta lauta) {
        super.setBackground(Color.gray);
        this.lauta=lauta;
    }
    
    @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        int alku=0;
        for (int i = 0; i < 25; i++) {
            alku=i*(912/24);
            graphics.drawLine(alku, 0, alku, 912);
            graphics.drawLine(0, alku, 912, alku);
        }
        piirraAlku(graphics,1,1);
        piirraSeina(graphics,2,2,3,2);
        piirraSeina(graphics,2,2,2,3);
        piirraKaannin(graphics, 10,10);
        
    }

    private void piirraAlku(Graphics g, int x, int y) {
        g.setColor(Color.yellow);
        g.fillOval((x-1)*38, 912-y*38, 36, 36);
        g.setColor(Color.red);
        g.drawString("1", (x-1)*38+15, 912-y*38+21);
    }

    private void piirraSeina(Graphics g, int x, int y, int x1, int y1) {
        g.setColor(Color.black);
        g.fillRect((x-1)*38, 912-y*38, Math.abs(y-y1)*38+3, Math.abs(x-x1)*38+3);
    }

    private void piirraKaannin(Graphics g, int x, int y) {
        g.setColor(Color.red);
        g.drawArc((x-1)*38, 912-y*38+2, 36, 38, 0, 130);
    }
}
