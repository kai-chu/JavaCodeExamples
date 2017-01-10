package effective.java.item5.unnecessaryObjects;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import effective.java.item.utility.RuntimeUtilities;


public class UnnecessaryObjects {
	
	
	private static final int LOOP_TIMES = 1000000;
	public static void main(String [] args) {
		
		RuntimeUtilities.timePrint(()->{
				String s = new String("s"); // Don't do this			
		},LOOP_TIMES);
		
		RuntimeUtilities.timePrint(()->{
				String s = "s"; //it is guaranteed that the object will be reused by any other code running in the same virtual machine that happens to contain the same string literal [JLS, 3.10.5].
		},LOOP_TIMES);
		
		RuntimeUtilities.timePrint(()->{
				Boolean s = new Boolean("true"); // Don't do this
		},LOOP_TIMES);
		
		RuntimeUtilities.timePrint(()->{
				Boolean s = Boolean.TRUE; // The constructor creates a new object each time it’s called, while the static factory method is never required to do so and won’t in practice.
		},LOOP_TIMES);
		
		RuntimeUtilities.timePrint(()->{
			Boolean s = Boolean.valueOf("true"); // The constructor creates a new object each time it’s called, while the static factory method is never required to do so and won’t in practice.
		},LOOP_TIMES);
	
		RuntimeUtilities.timePrint(()->{
			Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
			gmtCal.set(1946, Calendar.JANUARY,1,0,0,0);
			Date boomStart = gmtCal.getTime();
			long time = boomStart.getTime();
		},LOOP_TIMES);
		
		/*
		 * Lazy initialization Item71
		 * */
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		gmtCal.set(1946, Calendar.JANUARY,1,0,0,0);
		Date boomStart = gmtCal.getTime();
		RuntimeUtilities.timePrint(()->{
			long time = boomStart.getTime();
		},LOOP_TIMES);
		
		// Adapters Map.keyset Although the returned Set instance is typically mutable, all of the returned objects are functionally identical: when one of the returned objects changes, so do all the others because they’re all backed by the same Map instance.
		
		// Autoboxing
		
		RuntimeUtilities.timePrint(()->{
			Long sum = 0L; // auto boxing
			for(int i=0;i<LOOP_TIMES;i++)
				sum+=i;
		},1);
		
		RuntimeUtilities.timePrint(()->{
			long sum = 0L;
			for(int i=0;i<LOOP_TIMES;i++)
				sum+=i;
		},1);
		
	}
}
