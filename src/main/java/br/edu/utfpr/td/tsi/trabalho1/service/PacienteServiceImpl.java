package br.edu.utfpr.td.tsi.trabalho1.service;

import java.util.List;

import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import br.edu.utfpr.td.tsi.trabalho1.modelo.Paciente;
import br.edu.utfpr.td.tsi.trabalho1.persistencia.PacienteRepository;

@Service
public class PacienteServiceImpl implements PacienteService {
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Override
	public void cadastrar(Paciente paciente) {
		pacienteRepository.save(paciente);
	}

	@Override
	public void deletar(String id) {
		pacienteRepository.deleteById(id);
	}

	@Override
	public List<Paciente> listarTodos() {
		return pacienteRepository.findAll();
	}

	@Override
	public Paciente encontrarPeloId(String id) {
		Paciente paciente = pacienteRepository.findById(id).orElse(null);
		return paciente;
	}

	@Override
	public Paciente listarPeloCpf(String cpf) {
		Paciente paciente = pacienteRepository.findByCpf(cpf);
		return paciente;
	}

}
