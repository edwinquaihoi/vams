/**
 * 
 */
package au.com.csl.vams.config;

import java.util.Collection;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.NoResultException;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import au.com.csl.vams.model.relational.AppUser;
import au.com.csl.vams.model.relational.UserRepositoryUserDetails;
import au.com.csl.vams.service.IUserSvc;

/**
 * @author sanketsw
 *
 */
@RequestScoped
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@EJB(mappedName="java:module/UserSvc!au.com.csl.vams.service.impl.UserSvc")
	private IUserSvc userSvc;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails userDetails = null;
		try {
			AppUser user = userSvc.getById(username);
			userDetails = new UserRepositoryUserDetails(user);
		} catch (NoResultException e) {
			throw new UsernameNotFoundException(username);
		}
		return userDetails;

	}

	public IUserSvc getUserSvc() {
		return userSvc;
	}
	
	public void setUserSvc(IUserSvc userSvc) {
		this.userSvc = userSvc;
	}
	
}