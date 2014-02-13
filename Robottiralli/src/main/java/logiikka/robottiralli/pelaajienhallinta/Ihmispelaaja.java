package logiikka.robottiralli.pelaajienhallinta;

import logiikka.robottiralli.robottienhallinta.Robotti;
import logiikka.robottiralli.korttienhallinta.Kortti;
import java.util.ArrayList;
import java.util.List;






public class Ihmispelaaja implements Pelaaja{

    /**
     * Pelaajalla oleva robotti
     */
   Robotti pelinappula;
   /**
    * Pelaajan hallussa olevat kortit, joista tehdään ohjelma
    */
   ArrayList<Kortti> kasikortit=new ArrayList<>();
   /**
    * Pelaajan korteista tekemä ohjelma, jota pelaajan robotti noudattaa
    */
   ArrayList<Kortti> ohjelma=new ArrayList<>();

   
    public Ihmispelaaja(Robotti pelinappula) {
        this.pelinappula = pelinappula;
        
       
    }

    @Override
    public void otaKortti(Kortti kortti) {
        kasikortit.add(kortti);
    }

    @Override
    public Robotti getRobotti() {
        return pelinappula;
    }

    @Override
    public void teeOhjelma() {
          ArrayList<Kortti> keskenerainen=(ArrayList<Kortti>) nullLista(); 
//        for (Kortti kortti : kasikortit.keySet()) {
//            System.out.println(kortti+" "+kasikortit.get(kortti)+"kpl");
//        }
//        while(ohjelmaEiValmis(ohjelma)){
//            
//        }
//          if (true) {
//            pelinappula.setActive(false);
//             return;
//        }
//       ohjelma=new ArrayList<>();
         this.ohjelma=keskenerainen;
    }

    /**
     * Tarkistaa sisältääkö ohjelma 5 korttia
     * @param ohjelma tarkastettava ohjelma
     * @return palauttaa true, jos ohjelmassa on 5 korttia
     */
    public boolean ohjelmaEiValmis(ArrayList<Kortti> ohjelma) {
        return ohjelma.size()==5;
    }

    /**
     * Tekee ohjelman, joka sisältää pelkkiä null-arvoja shutdownia varten.
     * @return Palauttaa listan, jonka koko on 5 ja sisältää null-arvoja.
     */
     public List<Kortti> nullLista() {
        ArrayList<Kortti> lista=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            lista.add(i, null);
        }
        return lista;
    }

    @Override
    public ArrayList<Kortti> getOhjelma() {
        return ohjelma;
    }

    @Override
    public void setOhjelma(ArrayList<Kortti> ohjelma) {
        this.ohjelma=ohjelma;
        
    }

    @Override
    public ArrayList<Kortti> getKasi() {
        return kasikortit;
    }

    

    

    
    
    
    

    
    
}
