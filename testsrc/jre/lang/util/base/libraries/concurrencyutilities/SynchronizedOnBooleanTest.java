package jre.lang.util.base.libraries.concurrencyutilities;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SynchronizedOnBooleanTest {
	private SyncronizedOnBoolean threadsObject;
	
	@Before
	public void before() {
		threadsObject = new SyncronizedOnBoolean();
		threadsObject.runThread(); // 1000 times each thread
	}
	
	@Test
	public void test() {
		assertTrue(threadsObject.getValueSynchronizedByBoolean()==threadsObject.getValueSynchronizedByThis());
	}

}
