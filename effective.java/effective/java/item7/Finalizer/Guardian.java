package effective.java.item7.Finalizer;

public class Guardian {
	
	Object bean = new Object();
	
	private final Object finalizerGuardian = new Object() {
		@Override protected void finalize() throws Throwable {
			bean = null;
		}
	};

}
