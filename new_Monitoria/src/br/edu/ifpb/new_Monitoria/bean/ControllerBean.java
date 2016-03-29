package br.edu.ifpb.new_Monitoria.bean;

import java.io.IOException;

import java.net.MalformedURLException;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.google.gson.Gson;

import br.edu.ifpb.new_Monitoria.Entidades.Cliente;
import br.edu.ifpb.new_Monitoria.util.HttpService;
import br.edu.ifpb.new_Monitoria.util.Response;


@ManagedBean
@RequestScoped
public class ControllerBean {

	private static final String URL_CONTEXT = "http://localhost:8080/Monitoria_SERVICE/";

	private Cliente cliente;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ControllerBean() {
		this.cliente = new Cliente();
	}

	public String cadastro() throws ClassNotFoundException {

		System.out.println("chegou");		

		String JSON = "";

		Gson gson = new Gson();

		JSON = gson.toJson(this.cliente);

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