package com.indtexbr.consultoriasassessorias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude =  {DataSourceAutoConfiguration.class })
public class ConsultoriasassessoriasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultoriasassessoriasApplication.class, args);
	}

}
