package br.com.prog3.semanapratica2_1.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.prog3.semanapratica2_1.domain.Cliente;
import br.com.prog3.semanapratica2_1.repository.ClienteRepository;

public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	public List<Cliente> findAll(){
		return (List<Cliente>) clienteRepository.findAll();
	}
	public Optional<Cliente> findById(String id) {
		return clienteRepository.findById(id);
	}
	public Cliente update(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	public void deleteById(String id) {
		clienteRepository.deleteById(id);
	}
}
