package br.edu.ifpb.new_Monitoria.bean;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.google.gson.Gson;

import br.edu.ifpb.new_Monitoria.Entidades.Cliente;
import br.edu.ifpb.new_Monitoria.util.HttpService;
import br.edu.ifpb.new_Monitoria.util.Response;

@RequestScoped
@ManagedBean
public class ControllerBean {

	private static final String URL_CONTEXT = "http://localhost:8080/Monitoria_SERVICE/";
	private Cliente cliente;
	
	private String login;
	private String senha;
	private String nome;
	private String matricula;
	private String horario;
	private String disciplina;

	public ControllerBean(){
		this.login="";
		this.senha="";
		this.nome="";
		this.matricula="";
		this.horario="";
		this.disciplina="";
		}

	public ControllerBean(String login, String senha,String nome, String matricula, String disciplina, String horario) {
		cliente.setNome(nome);
		cliente.setLogin(login);
		cliente.setSenha(senha);
		cliente.setMatricula(matricula);
		cliente.setHorario(horario);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}


	public String cadastro (){
			
			String JSON = "";
			
			Gson gson = new Gson();
			
			JSON = gson.toJson(cliente);
			
		
		Response response = null;
		
		try {
			response = HttpService.sendPostResquest("cadastro", JSON);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

}

/*
 * Response response = null;
 * 
 * try { HttpService.sendGetRequest("cadastro"); } catch (MalformedURLException
 * e) { // TODO Auto-generated catch block e.printStackTrace(); } catch
 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
 */