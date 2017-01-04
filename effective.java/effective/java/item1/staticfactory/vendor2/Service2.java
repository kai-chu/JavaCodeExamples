package effective.java.item1.staticfactory.vendor2;

import effective.java.item1.staticfactory.Service;

public class Service2 implements Service{

	@Override
	public void connect() throws Exception {
		System.out.println("To implement specific operation in Vendor2 platform");
	}

}
