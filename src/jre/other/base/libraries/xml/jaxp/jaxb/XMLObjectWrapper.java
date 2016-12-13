package jre.other.base.libraries.xml.jaxp.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="XMLRoot")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLObjectWrapper {
	
	@XmlElementWrapper(name="xmlObjectList")
	@XmlElements({
		@XmlElement(name="xmlObject")
	})
	private List<XMLObject> m_xmlObjectList = null;
	
	
	public XMLObjectWrapper(List<XMLObject> inList) {
		m_xmlObjectList = inList;
	}
	
	public XMLObjectWrapper() {
		
	}

	public List<XMLObject> getXmlObjectList() {
		return m_xmlObjectList;
	}

	
	public void setXmlObjectList(List<XMLObject> xmlObjectList) {
		this.m_xmlObjectList = xmlObjectList;
	}

}


//http://stackoverflow.com/questions/4144296/marshalling-a-list-of-objects-implementing-a-common-interface-with-jaxb/4145801#4145801