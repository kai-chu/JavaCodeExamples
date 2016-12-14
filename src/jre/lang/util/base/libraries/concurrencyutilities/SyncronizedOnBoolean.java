package jre.lang.util.base.libraries.concurrencyutilities;

public class SyncronizedOnBoolean {
	
	private int valueSynchronizedByBoolean = 0;
	private int valueSynchronizedByThis = 0;
	private Boolean unsafeBooleanLock = true;

	private Runnable runnable = ()->{
		for(int i=0;i<100000&&!Thread.currentThread().isInterrupted();i++) {
			synchronized(unsafeBooleanLock) {
				if(unsafeBooleanLock)
					unsafeBooleanLock = false;
				else 
					unsafeBooleanLock = true;
				
				valueSynchronizedByBoolean++;
			}
			
			synchronized(this) {
				valueSynchronizedByThis++;
			}
			
		}
	};
	
	private Thread thread1 = new Thread(runnable,"Thread1");
	private Thread thread2 = new Thread(runnable,"Thread2");
	
	public void runThread() {
		thread1.start();
		thread2.start();
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("valueSynchronizedByBoolean:"+valueSynchronizedByBoolean);
		System.out.println("valueSynchronizedByThis:"+valueSynchronizedByThis);
	}
	
	public int getValueSynchronizedByBoolean() {
		return valueSynchronizedByBoolean;
	}
	
	public int getValueSynchronizedByThis() {
		return valueSynchronizedByThis;
	}
}
