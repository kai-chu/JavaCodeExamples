package effective.java.item4.noninstantiability;

public class Noninstantiability {

	private Noninstantiability() {
		/**
		 * The AssertionError isn’t strictly required, but it provides insurance
		 * in case the constructor is accidentally invoked from within the
		 * class. It guarantees that the class will never be instantiated under
		 * any circumstances.
		 */
		throw new AssertionError();
	}
}
