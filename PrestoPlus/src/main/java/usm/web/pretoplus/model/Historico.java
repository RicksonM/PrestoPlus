package usm.web.pretoplus.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Historico {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long IdChat;
	
	private long IdPrestador;
	private long IdSolicitante;
	
	
	
	//Construtores
	
	public Historico() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Historico(long idChat, long idPrestador, long idSolicitante) {
		super();
		IdChat = idChat;
		IdPrestador = idPrestador;
		IdSolicitante = idSolicitante;
	}
	
	
	//Métodos
	
	public long getIdChat() {
		return IdChat;
	}
	public void setIdChat(long idChat) {
		IdChat = idChat;
	}
	public long getIdPrestador() {
		return IdPrestador;
	}
	public void setIdPrestador(long idPrestador) {
		IdPrestador = idPrestador;
	}
	public long getIdSolicitante() {
		return IdSolicitante;
	}
	public void setIdSolicitante(long idSolicitante) {
		IdSolicitante = idSolicitante;
	}
	
	
}
