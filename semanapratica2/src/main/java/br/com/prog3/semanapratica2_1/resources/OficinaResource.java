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

import br.com.prog3.semanapratica2_1.domain.Oficina;
import br.com.prog3.semanapratica2_1.service.OficinaService;

@RestController
@RequestMapping("/oficinas")
public class OficinaResource {

	@Autowired
	private OficinaService oficinaService;
	
	@GetMapping
	public ResponseEntity<List<Oficina>> findAll(){
		List<Oficina> clientes = oficinaService.findAll();
		if(clientes == null || clientes.isEmpty()) {
			return new ResponseEntity<List<Oficina>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Oficina>>(clientes, HttpStatus.OK);
	}
	
	@PostMapping
	public Oficina create(@RequestBody Oficina oficina){
	return oficinaService.save(oficina);
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<?> findById(@PathVariable Integer id){
	return oficinaService.findById(id)
	.map(record -> ResponseEntity.ok().body(record))
	.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Oficina> update(@PathVariable("id") Integer id, @RequestBody Oficina oficina) {
		return oficinaService.findById(id)
				.map(record -> {
				record.setNome(oficina.getNome());
				record.setEspecialidade(oficina.getEspecialidade());
				record.setEndereco(oficina.getEndereco());
				record.setCarros(oficina.getCarros());
				Oficina updated = oficinaService.save(record);
				return ResponseEntity.ok().body(updated);
			}).orElse(ResponseEntity.notFound().build());
		}
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		return oficinaService.findById(id).map(record -> {
					oficinaService.deleteById(id);
					return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
	
}
