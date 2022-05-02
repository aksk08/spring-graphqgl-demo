package pl.sdacademy.springdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Profile("!test")
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
				.authorizeRequests()
				.antMatchers("/api/**").authenticated()
				.anyRequest().permitAll()
				.and()
				.formLogin()
				.and()
				.logout()
				.and()
				.csrf().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
				.withUser("user").password("$2y$12$5aonXhMiNv9DuVyDjG3Rye4F91arHqOD4CqgdfFNm3iEOVPM9NUuC").roles("READ")
				.and()
				.withUser("pl-user").password("$2y$12$5aonXhMiNv9DuVyDjG3Rye4F91arHqOD4CqgdfFNm3iEOVPM9NUuC").roles("PL");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
