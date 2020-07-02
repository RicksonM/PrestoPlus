package usm.web.pretoplus.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Solicitante {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long IdSolicitante;
	private String PNomeSolicitante;
	private String SNomeSolicitante;
	private String cpf;
	private String Email;
	private String phone;
	private String fixo;
	private String senha;
	private String datanas;
	

	//Construtores
	
	
	
	public Solicitante(long idSolicitante, String PnomeSolicitante, String SnomeSolicitante, String email,String cpf, String fixo, String phone) {
		super();
		this.IdSolicitante = idSolicitante;
		this.PNomeSolicitante = PnomeSolicitante;
		this.SNomeSolicitante = SnomeSolicitante;
		this.Email = email;
		this.phone = phone;
		this.cpf = cpf;
		this.fixo = fixo;
	}
	public Solicitante() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Métodos
	
	
	
	public long getIdSolicitante() {
		return IdSolicitante;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getFixo() {
		return fixo;
	}
	public void setFixo(String fixo) {
		this.fixo = fixo;
	}
	public void setIdSolicitante(long idSolicitante) {
		IdSolicitante = idSolicitante;
	}

	public String getPNomeSolicitante() {
		return PNomeSolicitante;
	}
	public void setPNomeSolicitante(String pNomeSolicitante) {
		PNomeSolicitante = pNomeSolicitante;
	}
	public String getSNomeSolicitante() {
		return SNomeSolicitante;
	}
	public void setSNomeSolicitante(String sNomeSolicitante) {
		SNomeSolicitante = sNomeSolicitante;
	}
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDatanas() {
		return datanas;
	}
	public void setDtanas(String datanas) {
		this.datanas = datanas;
	}
	
	
	
	
	
}
