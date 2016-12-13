package jre.other.base.libraries.serialization;

import java.io.Serializable;

public class SerializableObject implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int age;
	private String name;
	
	public SerializableObject(int inAge, String inName) {
		this.age = inAge;
		this.name = inName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
