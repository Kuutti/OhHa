/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import logiikka.robottiralli.korttienhallinta.KortinToiminto;
import logiikka.robottiralli.korttienhallinta.Kortti;
import logiikka.robottiralli.pelaajienhallinta.Pelaaja;


public class Ohjelmantekija implements ActionListener{
    
    JButton eteen1nappula;
    JButton eteen2nappula;
    JButton eteen3nappula;
    JButton oikealle;
    JButton vasemmalle;
    JButton ukaannos;
    JButton peruutus;
    JButton poista;
    JButton shutdown;
    JButton ok;
    JTextArea komentorivi;
    JTextArea kasi;

    
    JLabel virhekasky;
    HashMap<JButton,Kortti> komennot;
    Pelaaja pelaaja;
    Boolean jatkaa;
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        virhekasky.setText("");
        if (komennot.containsKey(ae.getSource())){
             Kortti kortti=komennot.get(ae.getSource());
            if (pelaaja.getOhjelma().size()==5) {
                virhekasky.setText("Et voi lisätä ohjelmaasi useampaa korttia!");
            } else  if (pelaaja.getKasi().get(kortti)>0) {
                pelaaja.getOhjelma().addLast(kortti);
                pelaaja.getKasi().put(kortti, pelaaja.getKasi().get(kortti)-1);
            } else {
                virhekasky.setText("Kyseistä korttia ei ole kädessäsi!");
            }
        } else if (ae.getSource()==poista){
            if (pelaaja.getOhjelma().size()>0) {
                if (!pelaaja.poistaKortti()) {
                    virhekasky.setText("Korttia ei voitu poistaa, koska se on lukkiutunut!");
                } 
            } else {
                virhekasky.setText("Ohjelmassasi ei ollut yhtään korttia!");
            }
        } else if (ae.getSource()==shutdown){
            pelaaja.setShutdown();
        } else if (ae.getSource()==ok){
            if (pelaaja.getOhjelma().size()==5) {
                komentorivi.setText("");
                pelaaja.kasiTyhjaksi();
                jatkaa=true;
            } else {
                virhekasky.setText("Ohjelmasi ei ole valmis. Ei voida jatkaa");
            }
        }
        paivitaKasi();
        paivitaOhjelma();
    }

    private void paivitaOhjelma() {
        komentorivi.setText("");
        for (int i = 0; i < pelaaja.getOhjelma().size(); i++) {
            komentorivi.setText(komentorivi.getText()+pelaaja.getOhjelma().get(i)+",  ");
            if (i==2) {
                komentorivi.setText(komentorivi.getText()+"\n");
            }
        }
    }
    
    public void paivitaKasi() {
        kasi.setText("");
        kasi.setText("YKSI ETEEN                 x"+pelaaja.getKasi().get(new Kortti(KortinToiminto.YKSIETEEN)));
        kasi.setText(kasi.getText()+"    KAKSI ETEEN                     x"+pelaaja.getKasi().get(new Kortti(KortinToiminto.KAKSIETEEN))+"\n");
        kasi.setText(kasi.getText()+"KOLME ETEEN            x"+pelaaja.getKasi().get(new Kortti(KortinToiminto.KOLMEETEEN)));
        kasi.setText(kasi.getText()+"    PERUUTUS                        x"+pelaaja.getKasi().get(new Kortti(KortinToiminto.PERUUTUS))+"\n");
        kasi.setText(kasi.getText()+"OIKEALLE KÄÄNNÖS x"+pelaaja.getKasi().get(new Kortti(KortinToiminto.KAANNOSOIKEALLE)));
        kasi.setText(kasi.getText()+"    VASEMMALLE KÄÄNNÖS x"+pelaaja.getKasi().get(new Kortti(KortinToiminto.KAANNOSVASEMMALLE))+"\n");
        kasi.setText(kasi.getText()+"U-KÄÄNNÖS                x"+pelaaja.getKasi().get(new Kortti(KortinToiminto.UKAANNOS)));
    }
    
    

    public Boolean isJatkaa() {
        return jatkaa;
    }

    public void setJatkaa(Boolean jatkaa) {
        this.jatkaa = jatkaa;
    }

    
    public Ohjelmantekija() {
        komennot=new HashMap<>();
    }
    
    public void HashMappiinNappulat(){
        komennot.put(eteen1nappula, new Kortti(KortinToiminto.YKSIETEEN));
        komennot.put(eteen2nappula, new Kortti(KortinToiminto.KAKSIETEEN));
        komennot.put(eteen3nappula, new Kortti(KortinToiminto.KOLMEETEEN));
        komennot.put(oikealle, new Kortti(KortinToiminto.KAANNOSOIKEALLE));
        komennot.put(vasemmalle, new Kortti(KortinToiminto.KAANNOSVASEMMALLE));
        komennot.put(ukaannos, new Kortti(KortinToiminto.UKAANNOS));
        komennot.put(peruutus, new Kortti(KortinToiminto.PERUUTUS));
    }

    public void setEteen1nappula(JButton eteen1nappula) {
        this.eteen1nappula = eteen1nappula;
    }

    public void setEteen2nappula(JButton eteen2nappula) {
        this.eteen2nappula = eteen2nappula;
    }

    public void setEteen3nappula(JButton eteen3nappula) {
        this.eteen3nappula = eteen3nappula;
    }

    public void setOikealle(JButton oikealle) {
        this.oikealle = oikealle;
    }

    public void setVasemmalle(JButton vasemmalle) {
        this.vasemmalle = vasemmalle;
    }

    public void setUkaannos(JButton ukaannos) {
        this.ukaannos = ukaannos;
    }

    public void setPeruutus(JButton peruutus) {
        this.peruutus = peruutus;
    }

    public void setPoista(JButton poista) {
        this.poista = poista;
    }

    public void setShutdown(JButton shutdown) {
        this.shutdown = shutdown;
    }

    public void setOk(JButton ok) {
        this.ok = ok;
    }

    public void setPelaaja(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
    }

    public void setKomentorivi(JTextArea komentorivi) {
        this.komentorivi = komentorivi;
    }

    public void setVirhekasky(JLabel virhekasky) {
        this.virhekasky = virhekasky;
    }

    public void setKasi(JTextArea kasi) {
        this.kasi = kasi;
    }

    
    
    
    
    
}
