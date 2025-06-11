package com.bolsadeideas.springboot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.bolsadeideas.springboot.app.auth.handler.LoginSuccessHandler;
import com.bolsadeideas.springboot.app.models.service.JpaUserDetailService;

@EnableGlobalMethodSecurity(securedEnabled=true, prePostEnabled=true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private LoginSuccessHandler sucessHandler;
	
	@Autowired
	private JpaUserDetailService userDetailService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// publico uso de antMatchers
		http.authorizeRequests().antMatchers("/", "/css/**", "/js/**", "/images/**","/listar").permitAll()
				 //privados en base a roles
				.anyRequest().authenticated()
				.and()
					.formLogin()
					.successHandler(sucessHandler)
						.loginPage("/login")
				.permitAll()
				.and()
				.logout()
				.permitAll()
				.and()
				.exceptionHandling().accessDeniedPage("/error_403");

	}
	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception{
		//JPA
		build.userDetailsService(userDetailService)
		.passwordEncoder(passwordEncoder);
		
	}


}
