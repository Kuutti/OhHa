package logiikka.robottiralli.pelaajienhallinta;

import logiikka.robottiralli.robottienhallinta.Robotti;
import logiikka.robottiralli.korttienhallinta.Kortti;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;






public class Ihmispelaaja implements Pelaaja{

   Robotti pelinappula;
   HashMap<Kortti,Integer> kasikortit=new HashMap<>();

   @Override
    public HashMap<Kortti, Integer> getKasikortit() {
        return kasikortit;
    }
   

    public Ihmispelaaja(Robotti pelinappula) {
        this.pelinappula = pelinappula;
        kasikortit=new HashMap<>();
       
    }

    @Override
    public void otaKortti(Kortti kortti) {
        if (!kasikortit.containsKey(kortti)) {
            kasikortit.put(kortti, 0);
        }
        kasikortit.put(kortti, kasikortit.get(kortti)+1);
    }

    @Override
    public Robotti getRobotti() {
        return pelinappula;
    }

    @Override
    public List<Kortti> teeOhjelma() {
          List<Kortti> ohjelma=nullLista(); 
//        for (Kortti kortti : kasikortit.keySet()) {
//            System.out.println(kortti+" "+kasikortit.get(kortti)+"kpl");
//        }
//        while(ohjelmaEiValmis(ohjelma)){
//            
//        }
        return ohjelma;
    }

    public boolean ohjelmaEiValmis(List<Kortti> ohjelma) {
        for (Kortti kortti : ohjelma) {
            if (kortti==null) {
                return true;
            }
        }
        return false;
    }

     public List<Kortti> nullLista() {
        List<Kortti> lista=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            lista.add(i, null);
        }
        return lista;
    }

    

    
    
    
    

    
    
}
