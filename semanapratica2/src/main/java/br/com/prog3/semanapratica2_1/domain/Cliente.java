package br.com.prog3.semanapratica2_1.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String cpf;
	private String nome;
	private LocalDate dataNascimento;
	@ManyToOne
	@JoinColumn(name = "placa_carro", nullable = true, updatable = true)
	private List <Carro> carros;
	
	public Cliente(String cpf, String nome, LocalDate dataNascimento, List<Carro> carros) {
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.carros = carros;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCpf() {
		return this.cpf;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return this.nome;
	}
	
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public LocalDate getDataNascimento() {
		return this.dataNascimento;
	}
	
	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}
	public List<Carro> getCarros() {
		return this.carros;
	}
}
