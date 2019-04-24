package cl.hfierroprog.apiGateway.ApiGateway.models.service;

import cl.hfierroprog.apiGateway.ApiGateway.models.dao.IUsuarioDao;
import cl.hfierroprog.apiGateway.ApiGateway.models.entity.Role;
import cl.hfierroprog.apiGateway.ApiGateway.models.entity.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService {

	@Autowired
	private IUsuarioDao usuarioDao;
	
	private Logger logger = LoggerFactory.getLogger(JpaUserDetailsService.class);
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
        List<Usuario> usuarios = usuarioDao.findAll();
        Usuario usuario = null;
        
        if(usuarios.isEmpty()) {
        	logger.error("Error en el Login: no existe usuarios en el sistema!");
        	throw new UsernameNotFoundException("no existen usuarios en el sistema!");
        }

        for(Usuario user: usuarios) {
        	if(username.equals(user.getUsername())) {
        		usuario = user;
			}
		}


		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
	}

}
