package effective.java.item1.staticfactory.vendor1;

import effective.java.item1.staticfactory.Service;

public class Service1 implements Service {

	@Override
	public void connect() throws Exception {
		System.out.println("To implement specific operation in Vendor1 platform");
	}

}
