package effective.java.item.utility;

public class RuntimeUtilities {
	private static int i = 0;
	
	public static void timePrint(Runnable inRun, int inLoopTimes) {
		long timeStart = System.currentTimeMillis();
		while(inLoopTimes-- >= 0) {
			inRun.run();
		}
		System.out.println("------------"+ i + "------------");
		System.out.println(System.currentTimeMillis() - timeStart);
		i++;
	}
}
