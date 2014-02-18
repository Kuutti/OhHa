/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kayttoliittyma;

import java.awt.Color;
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
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import kayttoliittyma.Ohjelmantekija;
import logiikka.robottiralli.pelaajienhallinta.Ihmispelaaja;

/**
 *
 * @author guest-UJ7Q9p
 */
public class Lautaikkuna implements Runnable{
    
    private JFrame frame;
    Lautapiirrin piirrin;
    GridBagConstraints gbc=new GridBagConstraints();
    JLabel pelaaja;
    JLabel vahinko;
    JLabel seuraava;
    Ohjelmantekija tekija;
    boolean saaJatkaa=false;
    
    
    public Lautaikkuna(Lautapiirrin piirrin) {
        this.piirrin=piirrin;
         
    }
    
    private void luoKomponentit(Container container) {
        container.setLayout(new FlowLayout());
        piirrin.setPreferredSize(new Dimension(912,912)); 
        container.add(piirrin);
        JPanel nappulat=new JPanel();
        container.add(nappulat);
        teeInteraktiviiset(nappulat);
        saaJatkaa=true;
        
    }

     public void teeInteraktiviiset(JPanel nappulat) {
        gbc.insets=new Insets(5,5,5,5);
        
        nappulat.setLayout(new GridBagLayout());
        gbc.fill=GridBagConstraints.HORIZONTAL;
        
        tekija=new Ohjelmantekija();
        
        JButton eteen1nappula=new JButton("1 Eteenpäin");
        gbc.gridx=0;
        gbc.gridy=1;
        eteen1nappula.addActionListener(tekija);
        tekija.setEteen1nappula(eteen1nappula);
        nappulat.add(eteen1nappula,gbc);
      
        JButton eteen2nappula=new JButton("2 Eteenpäin");
        gbc.gridx=1;
        gbc.gridy=1;
        eteen2nappula.addActionListener(tekija);
        tekija.setEteen2nappula(eteen2nappula);
        nappulat.add(eteen2nappula,gbc);
        
        JButton eteen3nappula=new JButton("3 Eteenpäin");
        gbc.gridx=2;
        gbc.gridy=1;
        eteen3nappula.addActionListener(tekija);
        tekija.setEteen3nappula(eteen3nappula);
        nappulat.add(eteen3nappula,gbc);
        
        JButton oikealle=new JButton("Käännös oikealle");
        gbc.gridx=0;
        gbc.gridy=2;
        oikealle.addActionListener(tekija);
        tekija.setOikealle(oikealle);
        nappulat.add(oikealle,gbc);
        
        JButton vasemmalle=new JButton("Käännös vasemmalle");
        gbc.gridx=1;
        gbc.gridy=2;
        vasemmalle.addActionListener(tekija);
        tekija.setVasemmalle(vasemmalle);
        nappulat.add(vasemmalle,gbc);
        
        JButton ukaannos=new JButton("Tee U-käännös");
        gbc.gridx=2;
        gbc.gridy=2;
        ukaannos.addActionListener(tekija);
        tekija.setUkaannos(ukaannos);
        nappulat.add(ukaannos,gbc);
        
        JButton peruutus=new JButton("Peruuta");
        gbc.gridx=0;
        gbc.gridy=3;
        peruutus.addActionListener(tekija);
        tekija.setPeruutus(peruutus);
        nappulat.add(peruutus,gbc);
        
        JButton poista=new JButton("Poista ");
        gbc.gridx=2;
        gbc.gridy=3;
        poista.addActionListener(tekija);
        tekija.setPoista(poista);
        nappulat.add(poista,gbc);
       
        JButton shutdown=new JButton("Shutdown");
        gbc.gridx=1;
        gbc.gridy=4;
        shutdown.addActionListener(tekija);
        tekija.setShutdown(shutdown);
        nappulat.add(shutdown,gbc);
        
        JButton ok=new JButton("Ohjelma valmis");
        gbc.gridx=0;
        gbc.gridy=5;
        gbc.gridwidth=3;
        ok.addActionListener(tekija);
        tekija.setOk(ok);
        nappulat.add(ok,gbc);
        
        pelaaja=new JLabel("??");
        gbc.gridx=0;
        gbc.gridy=0;
        nappulat.add(pelaaja,gbc);
        
        vahinko=new JLabel("??");
        gbc.gridx=1;
        gbc.gridy=0;
        nappulat.add(vahinko,gbc);
        
        seuraava=new JLabel("??");
        gbc.gridx=2;
        gbc.gridy=0;
        nappulat.add(seuraava,gbc);
        
        JTextArea komentorivi=new JTextArea();
        komentorivi.setEditable(false);
        gbc.gridx=0;
        gbc.gridy=6;
        gbc.gridwidth=3;
        tekija.setKomentorivi(komentorivi);
        nappulat.add(komentorivi,gbc);
        
        JLabel virhekasky=new JLabel("??");
        gbc.gridx=0;
        gbc.gridy=7;
        gbc.gridwidth=3;
        virhekasky.setForeground(Color.RED);
        tekija.setVirhekasky(virhekasky);
        nappulat.add(virhekasky,gbc);
        
        JTextArea kasi=new JTextArea();
        kasi.setEditable(false);
        gbc.gridx=0;
        gbc.gridy=8;
        gbc.gridwidth=3;
        tekija.setKasi(kasi);
        nappulat.add(kasi, gbc);
        
        tekija.HashMappiinNappulat();
    
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
       tekija.setPelaaja(pelaaja);
       tekija.setJatkaa(false);
       seuraava.setText("Seuraava piste on "+pelaaja.getRobotti().getSeuraavacpnumero());
       this.pelaaja.setText("Pelaaja numero "+pelaaja.getMones());
       vahinko.setText("Vahinkoa otettu "+pelaaja.getRobotti().getVahinko());
       while(!tekija.isJatkaa());
    }

    public boolean isSaaJatkaa() {
        return saaJatkaa;
    }
    
  
    
}