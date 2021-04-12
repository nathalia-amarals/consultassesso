package com.indtexbr.consultoriasassessorias;

import com.indtexbr.consultoriasassessorias.repository.ContratoRepository;
import com.indtexbr.consultoriasassessorias.repository.EmpresaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication//(exclude =  {DataSourceAutoConfiguration.class })
@EnableMongoRepositories(basePackageClasses = {ContratoRepository.class, EmpresaRepository.class})
public class ConsultoriasassessoriasApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ConsultoriasassessoriasApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ConsultoriasassessoriasApplication.class);
	}
}
