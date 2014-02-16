/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logiikka.robottiralli.korttienhallinta;

import java.util.Objects;
import java.util.Random;




public class Kortti {
    KortinToiminto toiminto;

    /**
     * Luo sattumanvaraisesti jonkun seitsemästä kortista.
     */
    public Kortti() {
        Random random=new Random();
        int vipu=random.nextInt(7)+1;
        switch (vipu) {
            case 1: toiminto=KortinToiminto.KAANNOSOIKEALLE;
                break;
            case 2: toiminto=KortinToiminto.KAANNOSVASEMMALLE;
                break;
            case 3: toiminto=KortinToiminto.KAKSIETEEN;
                break;
            case 4: toiminto=KortinToiminto.KOLMEETEEN;
                break;
            case 5: toiminto=KortinToiminto.UKAANNOS;
                break;
            case 6: toiminto=KortinToiminto.PERUUTUS;
                break;
            case 7: toiminto=KortinToiminto.YKSIETEEN;
                break;
        }
    }
    /**
     * Tekee kortin, jossa on tietty toiminto testejä varten.
     * @param toiminto Korttiin laitettava toiminto
     */
    public Kortti(KortinToiminto toiminto){
        this.toiminto=toiminto;
    }
    
    public KortinToiminto getToiminto() {
        return toiminto;
    }

    @Override
    public String toString() {
        return toiminto+"";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.toiminto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Kortti other = (Kortti) obj;
        if (this.toiminto != other.toiminto) {
            return false;
        }
        return true;
    }
    
    
}
