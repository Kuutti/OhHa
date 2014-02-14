/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import logiikka.robottiralli.lautaelementtienhallinta.Lauta;
import logiikka.robottiralli.pelaajienhallinta.Ihmispelaaja;
import logiikka.robottiralli.pelaajienhallinta.Pelaaja;

/**
 *
 * @author guest-UJ7Q9p
 */
public class Lautaikkuna implements Runnable{
    
    private JFrame frame;
    private final Lauta lauta;
    GridBagConstraints gbc=new GridBagConstraints();
    JLabel pelaaja;
    JLabel vahinko;
    JLabel seuraava;  
    
    public Lautaikkuna(Lauta lauta) {
        this.lauta=lauta;
         
    }
    
    private void luoKomponentit(Container container) {
        container.setLayout(new FlowLayout());
        Lautapiirrin piirrin=new Lautapiirrin(lauta);
        piirrin.setPreferredSize(new Dimension(912,912)); 
        container.add(piirrin);
        JPanel nappulat=new JPanel();
        container.add(nappulat);
        teeNappulat(nappulat);
        
    }

     public void teeNappulat(JPanel nappulat) {
        gbc.insets=new Insets(5,5,5,5);
        
        nappulat.setLayout(new GridBagLayout());
        gbc.fill=GridBagConstraints.HORIZONTAL;
        
        
       Ohjelmantekija tekija=new Ohjelmantekija();
        
        JButton eteen1nappula=new JButton("1 Eteenpäin");
        gbc.gridx=0;
        gbc.gridy=1;
        
        nappulat.add(eteen1nappula,gbc);
      
        JButton eteen2nappula=new JButton("2 Eteenpäin");
        gbc.gridx=1;
        gbc.gridy=1;
        nappulat.add(eteen2nappula,gbc);
        
        JButton eteen3nappula=new JButton("3 Eteenpäin");
        gbc.gridx=2;
        gbc.gridy=1;
        nappulat.add(eteen3nappula,gbc);
        
        JButton oikealle=new JButton("Käännös oikealle");
        gbc.gridx=0;
        gbc.gridy=2;
        nappulat.add(oikealle,gbc);
        
        JButton vasemmalle=new JButton("Käännös vasemmalle");
        gbc.gridx=1;
        gbc.gridy=2;
        nappulat.add(vasemmalle,gbc);
        
        JButton ukaannos=new JButton("Tee U-käännös");
        gbc.gridx=2;
        gbc.gridy=2;
        nappulat.add(ukaannos,gbc);
        
        JButton peruutus=new JButton("Peruuta");
        gbc.gridx=0;
        gbc.gridy=3;
        nappulat.add(peruutus,gbc);
        
        JButton poista=new JButton("Poista ");
        gbc.gridx=2;
        gbc.gridy=3;
        nappulat.add(poista,gbc);
       
        JButton shutdown=new JButton("Shutdown");
        gbc.gridx=1;
        gbc.gridy=4;
        nappulat.add(shutdown,gbc);
        
        JButton ok=new JButton("Ohjelma valmis");
        gbc.gridx=0;
        gbc.gridy=5;
        gbc.gridwidth=3;
        nappulat.add(ok,gbc);
        
        pelaaja=new JLabel("");
        gbc.gridx=0;
        gbc.gridy=0;
        nappulat.add(pelaaja,gbc);
        
        vahinko=new JLabel("");
        gbc.gridx=1;
        gbc.gridy=0;
        nappulat.add(vahinko,gbc);
        
        seuraava=new JLabel("");
        gbc.gridx=2;
        gbc.gridy=0;
        nappulat.add(seuraava,gbc);
    }

    

    @Override
    public void run() {
        frame = new JFrame("Chao ex machina");
        frame.setPreferredSize(new Dimension(1500, 960));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public void ohjelmanTeko(Ihmispelaaja pelaaja){
       seuraava.setText("Seuraava piste on "+pelaaja.getRobotti().getSeuraavacp());
       this.pelaaja.setText("Pelaaja numero "+pelaaja.getMones());
       vahinko.setText("Vahinkoa otettu "+pelaaja.getRobotti().getVahinko());
    }
    
  
    
}