package com.sistema.api.configuracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.sistema.api.seguridad.CustomUserDetailsService;
import com.sistema.api.seguridad.JwtAuthenticationEntryPoint;
import com.sistema.api.seguridad.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	@Bean
	public JwtAuthenticationFilter jwtAuthenticationFilter() {
		return new JwtAuthenticationFilter();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		extraConfig(http)
		    .authorizeRequests().antMatchers( HttpMethod.GET,"/api/**").permitAll()
		    .antMatchers(HttpMethod.POST, "/api/auth/**").permitAll()
		    .antMatchers("/api/getion/telefonia/**").permitAll()
		    .antMatchers("/api/getion/clientes/**").permitAll()
		    .antMatchers("/api/getion/usuarios/**").permitAll()
		    .antMatchers("/api/auth/**","/v2/api-docs",  "/configuration/**", "/swagger*/**", "/webjars/**").permitAll()
		    .anyRequest()
		    .authenticated()
		    .and()
		    .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
		    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		    
		    ;
		http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}

	@SuppressWarnings("all")
	private HttpSecurity extraConfig(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.csrf().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
