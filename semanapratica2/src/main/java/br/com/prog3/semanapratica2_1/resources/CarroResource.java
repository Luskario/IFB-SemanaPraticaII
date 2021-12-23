package br.com.prog3.semanapratica2_1.resources;
import br.com.prog3.semanapratica2_1.domain.*;
import br.com.prog3.semanapratica2_1.service.CarroService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carros")
@Repository
public class CarroResource {

	@Autowired
	private CarroService carroService;
	
	@PostMapping
	public Carro save(@RequestBody Carro carro){
		return carroService.save(carro);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Carro>> findAll(){
		List<Carro> cursos = carroService.findAll();
		if(cursos == null || cursos.isEmpty()) {
			return new ResponseEntity<List<Carro>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Carro>>(cursos, HttpStatus.OK);
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<?> findById(@PathVariable String id){
		return carroService.findById(id).map(record -> ResponseEntity.ok().body(record)).orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Carro> update(@PathVariable("id") String id,@RequestBody Carro carro) {
		return carroService.findById(id).map(record -> {
			record.setCor(carro.getCor());
			record.setAno(carro.getAno());
			record.setAnoModelo(carro.getAnoModelo());
			record.setMarca(carro.getMarca());
			record.setModelo(carro.getModelo());
			record.setCliente(carro.getCliente());
			record.setOficina(carro.getOficina());
			Carro updated = carroService.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity<?> delete(@PathVariable String id) {
		return carroService.findById(id).map(record -> {
			carroService.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
}
