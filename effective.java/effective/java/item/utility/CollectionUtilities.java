package effective.java.item.utility;

import java.util.HashMap;
import java.util.Map;

public class CollectionUtilities {
	
	public static <T,V>  Map<T,V> newHashMapInstance() {
		return new HashMap<T,V>();
	}
}
