
package logiikka.robottiralli.hallinnat;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitori {
    
   final Lock lock = new ReentrantLock();
   final Condition valmis  = lock.newCondition(); 
   
   public void odota() throws InterruptedException{
       lock.lock();
       valmis.await();
       lock.unlock();
   }
   
   public void avaa(){
       lock.lock();
       valmis.signal();
       lock.unlock();
   }
}
