package com.curso.suporteos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.curso")
@EntityScan(basePackages = "com.curso.domains")
@EnableJpaRepositories(basePackages = "com.curso.repositories")
@SpringBootApplication
public class SuporteosApplication {
//problemas com versão do java na maquina do laboratorio
	public static void main(String[] args) {
		SpringApplication.run(SuporteosApplication.class, args);
	}

}
