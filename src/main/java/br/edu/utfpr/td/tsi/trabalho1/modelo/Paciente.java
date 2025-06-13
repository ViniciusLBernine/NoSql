package br.edu.utfpr.td.tsi.trabalho1.modelo;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.UniqueElements;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.mongodb.lang.NonNull;

import br.edu.utfpr.td.tsi.trabalho1.constraint.validator.CpfUnico;

@Document
public class Paciente {
	@Id
	private String id;

	@NotBlank(message = "Nome não pode ser nulo")
	private String nome;

	@NotBlank(message = "Sobrenome não pode ser nulo")
	private String sobrenome;

	@NotBlank(message = "Número de telefone não pode ser nulo")
	private String numeroTelefone;

	@CpfUnico
	@CPF(message = "CPF inválido")
	private String cpf;

	@NotNull(message = "Data de nascimento não pode ser nulo")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento;

	@Valid
	private Endereco endereco;
	
	public Paciente() {}

	public Paciente(String id, String nome, String sobrenome, String numeroTelefone, String cpf, LocalDate dataNascimento, Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.numeroTelefone = numeroTelefone;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
