package effective.java.item3.singleton;

import static org.junit.Assert.assertNotSame;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

public class ReflectionInvocationTest {
	EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
	Singleton singleton = Singleton.INSTANCE;
	StaticFactorySingleton staticFactorySingleton = StaticFactorySingleton.getInstance();
	
	@Test
	public void testPrivateField() {
		singleton = Singleton.INSTANCE;
	}

	@Test
	public void testStaticFactory() {
		staticFactorySingleton = StaticFactorySingleton.getInstance();
	}

	@Test
	public void testEnumSingleton() {
		 enumSingleton = EnumSingleton.INSTANCE;
	}

	@Test
	public void testReflectionConstructor() {
		Class<Singleton> singletonClass = Singleton.class;

		Constructor<Singleton>[] constructors = (Constructor<Singleton>[]) singletonClass.getDeclaredConstructors();

		Constructor.setAccessible(constructors, true);

		for (Constructor<Singleton> c : constructors) {
			if (c.getParameterCount() == 0) {
				try {
					Singleton instance = c.newInstance();

					assertNotSame(instance, singleton);
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
