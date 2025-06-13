package br.edu.utfpr.td.tsi.trabalho1.constraint.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.Null;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.utfpr.td.tsi.trabalho1.modelo.Paciente;
import br.edu.utfpr.td.tsi.trabalho1.persistencia.PacienteRepository;

public class CpfUnicoValidator implements ConstraintValidator<CpfUnico, String> {
	@Autowired 
	private PacienteRepository pacienteRepository;

	private CPFValidator cpfValidator = new CPFValidator();

	@Override
	public boolean isValid(String cpf, ConstraintValidatorContext context) {
		cpfValidator.initialize(null);
		if (!cpfValidator.isValid(cpf, context)) {
			return true;
		}

		if (cpf == null || cpf.isEmpty()) {
			return true;
		}
		
		if (pacienteRepository.findByCpf(cpf) == null) {
			return true;
		}
		
		String newCpf = cpf.replaceAll("[\\D]", "");
		return pacienteRepository.findByCpf(newCpf) == null;
	}

}
