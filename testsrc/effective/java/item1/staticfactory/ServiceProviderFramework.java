package effective.java.item1.staticfactory;

import static org.junit.Assert.fail;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import org.junit.Before;
import org.junit.Test;

import effective.java.item1.staticfactory.vendor1.Provider1;
import effective.java.item1.staticfactory.vendor2.Provider2;

public class ServiceProviderFramework {
	
	static final String M_VENDOR1 = "VENDOR1";
	static final String M_VENDOR2 = "VENDOR2";

	Executor m_executor = Executors.newSingleThreadExecutor(new ThreadFactory() {
		@Override
		public Thread newThread(Runnable r) {
			Thread t = new Thread(r);
			t.setDaemon(true);
			t.setName("Service Registration Thread");			
			return t;
		}
	});
	
	
	@Before
	public void before() {
		m_executor.execute(()->{
			Services.registerProvider(M_VENDOR1, new Provider1());
			Services.registerProvider(M_VENDOR2, new Provider2());
			Services.registerDefaultProvider(new DefaultProvider());
		});
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void test() {
		try {
			Services.newInstance(M_VENDOR1).connect();
			Services.newInstance(M_VENDOR2).connect();			
		} catch (Exception e) {
			e.printStackTrace();			
		}
		
		try {
			Services.newInstance().connect();
		} catch (Exception e) {
			fail("Not yet implemented");
		}
	}

}
