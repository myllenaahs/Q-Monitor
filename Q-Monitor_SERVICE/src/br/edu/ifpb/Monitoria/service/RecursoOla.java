package br.edu.ifpb.Monitoria.service;  
  
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
  
@Path("ola-mundo")  
public class RecursoOla {  
  
	 @GET  
	 @Produces("application/json")
	   public String digaOla(@QueryParam("parametro") String parametro) {  
	      return "Ol� Mundo! <br/> O par�metro de \"Query\"enviado foi: " + parametro;  
	   }  
	     
	   @GET  
	   @Path("/{parametro}")  
	   public String digaOlaPath(@PathParam("parametro") String parametro) {  
	      return "Ol� Mundo! <br/> O par�metro de \"URI\" enviado foi: " + parametro;  
	   }  
} 