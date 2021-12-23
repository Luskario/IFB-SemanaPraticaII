package br.com.prog3.semanapratica2_1.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Oficina {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	private String nome;
	private String especialidade;
	private String endereco;
	@ManyToOne
	@JoinColumn(name = "placa_carro", nullable = true, updatable = true)
	private List<Carro> carros;
	
	public Oficina(Integer codigo, String nome, String especialidade, String endereco, List <Carro> carros) {
		this.codigo = codigo;
		this.nome = nome;
		this.especialidade = especialidade;
		this.endereco = endereco;
		this.carros = carros;
	}
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Integer getCodigo() {
		return this.codigo;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return this.nome;
	}
	
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	public String getEspecialidade() {
		return this.especialidade;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEndereco() {
		return this.endereco;
	}
	
	public void setCarros(List<Carro> carros) {
		this.carros =carros;
	}
	public List<Carro> getCarros() {
		return this.carros;
	}

}
