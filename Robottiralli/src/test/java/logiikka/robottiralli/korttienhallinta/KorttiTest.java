/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logiikka.robottiralli.korttienhallinta;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author KOTIPC
 */
public class KorttiTest {
    
    Kortti kortti;
    
    @Before
    public void setUp() {
        kortti=new Kortti();
    }
    
    @Test
    public void KortintoimintoEiNULL(){
        assertEquals(false, kortti.getToiminto() == null);
    }
    @Test
    public void String(){
        assertEquals(kortti.getToiminto().toString(),kortti.toString());
    }
    

    
}
