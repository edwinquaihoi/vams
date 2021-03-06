package au.com.csl.vams.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
@ComponentScan({ "au.com.csl.vams.config", "au.com.csl.vams.service.impl", "au.com.csl.vams.config", "au.com.csl.vams.dao.relational",
		"au.com.csl.vams.dao", "au.com.csl.vams.dao.relational", "au.com.csl.vams.scaffold" })
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	public UserDetailsService getUserDetailsService() {
		return userDetailsService;
	}

	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	// @Autowired
	// public void configureGlobal(AuthenticationManagerBuilder auth) throws
	// Exception {
	// auth
	// .inMemoryAuthentication()
	// .withUser("admin").password("admin").roles("USER");
	// }
	//

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.formLogin().usernameParameter("username").passwordParameter("password").loginPage("/login.xhtml").permitAll()
				.loginProcessingUrl("/login").and().httpBasic();
				// have to disable csxf because of issue with JSF action
				// navigation
				// TODO find a resolution for this.


		http.authorizeRequests().antMatchers("/javax.faces.resource/**").permitAll().antMatchers("/ui/**").authenticated();
	}

	@Override
	@Bean // Need to specify as a spring bean to retrieve during LoginForm.login
			// action
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	// @Bean
	// public PasswordEncoder passwordEncoder() {
	// PasswordEncoder encoder = new BCryptPasswordEncoder();
	// return encoder;
	// }
}
