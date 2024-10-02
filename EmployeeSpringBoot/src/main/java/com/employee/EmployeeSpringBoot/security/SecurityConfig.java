package com.employee.EmployeeSpringBoot.security;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private UserDetailsService employeeSecurityServiceImpl;

//	@Bean
//	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
//		UserDetails prasad = User.withUsername("prasad").password(encoder.encode("prasad")).roles("admin").build();
//		UserDetails root = User.withUsername("root").password(encoder.encode("root")).roles("user").build();
//		return new InMemoryUserDetailsManager(prasad, root);
////		return new EmployeeSecurityServiceImpl();
//	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(customizer -> {
			customizer.requestMatchers(antMatcher("/WEB-INF/views/**"), antMatcher("/index"),
					antMatcher("/employeeSignUpValidate"), antMatcher("/employeeLogin")).permitAll();
			customizer.requestMatchers(antMatcher("/employeeDeleteById"), antMatcher("/employeeUpdateById"),
					antMatcher("/viewEmployeeRequests")).hasAuthority("admin");

			customizer.anyRequest().authenticated();

		});
		http.httpBasic(Customizer.withDefaults());
		

		http.formLogin(form -> form.loginPage("/employeeLogin").loginProcessingUrl("/loginP").permitAll())
				.logout(logout -> logout.permitAll());
		 http.exceptionHandling(exceptionHandling -> 
         exceptionHandling.accessDeniedPage("/accessDenied") );
		http.csrf(csrf -> csrf.disable());
		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(employeeSecurityServiceImpl);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

}
