package rr.robottiralli;

import java.util.ArrayList;






public class Ihmispelaaja implements Pelaaja{

   Robotti pelinappula;
   ArrayList<Kortti> kortit;
   ArrayList<Kortti> ohjelma;

    public Ihmispelaaja(Robotti pelinappula) {
        this.pelinappula = pelinappula;
        kortit=new ArrayList<>();
        ohjelma=new ArrayList<>();
    }

    @Override
    public void otaKortti(Kortti kortti) {
        kortit.add(kortti);
    }

    @Override
    public Robotti getRobotti() {
        return pelinappula;
    }

    @Override
    public void teeOhjelma() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    

    
    
}
