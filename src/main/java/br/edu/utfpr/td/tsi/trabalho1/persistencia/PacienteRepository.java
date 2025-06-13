package br.edu.utfpr.td.tsi.trabalho1.persistencia;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.edu.utfpr.td.tsi.trabalho1.modelo.Paciente;

public interface PacienteRepository extends MongoRepository<Paciente, String> {

	public Paciente findByCpf(String cpf);

}
