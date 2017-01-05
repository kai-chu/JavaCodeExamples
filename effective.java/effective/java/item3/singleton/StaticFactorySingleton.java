package effective.java.item3.singleton;

public class StaticFactorySingleton {
	
	public static StaticFactorySingleton getInstance() {
		// In the future, we can change this part without having any effect on other API invoked this method once we return an instance of StaticFactorySingleton
		return INSTANCE;
	}
	
	private static final StaticFactorySingleton INSTANCE = new StaticFactorySingleton();
	
	private StaticFactorySingleton() {}
	
	public void method() {}
	
}
