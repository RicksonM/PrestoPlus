package usm.web.pretoplus.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Descricao {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String profissinal;
	private String avaliador;
	private String avaliacao;
	
	@ManyToMany
	private List<Usuario> usuario;

	
	
	
	public Descricao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Descricao(String profissinal, String avaliador, String avaliacao, List<Usuario> usuario) {
		super();
		this.profissinal = profissinal;
		this.avaliador = avaliador;
		this.setAvaliacao(avaliacao);
		this.usuario = usuario;
	}

	public String getProfissinal() {
		return profissinal;
	}

	public void setProfissinal(String profissinal) {
		this.profissinal = profissinal;
	}

	public String getAvaliador() {
		return avaliador;
	}

	public void setAvaliador(String avaliador) {
		this.avaliador = avaliador;
	}


	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

	public String getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	
	
	
	
	
}
