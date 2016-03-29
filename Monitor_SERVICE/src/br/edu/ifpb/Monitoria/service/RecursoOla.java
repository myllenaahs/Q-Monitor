package br.edu.ifpb.Monitoria.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;

import br.edu.ifpb.Monitoria.DAO.MonitorDAO;
import br.edu.ifpb.Monitoria.entidade.Erro;
import br.edu.ifpb.Monitoria.entidade.Monitor;

@Path("services")
public class RecursoOla {

	private static Logger logger = LogManager.getLogger(RecursoOla.class);

	@POST
	@Path("/get-byname")
	@Consumes("application/json")
	@Produces("application/json")
	public List<Monitor> findUserByName(Monitor monitor) {

		logger.info("/get-byname: " + monitor.getNome());

		String disciplina = monitor.getDisciplina().trim().toUpperCase();

		List<Monitor> monitores = MonitorDAO.getInstance().getByName(disciplina);
		logger.info("Participants: " + monitores.size() + "[" + monitores + "]");

		return monitores;

	}

	@POST
	@Path("/register")
	@Consumes("application/json")
	@Produces("application/json")
	public Response insertUser(Monitor monitor) {
		
		logger.info("/register: " + monitor);		
		ResponseBuilder builder;
		
		try {
			
			MonitorDAO.getInstance().insert(monitor);
			builder = Response.status(Response.Status.CREATED);			
			
		} catch (HibernateException hexp) {	
			
			Erro erro = new Erro(1, "Problema na inserção do participante");
			builder = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(erro);
		}

		return builder.build();
	}

	@GET
	public String digaOla(@QueryParam("parametro") String parametro) {
		return "Olá Mundo! <br/> O parâmetro de \"Query\"enviado foi: " + parametro;
	}

}