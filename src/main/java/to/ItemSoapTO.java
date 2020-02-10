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
	
	@XmlElement(name = "cpf")
	private String cpf; 
	
	@XmlElement(name = "data", namespace = "ns1")
	private String data; 
	
	@XmlElement(name = "email", namespace = "http://ws")
	private String email; 
	
	@XmlElement(name = "endereco")
	private String endereco;
	
	@XmlElement(name = "id", namespace = "ns1")
	private String id; 
	
	@XmlElement(name = "nome")
	private String nome; 
	
	@XmlElement(name = "retorno", namespace = "ns1")
	private String retorno;
	
	@XmlElement(name = "situacao", namespace = "ns1")
	private String situacao;
	
	@XmlElement(name = "telefone", namespace = "ns1")
	private String telefone;
	
	@XmlElement(name = "tpExame", namespace = "ns1")
	private String tpExame; 
	
	@XmlElement(name = "getExameReturn", namespace = "http://ws")
	private Exame exame;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;	
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	} 
}
