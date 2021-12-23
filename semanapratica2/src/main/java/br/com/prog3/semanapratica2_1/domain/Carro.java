package br.com.prog3.semanapratica2_1.domain;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Carro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String placa;
	private String cor;
	private Integer ano;
	private Integer anoModelo;
	private String marca;
	private String modelo;
	private Cliente cliente;
	private Oficina oficina;
	
	public Carro(String placa, String cor, Integer ano, Integer anoModelo, String marca, 
				 String modelo, Cliente cliente, Oficina oficina) {
		
		this.placa = placa;
		this.cor = cor;
		this.ano = ano;
		this.anoModelo = anoModelo;
		this.marca = marca;
		this.modelo = modelo;
		this.cliente = cliente;
		this.oficina = oficina;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getPlaca() {
		return this.placa;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getCor() {
		return this.cor;
	}
	
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public Integer getAno() {
		return this.ano;
	}
	
	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}
	public Integer getAnoModelo() {
		return this.anoModelo;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getMarca() {
		return this.marca;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getModelo() {
		return this.modelo;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Cliente getCliente() {
		return this.cliente;
	}
	
	public void setOficina(Oficina oficina) {
		this.oficina = oficina;
	}
	public Oficina getOficina() {
		return this.oficina;
	}
	
}
