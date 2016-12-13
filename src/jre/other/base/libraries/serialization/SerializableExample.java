package jre.other.base.libraries.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

public class SerializableExample {
	public static void serialize(Serializable inObject, String inFilePath) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(inFilePath))){
			
			oos.writeObject(inObject);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Done");
	}
	
	public static <T> List<T> deserialize(String inFilePath){
		List<T> objectList = null;
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inFilePath))){
			
			objectList = (List<T>) ois.readObject();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return objectList;
	}
	
}
