package jre.other.base.libraries.xml.jaxp.jaxb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class XMLExample1Test {
	private static final String FILE_PATH = "xmlObject.txt";
	XMLObject xmlObject = null;
	
	List<XMLObject> xmlObjectList = null;
	
	@Before
	public void beforeClass() {
		
		try {
			Files.deleteIfExists(Paths.get(FILE_PATH));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		xmlObject = new XMLObject("Object1",1,1);
		xmlObjectList = new ArrayList<XMLObject>();
		xmlObjectList.add(xmlObject);
		xmlObject = new XMLObject("Object2",1,1);
		xmlObjectList.add(xmlObject);
	}
	
	@Test
	public void testXmlObjectOperation() {
		testMarshalling();
		testUnmarshalling();
	}
	
	public void testMarshalling() {
		assertTrue(XMLExample1.marshalling(xmlObject, FILE_PATH));
	}
	
	public void testUnmarshalling() {
		XMLObject object = XMLExample1.unmarshalling(FILE_PATH);
		assertNotNull(object);
		assertEquals(object.getName(),xmlObject.getName());
	}
	
	
	@Test
	public void testXmlObjectListOperation() {
		testListMarshalling();
		testListUnmarshalling();
	}
	public void testListMarshalling() {
		assertTrue(XMLExample1.marshalling(new XMLObjectWrapper(xmlObjectList), FILE_PATH));
	}
	
	public void testListUnmarshalling() {
		XMLObjectWrapper objectList = XMLExample1.unmarshalling(FILE_PATH);
		assertNotNull(objectList);
		assertEquals(objectList.getXmlObjectList().size(),xmlObjectList.size());
	}
	
}
