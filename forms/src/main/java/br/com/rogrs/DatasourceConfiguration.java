package br.com.rogrs;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

public class DatasourceConfiguration {
	
	
	@Bean(destroyMethod="")
	@Primary
	@ConfigurationProperties(prefix="app.datasource.primary")
	public DataSource dataSource() throws Exception {
	    JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
	    return dataSourceLookup.getDataSource("java:comp/env/jdbc/YourDS");
	}

}
