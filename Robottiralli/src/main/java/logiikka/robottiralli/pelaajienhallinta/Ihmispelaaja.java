package logiikka.robottiralli.pelaajienhallinta;

import logiikka.robottiralli.robottienhallinta.Robotti;
import logiikka.robottiralli.korttienhallinta.Kortti;
import java.util.HashMap;
import java.util.LinkedList;
import logiikka.robottiralli.korttienhallinta.KortinToiminto;






public class Ihmispelaaja implements Pelaaja{

    /**
     * Pelaajalla oleva robotti
     */
   Robotti robotti;
   /**
    * Pelaajan hallussa olevat kortit, joista tehdään ohjelma
    */
   HashMap<Kortti,Integer> kasikortit=new HashMap<>();
   /**
    * Pelaajan korteista tekemä ohjelma, jota pelaajan robotti noudattaa
    */
   LinkedList<Kortti> ohjelma=new LinkedList<>();
   /**
    * Monesko pelaaja on.
    */
   int mones;
   
    public Ihmispelaaja(Robotti pelinappula, int mones) {
        this.robotti = pelinappula;
        this.mones=mones;
        kasiTyhjaksi();
       
    }

    @Override
    public void otaKortti(Kortti kortti) {
        kasikortit.put(kortti, kasikortit.get(kortti)+1);
    }

    @Override
    public Robotti getRobotti() {
        return robotti;
    }

    @Override
    public LinkedList<Kortti> getOhjelma() {
        return ohjelma;
    }

   @Override
    public int getMones() {
        return mones;
    }

    @Override
    public HashMap<Kortti, Integer> getKasi() {
        return kasikortit;
    }

   @Override
    public void kasiTyhjaksi() {
        for (KortinToiminto kortinToiminto : KortinToiminto.values()) {
            kasikortit.put(new Kortti(kortinToiminto), 0);
        }
    }

    @Override
    public void ohjelmaTyhjaksi() {
        if (this.getRobotti().getVahinko()<5) {
            ohjelma=new LinkedList<>();
        } else {
            for (int i = 0; i <9-this.getRobotti().getVahinko(); i++) {
                ohjelma.removeLast();
            }
        }
        
    }

    @Override
    public void setShutdown() {
        ohjelmaTyhjaksi();
        while(ohjelma.size()!=5){
            ohjelma.add(new Kortti(KortinToiminto.NULL));
        }
        robotti.setActive(false);
    }

   @Override
   public boolean poistaKortti() {
       if (Math.max(0, robotti.getVahinko()-4)>=ohjelma.size()) {
           return false;
       }
        Kortti kortti=ohjelma.pollLast();
        kasikortit.put(kortti, kasikortit.get(kortti)+1);
        return true;
    }

    

    

    
    
    
    

    
    
}
