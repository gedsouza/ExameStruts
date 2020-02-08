package to;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "getExameReturn")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExameTO {
	@XmlElement(name = "nome")
	@JsonProperty("nome")
	public String nome;
}
