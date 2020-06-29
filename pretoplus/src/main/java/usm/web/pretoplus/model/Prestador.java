package usm.web.pretoplus.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Prestador {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long IdPrestador;
	
	private String NomePrestador;
	private String Email;
	private int phone;
	private String TipoServico;
	private String CategoriaServico;
	
	
	

	//Construtores
	
	public Prestador() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Prestador(long idPrestador, String nomePrestador, String email, int phone, String tipoServico,
			String categoriaServico) {
	
		this.IdPrestador = idPrestador;
		this.NomePrestador = nomePrestador;
		this.Email = email;
		this.phone = phone;
		this.TipoServico = tipoServico;
		this.CategoriaServico = categoriaServico;
	}
	
	
	//Métodos
	
	
	

	public long getIdPrestador() {
		return IdPrestador;
	}
	public void setIdPrestador(long idPrestador) {
		IdPrestador = idPrestador;
	}
	public String getNomePrestador() {
		return NomePrestador;
	}
	public void setNomePrestador(String nomePrestador) {
		NomePrestador = nomePrestador;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getTipoServico() {
		return TipoServico;
	}
	public void setTipoServico(String tipoServico) {
		TipoServico = tipoServico;
	}
	public String getCategoriaServico() {
		return CategoriaServico;
	}
	public void setCategoriaServico(String categoriaServico) {
		CategoriaServico = categoriaServico;
	}
	
	
	
	
	
	
	
	
	
}
