package usm.web.pretoplus.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Contrato {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String contratante;
	private String contratado;
	private String descricao;
	private String datainicio;
	private String datafim;
	private String valor;
	private String status;
	private String file;
	
	
	@ManyToMany
	private List<Usuario> usuario;
	
	public Contrato(String contratante, String contratado, String descricao, String datainicio, String datafim,
			String valor, String status, String file) {
		super();
		this.contratante = contratante;
		this.contratado = contratado;
		this.descricao = descricao;
		this.datainicio = datainicio;
		this.datafim = datafim;
		this.valor = valor;
		this.status = status;
		this.file = file;
	}
	public Contrato() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public List<Usuario> getUsuario() {
		return usuario;
	}
	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}
	
	public String getContratante() {
		return contratante;
	}
	public void setContratante(String contratante) {
		this.contratante = contratante;
	}
	public String getContratado() {
		return contratado;
	}
	public void setContratado(String contratado) {
		this.contratado = contratado;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDatainicio() {
		return datainicio;
	}
	public void setDatainicio(String datainicio) {
		this.datainicio = datainicio;
	}
	public String getDatafim() {
		return datafim;
	}
	public void setDatafim(String datafim) {
		this.datafim = datafim;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
