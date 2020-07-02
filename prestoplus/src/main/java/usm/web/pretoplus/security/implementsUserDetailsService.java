package usm.web.pretoplus.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import usm.web.pretoplus.model.Usuario;
import usm.web.pretoplus.repository.UsuarioRepository;

@Repository
@Transactional
public class implementsUserDetailsService implements UserDetailsService{
	@Autowired
	private UsuarioRepository ur;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = ur.findByEmail(email);
		
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario não encontrado!");
		}
		return usuario;
	}

}
