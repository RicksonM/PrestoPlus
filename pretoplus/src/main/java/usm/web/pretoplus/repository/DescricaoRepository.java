package usm.web.pretoplus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import usm.web.pretoplus.model.Contrato;
import usm.web.pretoplus.model.Descricao;

public interface DescricaoRepository extends JpaRepository<Descricao, String> {

	
	@Query("select u from Descricao u where u.profissinal = :email")
	List<Descricao> findByperfil(@Param("email") String email);
	
}
