package br.com.prog3.semanapratica2_1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prog3.semanapratica2_1.domain.*;
import br.com.prog3.semanapratica2_1.repository.CarroRepository;

@Service
public class CarroService {

	@Autowired
	private CarroRepository carroRepository;
	
	public Carro save(Carro carro) {
		return carroRepository.save(carro);
		}
	
	public List<Carro> findAll(){
		return (List<Carro>) carroRepository.findAll();
	}
	public Optional<Carro> findById(String id) {
		return carroRepository.findById(id);
	}
	public Carro update(Carro carro) {
		return carroRepository.save(carro);
	}
	public void deleteById(String id) {
		carroRepository.deleteById(id);
	}
}
