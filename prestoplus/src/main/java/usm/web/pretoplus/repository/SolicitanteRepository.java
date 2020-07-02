package usm.web.pretoplus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import usm.web.pretoplus.model.Solicitante;

public interface SolicitanteRepository extends JpaRepository<Solicitante, Long>{

	List<Solicitante> findByPNomeSolicitanteContaining(String NomeSolicitante);
}
