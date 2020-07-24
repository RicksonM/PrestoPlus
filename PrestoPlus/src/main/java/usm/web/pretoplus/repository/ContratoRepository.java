package usm.web.pretoplus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import usm.web.pretoplus.model.Contrato;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {

	
	@Query("select u from Contrato u where (u.contratado = :email or u.contratante = :email)")
	List<Contrato> findByperfil(@Param("email") String email);

	@Query("select u from Contrato u where u.id = :id")
	Contrato findByid(@Param("id") Long id);
	
	
	
}
