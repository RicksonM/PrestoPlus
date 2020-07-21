package usm.web.pretoplus.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long IdCategoria;
	
	private String NomeCategoria;
	
	
	
	
	//Contrutores
	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categoria(long idCategoria, String nomeCategoria) {
		super();
		IdCategoria = idCategoria;
		NomeCategoria = nomeCategoria;
	}
	
	
	
	//Métodos
	public long getIdCategoria() {
		return IdCategoria;
	}
	public void setIdCategoria(long idCategoria) {
		IdCategoria = idCategoria;
	}
	public String getNomeCategoria() {
		return NomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		NomeCategoria = nomeCategoria;
	}
	
	
	
}
