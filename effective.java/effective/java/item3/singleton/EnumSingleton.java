package effective.java.item3.singleton;

/**
 * While this approach has yet to be widely adopted, a single-element enum type is the best way to implement a singleton.
 * @author Chuck
 *
 */
public enum EnumSingleton {
	INSTANCE;
	
	public void method() {}
}
