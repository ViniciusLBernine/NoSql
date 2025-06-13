package br.edu.utfpr.td.tsi.trabalho1.controle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controladorindex {
	
	@GetMapping(value="/")
	public String exibirPaginaPrincipal() {
		return "index";
	}
	
}
