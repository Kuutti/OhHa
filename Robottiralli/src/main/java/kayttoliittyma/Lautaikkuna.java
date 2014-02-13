/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import logiikka.robottiralli.lautaelementtienhallinta.Lauta;

/**
 *
 * @author guest-UJ7Q9p
 */
public class Lautaikkuna implements Runnable{
    
    private JFrame frame;
    private final Lauta lauta;

    public Lautaikkuna(Lauta lauta) {
        this.lauta=lauta;
    }
    
    private void luoKomponentit(Container container) {
        Lautapiirrin piirrin=new Lautapiirrin(lauta);
        container.add(piirrin);
    }

    @Override
    public void run() {
        frame = new JFrame("Chao ex machina");
        frame.setPreferredSize(new Dimension(960, 960));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    
}
