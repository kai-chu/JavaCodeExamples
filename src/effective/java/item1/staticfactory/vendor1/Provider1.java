package effective.java.item1.staticfactory.vendor1;

import effective.java.item1.staticfactory.Provider;
import effective.java.item1.staticfactory.Service;

/**
 * Created by vender One
 * @author Chuck
 *
 */
public class Provider1 implements Provider{

	@Override
	public Service getService() {
		return new Service1();
	}

}
