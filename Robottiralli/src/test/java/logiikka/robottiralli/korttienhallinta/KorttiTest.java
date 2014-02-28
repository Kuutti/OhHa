
package logiikka.robottiralli.korttienhallinta;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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
    
    @Test
    public void hashcode(){
        assertEquals(97*3+kortti.getToiminto().hashCode(),kortti.hashCode());
    }
    
    @Test
    public void samuus(){
        assertEquals(false,kortti.equals(null));
        assertEquals(false,kortti.equals("?"));
        Kortti kortti1=new Kortti(KortinToiminto.KAANNOSOIKEALLE);
        assertEquals(false,kortti1.equals(new Kortti(KortinToiminto.KAANNOSVASEMMALLE)));
        assertEquals(true,kortti1.equals(new Kortti(KortinToiminto.KAANNOSOIKEALLE)));
    }

    
}
