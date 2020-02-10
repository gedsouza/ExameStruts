package action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.soap.SOAPMessage;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.ExamesDAO;
import model.Exame;
import soap.SOAPClientLocal;
import to.ItemSoapTO;

@Namespaces(value = { @Namespace("/"), @Namespace("/") })
public class ExamesAction extends ActionSupport{

	private Exame exame = new Exame();

	private List<Exame> exames = new ArrayList<Exame>();

	private ExamesDAO examesDAO = new ExamesDAO();
	
	public String msg;
	
	private boolean sucesso;
	
	HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
	
	public boolean validar(){
	    if (exame.getNome().length() == 0) {
	        addFieldError("exame.nome", "Nome é obrigatório.");
	        return true;
	    }
	    return false;
	}

	public String cadastrarExame() {  

		try {
			examesDAO.adicionarExame(exame);
		} catch (SQLException e) {
			return "ERROR";
		}

		return "SUCCESS";
	}

	public String listarExame() {

		try {
			exames.addAll(examesDAO.listarExames());
			msg = (String) request.getAttribute("msg");
		} catch (SQLException e) {
			return "ERROR";
		}

		return "SUCCESS";
	}

	public String excluirExame() {

		try {
			sucesso = examesDAO.excluirExame(Long.parseLong(request.getParameter("id")));
		} catch (SQLException e) {
			return "ERROR";
		}
		return "SUCCESS";
	}
	
	public String buscaExamePorId() throws Exception {

		try {
			exame = examesDAO.buscarExamePorId(Long.parseLong(request.getParameter("id")));
//			@SuppressWarnings("static-access")
//			SOAPMessage mensagem = soap.callWebService(Long.parseLong(request.getParameter("id")));
//			JAXBContext jbc = JAXBContext.newInstance(ItemSoapTO.class);
//						Unmarshaller um = jbc.createUnmarshaller();
//			System.out.println("AQUI");
//			System.out.println(mensagem.getSOAPBody().getElementsByTagName("getExameResponse").item(0).getTextContent());
//			ItemSoapTO item = (ItemSoapTO) um.unmarshal(mensagem.getSOAPBody().extractContentAsDocument());
//			JAXBElement<ItemSoapTO> jb = um.unmarshal(mensagem.getSOAPBody(), ItemSoapTO.class); 
//			ItemSoapTO p = jb.getValue();
	//		jaxbObjectToJSON(item); 
			System.out.println("FINAL");
		} catch (SQLException e) {
			return "ERROR";
		}

		return "SUCCESS";
	}
	
//	private static void jaxbObjectToJSON(ItemSoapTO teste) 
//    {
//        try
//        {
//            JAXBContext jaxbContext = JAXBContext.newInstance(ItemSoapTO.class);
//            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
// 
//            // To format JSON
//            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); 
// 
//            //Print JSON String to Console
//            StringWriter sw = new StringWriter();
//            jaxbMarshaller.marshal(teste, sw);
//            System.out.println(sw.toString());
//        } 
//        catch (JAXBException e) 
//        {
//            e.printStackTrace();
//        }
//    }

	public String alteraExame() {

		try {
			examesDAO.alterarExame(exame);
		} catch (SQLException e) {
			return "ERROR";
		}
		return "SUCCESS";
	}

	public List<Exame> getExames() {
		return exames;
	}

	public void setExames(List<Exame> exames) {
		this.exames = exames;
	}
	
	public Boolean isSucesso() 
	{ 
		return sucesso; 
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

}
