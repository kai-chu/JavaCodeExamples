package effective.java.item1.staticfactory;

public class DefaultProvider implements Provider{

	@Override
	public Service getService() {
		return new DefaultService();
	}

}
