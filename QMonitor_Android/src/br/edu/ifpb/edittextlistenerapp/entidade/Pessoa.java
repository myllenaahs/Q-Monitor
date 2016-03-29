package br.edu.ifpb.edittextlistenerapp.entidade;


import java.io.Serializable;

import br.edu.ifpb.edittextlistenerapp.exclusion.ExcluirJSON;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Rhavy on 27/02/2016.
 */
public class Pessoa implements Serializable {
	
	public Pessoa(){
		
	}


    public Pessoa (String nome, String horario, String disciplina) {
        this.nome = nome;
        this.horario=horario;
        this.disciplina=disciplina;
    }
      

    @ExcluirJSON
	@SerializedName("id")
    private int id;
    
    @ExcluirJSON
    @SerializedName("fullName")
    private String nome;
    
    @ExcluirJSON
    @SerializedName("horario")
    private String horario;
    
    @SerializedName("disciplina")
    private String disciplina;


    public String getHorario() {
		return horario;
	}


	public void setHorario(String horario) {
		this.horario = horario;
	}


	public String getDisciplina() {
		return disciplina;
	}


	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

  

    @Override
    public String toString() {
        return "[fullName: " + nome + "; email: " + horario + "]";
    }
}