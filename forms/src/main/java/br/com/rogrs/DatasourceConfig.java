package br.com.rogrs;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@EnableConfigurationProperties
public class DatasourceConfig {

	private final Logger log = LoggerFactory.getLogger(DatasourceConfig.class);

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "app.datasource.primary")
	public DataSource primaryDataSource() {
		log.debug("Configuring Datasource Primary");
		return DataSourceBuilder.create().build();
	}

	@Bean
	@ConfigurationProperties(prefix = "app.datasource.log")
	public DataSource secondaryDataSource() {
		log.debug("Configuring Datasource Log");
		return DataSourceBuilder.create().build();
	}

}
