package com2.pat.p4pat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com2.pat.p4pat.controler","com2.pat.p4pat.domain","com2.pat.p4pat.services","com2.pat.p4pat.actuator"})
public class P4patApplication {

	private static Logger log = LoggerFactory.getLogger(P4patApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(P4patApplication.class, args);
		log.info("La aplicación ha iniciado correctamente.");
	}
}
