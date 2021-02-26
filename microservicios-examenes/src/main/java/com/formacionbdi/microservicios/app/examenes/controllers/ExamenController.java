package com.formacionbdi.microservicios.app.examenes.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.microservicios.app.examenes.services.ExamenService;
import com.formacionbdi.microservicios.generic.controllers.GenericController;
import com.formacionbdi.microservicios.generic.examenes.models.entity.Examen;
import com.formacionbdi.microservicios.generic.examenes.models.entity.Pregunta;

@RestController
public class ExamenController extends GenericController<Examen, ExamenService>{
	
	
	
	
	

	public ResponseEntity<?> editar(@Valid @RequestBody Examen examen,BindingResult result, @PathVariable Long id){
		if(result.hasErrors()) {
			return this.validar(result);
		}
		Optional<Examen> o= service.findById(id);
		
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Examen examenDb = o.get();
		examenDb.setNombre(examen.getNombre());
		
		/*
		 examenDb.getPreguntas()
		 .stream()
		 .filter(pdb -> !examen.getPreguntas().contains(pdb))
		 .forEach(examenDb::removePreguntas);
		 */
		
		
		List<Pregunta> eliminadas = new ArrayList<>();
		
		examenDb.getPreguntas().forEach(pdb ->{
			if(!examen.getPreguntas().contains(pdb)) {
				eliminadas.add(pdb);
			}
		});
		
		eliminadas.forEach(p -> {
			examenDb.removePregunta(p);
		});
		
		examenDb.setPreguntas(examen.getPreguntas());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(examenDb));
		
	}
	
	@GetMapping("/filtrar/{term}")
	public ResponseEntity<?> filtrar(@PathVariable String term){
		return ResponseEntity.ok(service.findByNombre(term));
	}
	
	/* Se crea este listar asignatura en este controlador examen
	por que es un solo un metodo de ser un crud se crea una
	clase controlodador asignatura aparte */
	@GetMapping("/asignaturas")
	public ResponseEntity<?> listarAsignaturas(){
		return ResponseEntity.ok(service.findAllAsignatura());
	}
	
}
