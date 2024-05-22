package com.project.school.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class WebSecurityConfiguration {

	
	@SuppressWarnings("removal")
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception {
		return httpSecurity.csrf(customizer -> customizer.disable())
				.authorizeHttpRequests().requestMatchers("/authenticate").permitAll().anyRequest().authenticated()
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and().build();
	}
	
	
	
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception {
//		return httpSecurity.csrf(customizer -> customizer.disable())
//				.authorizeHttpRequests(request -> request.anyRequest().authenticated())
//				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//				.build();
//	}
//	
	
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception {
//				httpSecurity.csrf().disable()
//				.authorizeRequests()
//				.antMatchers("/authenticate").permitAll()
//				.antMatchers("/test").authenticated()
//				.and()
//				.sessionManagement()
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//				
//				return httpSecurity.build();
//	}
	
	
	
//	   @Bean
//	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//	        http.csrf(csrf -> csrf.disable())
//	                .authorizeRequests().
//	                requestMatchers("/test").authenticated().requestMatchers("/auth/login").permitAll()
//	                .anyRequest()
//	                .authenticated()
//	                .and().exceptionHandling(ex -> ex.authenticationEntryPoint(point))
//	                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//	        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
//	        return http.build();
//	    }
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration)throws Exception {
		return configuration.getAuthenticationManager();
		
	}
}
