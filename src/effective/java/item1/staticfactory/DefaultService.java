package effective.java.item1.staticfactory;

public class DefaultService implements Service{

	@Override
	public void connect() throws Exception {
		System.out.println("To implement specific operation in general platform");
	}

}
