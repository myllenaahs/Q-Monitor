package br.edu.ifpb.Monitoria.Service;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.gson.Gson;

import br.edu.ifpb.Monitoria.DAO.GeneralDAO;
import br.edu.ifpb.Monitoria.DAO.UsuarioDAO;
import br.edu.ifpb.Monitoria.Entidades.Cliente;

@Path("cadastro")
public class CadastroUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	GeneralDAO bd = new GeneralDAO();
	UsuarioDAO user = new UsuarioDAO();

	public CadastroUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	@POST
	@Produces("application/json")
	protected void cadastro(String stringJSON) throws IOException {
		
		Cliente cliente = new Cliente ();

		GeneralDAO bd = new GeneralDAO();
		UsuarioDAO user = new UsuarioDAO();

		Gson gson = new Gson();
		Cliente clienteJSON = gson.fromJson(stringJSON, Cliente.class);

		// Recuperando valores do formulario de cadastro

		cliente.setNome(clienteJSON.getNome());
		cliente.setDisciplina(clienteJSON.getDisciplina());
		cliente.setLogin(clienteJSON.getLogin());
		cliente.setSenha(clienteJSON.getSenha());

		bd.abrirConexao();
		user.insereUsuario(cliente);
		bd.fecharConexao();
	}

}