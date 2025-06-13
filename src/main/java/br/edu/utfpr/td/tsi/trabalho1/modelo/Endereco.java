package br.edu.utfpr.td.tsi.trabalho1.modelo;

import javax.validation.constraints.NotBlank;

public class Endereco {
	@NotBlank(message = "Logradouro não pode ser nulo")
	private String logradouro;

	@NotBlank(message = "Número não pode ser nulo")
	private String numero;

	@NotBlank(message = "CEP não pode ser nulo")
	private String cep;

	@NotBlank(message = "Bairro não pode ser nulo")
	private String bairro;
	
	public Endereco() {}

	public Endereco(String logradouro, String numero, String cep, String bairro) {
		super();
		this.logradouro = logradouro;
		this.numero = numero;
		this.cep = cep;
		this.bairro = bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
}
