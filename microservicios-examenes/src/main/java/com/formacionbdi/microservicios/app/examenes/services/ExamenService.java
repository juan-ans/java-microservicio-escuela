package com.formacionbdi.microservicios.app.examenes.services;

import java.util.List;

import com.formacionbdi.microservicios.generic.examenes.models.entity.Asignatura;
import com.formacionbdi.microservicios.generic.examenes.models.entity.Examen;
import com.formacionbdi.microservicios.generic.services.GenericService;

public interface ExamenService extends GenericService<Examen>{
	public List<Examen> findByNombre(String term);
	
	public Iterable<Asignatura> findAllAsignatura();
	
	public Iterable<Long> findExamenesIdsConRespuestasByPreguntaIds(Iterable<Long> preguntaIds); 
}
