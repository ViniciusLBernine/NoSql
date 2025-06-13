package br.edu.utfpr.td.tsi.trabalho1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({ "file:./application.properties" })
public class Main {
	public static void main(String[] args) {
		System.setProperty("server.serverlet.context-path", "/meu-posto-saude");
		SpringApplication.run(Main.class, args);
	}
}
