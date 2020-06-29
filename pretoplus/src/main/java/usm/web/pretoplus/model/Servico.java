package usm.web.pretoplus.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Servico {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long IdServico;
	
	private String NomeServico;
	private String TipoServico;
	private int DataIni;
	private int DataEntre;
	
	

	//Construtores
	
	public Servico(long idServico, String nomeServico, String tipoServico, int dataIni, int dataEntre) {
		super();
		IdServico = idServico;
		NomeServico = nomeServico;
		TipoServico = tipoServico;
		DataIni = dataIni;
		DataEntre = dataEntre;
	}

	
	//Métodos
	

	public long getIdServico() {
		return IdServico;
	}


	public void setIdServico(long idServico) {
		IdServico = idServico;
	}


	public String getNomeServico() {
		return NomeServico;
	}


	public void setNomeServico(String nomeServico) {
		NomeServico = nomeServico;
	}


	public String getTipoServico() {
		return TipoServico;
	}


	public void setTipoServico(String tipoServico) {
		TipoServico = tipoServico;
	}


	public int getDataIni() {
		return DataIni;
	}


	public void setDataIni(int dataIni) {
		DataIni = dataIni;
	}


	public int getDataEntre() {
		return DataEntre;
	}


	public void setDataEntre(int dataEntre) {
		DataEntre = dataEntre;
	}



	
}
