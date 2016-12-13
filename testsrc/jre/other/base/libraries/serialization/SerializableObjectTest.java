package jre.other.base.libraries.serialization;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SerializableObjectTest {

	private static final String FILE_PATH = "serialize.txt";
	private static String[] names = { "Kai", "Ming", "Mark", "Scont", "Ting" };
	private ArrayList<SerializableObject> objectList = null;

	@Before
	public void before() {
		objectList = new ArrayList<SerializableObject>();
		
		Arrays.asList(names).stream().forEach(name -> {
			SerializableObject obj = new SerializableObject(22, name);
			objectList.add(obj);
		});
	}

	@Test
	public void testSerialize() {
		SerializableExample.serialize(objectList, FILE_PATH);
		
	}
	
	@Test
	public void testDeserialize() {
		List<SerializableObject> objectList = SerializableExample.deserialize(FILE_PATH);
		assertTrue("Something wrong",names.length == objectList.size());
	}

}
