package br.com.prog3.semanapratica2_1.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.prog3.semanapratica2_1.domain.Cliente;
import br.com.prog3.semanapratica2_1.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll(){
		List<Cliente> clientes = clienteService.findAll();
		if(clientes == null || clientes.isEmpty()) {
			return new ResponseEntity<List<Cliente>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
	}
	
	@PostMapping
	public Cliente create(@RequestBody Cliente cliente){
	return clienteService.save(cliente);
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<?> findById(@PathVariable String id){
	return clienteService.findById(id)
	.map(record -> ResponseEntity.ok().body(record))
	.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Cliente> update(@PathVariable("id") String id, @RequestBody Cliente cliente) {
		return clienteService.findById(id)
				.map(record -> {
				record.setNome(cliente.getNome());
				record.setDataNascimento(cliente.getDataNascimento());
				record.setCarros(cliente.getCarros());
				Cliente updated = clienteService.save(record);
				return ResponseEntity.ok().body(updated);
			}).orElse(ResponseEntity.notFound().build());
		}
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity<?> delete(@PathVariable String id) {
		return clienteService.findById(id).map(record -> {
					clienteService.deleteById(id);
					return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
}
