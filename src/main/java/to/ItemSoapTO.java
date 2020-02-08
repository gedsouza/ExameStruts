package to;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import model.Exame;

@XmlRootElement(name = "getExameResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class ItemSoapTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "nome")
	private String nome; 
	
	@XmlElement(name = "getExameReturn")
	private Exame exame; 
}
