package br.com.mystudies.java.functional;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ManagingLocks {

	public static class Locking{

		private Lock lock = new ReentrantLock();
		
		public void doOp() {
			Locker.runLocked(lock, () ->  {/*Critial code*/});
		}
	}
	
	
	public static class Locker{
		public static void runLocked(Lock lock, Runnable block) {
			lock.lock();			
			try {
				block.run();
			} finally {
				lock.unlock();
			}
		}
	}
	
	public void temp(){}
	
	
	public void temp3() {}
	
}
