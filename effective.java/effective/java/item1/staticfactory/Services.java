package effective.java.item1.staticfactory;

import java.util.Map;

import effective.java.item.utility.CollectionUtilities;

public class Services {
	// Private construction to avoid to be created by others
	private Services() {};
	
	private static final String M_DEFAULT_NAME = "<def>";
	private static final Map<String,Provider> m_providers = CollectionUtilities.newHashMapInstance();
	
	// Provider Registration API
	public static void registerDefaultProvider(Provider inProvider) {
		registerProvider(M_DEFAULT_NAME, inProvider);
	}
	
	public static void registerProvider(String inName, Provider inProvider) {
		m_providers.put(inName, inProvider);
	}
	
	// Service access API
	public static Service newInstance() {
		return newInstance(M_DEFAULT_NAME);
	}
	
	public static Service newInstance(String inName) {
		// Static Factory Method Usage
		Provider p = m_providers.get(inName);
		if(p == null)
			throw new IllegalArgumentException("No provider registered with name: " + inName);
		
		return p.getService();
	}
}
