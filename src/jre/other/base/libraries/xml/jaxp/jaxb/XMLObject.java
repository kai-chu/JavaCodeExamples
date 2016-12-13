package jre.other.base.libraries.xml.jaxp.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class XMLObject {
	private String name;
	private int id;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	
	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public XMLObject() {
		
	}
	
	public XMLObject(String name, int id, int age) {
		super();
		this.name = name;
		this.id = id;
		this.age = age;
	}
}
