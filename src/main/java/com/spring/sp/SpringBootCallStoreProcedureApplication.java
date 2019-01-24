package com.spring.sp;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class SpringBootCallStoreProcedureApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootCallStoreProcedureApplication.class, args);
	}

	@ConfigurationProperties(prefix="spring.datasource")
	@Bean
	@Qualifier("data_mysql")
	public DataSource getDataSource() {
		return DataSourceBuilder
				.create()
				.build();
	}
}
