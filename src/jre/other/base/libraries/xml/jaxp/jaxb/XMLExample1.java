package jre.other.base.libraries.xml.jaxp.jaxb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XMLExample1 {
	
	
	public static boolean marshalling(Object inObject, String inFilePath) {
		
		boolean result = false;
		
		try(OutputStream os = new FileOutputStream(inFilePath)){
		
			try {
				JAXBContext jaxbContext = JAXBContext.newInstance(XMLObject.class, XMLObjectWrapper.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				jaxbMarshaller.marshal(inObject,os);
				result = true;
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return result;
		
	}
	
	
	public static <T> T unmarshalling(String inFilePath) {
				
		try(InputStream is = new FileInputStream(inFilePath)){
		
			try {
				JAXBContext jaxbContext = JAXBContext.newInstance(XMLObject.class,XMLObjectWrapper.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				return (T)jaxbUnmarshaller.unmarshal(is);
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return null;
		
	}
	
}
