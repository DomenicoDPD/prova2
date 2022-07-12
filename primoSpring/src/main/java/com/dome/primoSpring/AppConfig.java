package com.dome.primoSpring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.dome.beans.GetFormazione;
import com.dome.oggetti.FormazioniDto;
import com.dome.services.FormazioniService;

import net.sf.log4jdbc.sql.jdbcapi.DataSourceSpy;

@Configuration
@EnableAutoConfiguration
public class AppConfig {
	@Autowired
	DataSourceProperties dataSourceProperties;
	@Autowired
	JdbcTemplate namedParameterJdbcTemplate;

	@Bean
	public DataSource mysqlDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://Localhost:3306/formazioni_fanta");
		dataSource.setUsername("root");
		dataSource.setPassword(null);

		return dataSource;
	}

	@Bean
	@Primary
	public DataSource dataSource() {
		return new DataSourceSpy(mysqlDataSource());
	}

	@Bean
	public GetFormazione get() {
		return new GetFormazione();
	}

	@Bean
	public FormazioniService forma() {
		return new FormazioniService();
	}

	@Bean
	FormazioniDto formazioniDto() {
		return new FormazioniDto();
	}
}