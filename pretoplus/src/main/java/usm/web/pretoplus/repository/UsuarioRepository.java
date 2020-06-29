
package usm.web.pretoplus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import usm.web.pretoplus.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{
	Usuario findByEmail(String email);
	
	
	//Método para listar apenas clientes ou prestadores
	List<Usuario> findBytipo(String tipo);
	
	//Método paa filtrar por profissao do prestador
	@Query("select u from Usuario u where u.profissao like %?1%")
	List<Usuario> findByprofissao(String profissao);

	@Query("select u from Usuario u where local like %?1% and profissao like %?2%")
	List<Usuario> findByfiltro(String local, String profissao);
	
}
