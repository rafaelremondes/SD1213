/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author rafaelremondes
 */
 class Peer implements Runnable{
    
	 Mutex mutex;
	 TwiligthZone twiligthZone;
    
    Peer( int ringPort, int prevPort, TwiligthZone twiligthZone){
       this.mutex = new Mutex(prevPort,ringPort);
       this.twiligthZone = twiligthZone;
    }
    
    public  void run(){
    	try{
    		Thread t1 = new Thread(mutex);
    		t1.start();
    		mutex.lock();
    		while(!mutex.enter){
    			System.out.println("a espera... \n");
    		}
    		twiligthZone.add(5);
            mutex.unlock();
    	}
        catch(Exception e){
        
        }
        
    
    }
    
}
