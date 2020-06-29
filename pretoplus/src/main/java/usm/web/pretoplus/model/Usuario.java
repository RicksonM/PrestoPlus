package usm.web.pretoplus.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Usuario  implements UserDetails{

	@Id
	private String email;
	
	private String login;
	private String senha;
	private String PNomeSolicitante;
	private String SNomeSolicitante;
	private String cpf;
	private String phone;
	private String datanas;
	private String descricao;
	private String local;
	private String profissao;
	private String tipo;
	private String file;



	@ManyToMany
	private List<Contrato> contrato;
	
	@ManyToMany
	private List<Descricao> avaliacao;
	
	
	

	@ManyToMany
	@JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(
			name = "usuario_id", referencedColumnName = "email"),
			inverseJoinColumns = @JoinColumn(
			name = "role_id", referencedColumnName = "nomeRole"))
	
	private List<Role> roles;


	public Usuario(String login, String senha, String pNomeSolicitante, String sNomeSolicitante, String cpf,
			String email, String phone, String datanas, String descricao, String local, String profissao, String file) {
		super();
		this.login = login;
		this.senha = senha;
		this.PNomeSolicitante = pNomeSolicitante;
		this.SNomeSolicitante = sNomeSolicitante;
		this.cpf = cpf;
		this.email = email;
		this.phone = phone;
		this.datanas = datanas;
		this.descricao = descricao;
		this.local = local;
		this.profissao = profissao;
		this.file = file;
	}





	public String getFile() {
		return file;
	}


	public void setFile(String file) {
		this.file = file;
	}





	public List<Descricao> getAvaliacao() {
		return avaliacao;
	}



	public void setAvaliacao(List<Descricao> avaliacao) {
		this.avaliacao = avaliacao;
	}



	public List<Contrato> getContrato() {
		return contrato;
	}


	public void setContrato(List<Contrato> contrato) {
		this.contrato = contrato;
	}

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}


	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	
	

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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


	public void setDatanas(String datanas) {
		this.datanas = datanas;
	}

	

	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getLocal() {
		return local;
	}


	public void setLocal(String local) {
		this.local = local;
	}


	public String getProfissao() {
		return profissao;
	}

	
	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}
