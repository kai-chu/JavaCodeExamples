package effective.java.item7.Finalizer;

public class Finalizer {
	
	Object bean = new Object();
	
	@Override
	protected void finalize() throws Throwable {
		try {
			bean = null;
		}finally {
			super.finalize();
		}
	}
}
