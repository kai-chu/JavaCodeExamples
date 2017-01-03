package effective.java.item1.staticfactory.vendor2;

import effective.java.item1.staticfactory.Provider;
import effective.java.item1.staticfactory.Service;

/**
 * Created by vendor Two
 * @author Chuck
 *
 */
public class Provider2 implements Provider{

	@Override
	public Service getService() {
		return new Service2();
	}

}
