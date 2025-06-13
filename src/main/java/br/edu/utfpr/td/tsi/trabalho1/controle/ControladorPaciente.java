package br.edu.utfpr.td.tsi.trabalho1.controle;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.mongodb.DuplicateKeyException;

import br.edu.utfpr.td.tsi.trabalho1.modelo.Paciente;
import br.edu.utfpr.td.tsi.trabalho1.persistencia.PacienteRepository;
import br.edu.utfpr.td.tsi.trabalho1.service.PacienteService;

@Controller
public class ControladorPaciente {
	@Autowired
	private PacienteService pacienteService;

	@GetMapping(value="/cadastrar-paciente")
	public String exibirPaginaCadastro(Paciente paciente) {
		return "cadastrar-paciente";
	}
	
	@PostMapping(value="/cadastrar-paciente")
	public String cadastrarPaciente(@Valid Paciente paciente, BindingResult bindingResult, Model modelo) {
		if (bindingResult.hasErrors()) {
			return "cadastrar-paciente";
		} 

		paciente.setNumeroTelefone(paciente.getNumeroTelefone().replaceAll("[\\D]", ""));
		paciente.setCpf(paciente.getCpf().replaceAll("[\\D]", ""));
		paciente.getEndereco().setCep(paciente.getEndereco().getCep().replaceAll("[\\D]", ""));
		
		pacienteService.cadastrar(paciente);

		return "redirect:exibir-pacientes";
	}

	@GetMapping(value="exibir-pacientes")
	public String exibirPacientesCadastrados(Model modelo) {
		List<Paciente> pacientes = pacienteService.listarTodos();
		modelo.addAttribute("pacientes", pacientes);
		return "exibir-pacientes";
	}

	@PostMapping(value="exibir-pacientes")
	public String exibirPacienteCpf(@RequestParam String cpf ,Model modelo) {
		cpf = cpf.replaceAll("[\\D]", "");

		Paciente paciente = pacienteService.listarPeloCpf(cpf);
		modelo.addAttribute("pacientes", paciente);
		return "exibir-pacientes";
	}
	
	@GetMapping(value="deletar-paciente")
	public String deletarPaciente(@RequestParam String id) {
		pacienteService.deletar(id);
		return "redirect:exibir-pacientes";
	}

	@GetMapping(value="/editar-paciente")
	public String exibirPaginaEditar(@RequestParam String id, Model modelo) {
		Paciente paciente = pacienteService.encontrarPeloId(id);
		modelo.addAttribute("paciente", paciente);
		return "editar-paciente";
	}
	
	@PostMapping(value="/editar-paciente")
	public String editarPaciente(@Valid Paciente paciente, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "editar-paciente";
		} 

		paciente.setNumeroTelefone(paciente.getNumeroTelefone().replaceAll("[\\D]", ""));
		paciente.setCpf(paciente.getCpf().replaceAll("[\\D]", ""));
		paciente.getEndereco().setCep(paciente.getEndereco().getCep().replaceAll("[\\D]", ""));

		pacienteService.cadastrar(paciente);

		return "redirect:exibir-pacientes";
	}

}
