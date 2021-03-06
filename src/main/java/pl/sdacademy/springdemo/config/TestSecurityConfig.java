package pl.sdacademy.springdemo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Profile("test")
public class TestSecurityConfig extends WebSecurityConfigurerAdapter {

	private static final Logger LOG = LoggerFactory.getLogger(TestSecurityConfig.class);

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		LOG.info("autoryzacja wyłączona!!");
		http
				.csrf().disable();
	}
}
