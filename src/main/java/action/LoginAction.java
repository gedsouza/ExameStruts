package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;

/**
 * Notice the @Action annotation where action and result pages are declared
 * Also notice that we don't need to implement Action interface or extend ActionSupport
 * class, only we need is an execute() method with same signature
 * @author pankaj
 *
 */
@Namespaces(value={@Namespace("/"),@Namespace("/")})
public class LoginAction {
	
	private String msg = "";

	public String login() throws Exception {
        if("admin".equals(getNome()) && "admin".equals(getSenha())) {
 				return "SUCCESS";
		}else {
			setMsg("Usuário ou senha inválidos");
			return "ERROR";
		}
	}
	
	//Java Bean to hold the form parameters
	private String nome;
	private String senha;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
