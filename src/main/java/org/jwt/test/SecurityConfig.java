package org.jwt.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

 	@Bean
 	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception   {
 		
 		return http.authorizeHttpRequests(registry -> {
 			
 			registry.requestMatchers("/getOrder/admin").hasRole("ADMIN"); 
 			registry.requestMatchers("/getOrder/home").permitAll();
 			registry.anyRequest().authenticated();
 		}).formLogin(formlogin -> formlogin.permitAll()) 
 				.build();
  	}
 	
 	
 	@Bean 
 	public UserDetailsService userDetailsService() { 
 		
 		UserDetails adminUser = User.builder()
 				.username("admin")
 				.password("$2a$12$B9rnGlsvwKHPXyl8FWLrYe0eey/etjG/vd84oODs7h.ZO53XFyjWG")//9876
 				.roles("ADMIN")
 				.build();
 		
 		return new InMemoryUserDetailsManager(adminUser);
 		 
 	}
 	
 	@Bean
 	public PasswordEncoder passwordEncoder() {
 		return new BCryptPasswordEncoder();
 	}
 	  
}
