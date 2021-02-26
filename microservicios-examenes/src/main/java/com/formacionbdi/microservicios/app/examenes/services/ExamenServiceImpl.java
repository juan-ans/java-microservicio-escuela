package com.formacionbdi.microservicios.app.examenes.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionbdi.microservicios.app.examenes.models.repository.AsignaturaRepository;
import com.formacionbdi.microservicios.app.examenes.models.repository.ExamenRepository;
import com.formacionbdi.microservicios.generic.examenes.models.entity.Asignatura;
import com.formacionbdi.microservicios.generic.examenes.models.entity.Examen;
import com.formacionbdi.microservicios.generic.services.GenericServiceImpl;


@Service
public class ExamenServiceImpl extends GenericServiceImpl<Examen, ExamenRepository> implements ExamenService {
	
	@Autowired
	private AsignaturaRepository asignaturaRepository; 
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Examen> findByNombre(String term){
		return repository.findByNombre(term);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Asignatura> findAllAsignatura() {
		return asignaturaRepository.findAll();
	}

	@Override
	public Iterable<Long> findExamenesIdsConRespuestasByPreguntaIds(Iterable<Long> preguntaIds) {
		return repository.findExamenesIdsConRespuestasByPreguntaIds(preguntaIds);
	}


}
