package br.edu.ifpb.monitoria.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import br.edu.ifpb.monitoria.entidade.Monitor;
import br.edu.ifpb.monitoria.service.MonitoriaService;
import br.edu.ifpb.monitoria.service.ProviderServiceFactory;

@ManagedBean(name = "monitorBean")
@RequestScoped
public class MonitorBean {

	private Monitor monitor;
	private List<Monitor> monitores;

	public List<Monitor> getMonitores() {
		return monitores;
	}

	public void setMonitores(List<Monitor> monitores) {
		this.monitores = monitores;
	}

	public MonitorBean() {
		this.monitor = new Monitor();
		this.monitores = new ArrayList<Monitor>();
	}

	public String listar() {

		MonitoriaService service = ProviderServiceFactory.createServiceClient(MonitoriaService.class);

		monitores = service.pesquisarMonitorDisciplina(monitor);

		return null;
	}

	public String cadastrar() {

		MonitoriaService service = ProviderServiceFactory.createServiceClient(MonitoriaService.class);

		monitores = service.cadastrarMonitor(monitor);

		return "Xhtml/index.xhtml";
	}

	public Monitor getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}

	public void exibirMsgMonitor() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Êxito",
				"Monitor(a) cadastrado(a) com sucesso.");
		RequestContext.getCurrentInstance().showMessageInDialog(message);
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
