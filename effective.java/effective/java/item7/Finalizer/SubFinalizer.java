package effective.java.item7.Finalizer;

public class SubFinalizer extends Finalizer{
	
	//If a subclass implementor overrides a superclass finalizer but forgets to invoke it, the superclass finalizer will never be invoked.
	protected void finalize() throws Throwable {
		super.finalize(); 
	}
}
