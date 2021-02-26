package com.formacionbdi.microservicios.app.cursos.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionbdi.microservicios.app.cursos.clients.AlumnoFeignClient;
import com.formacionbdi.microservicios.app.cursos.clients.RespuestaFeignClient;
import com.formacionbdi.microservicios.app.cursos.models.entity.Curso;
import com.formacionbdi.microservicios.app.cursos.models.repository.CursoRepository;
import com.formacionbdi.microservicios.generic.alumnos.models.entity.Alumno;
import com.formacionbdi.microservicios.generic.services.GenericServiceImpl;

@Service
public class CursoServiceImpl extends GenericServiceImpl<Curso, CursoRepository> implements CursoService {
	
	@Autowired
	private RespuestaFeignClient client;
	
	@Autowired
	private AlumnoFeignClient clienteAlumno; 
	
	@Override
	@Transactional(readOnly = true)
	public Curso findCursoByAlumnoId(Long id) {
		return repository.findCursoByAlumnoId(id);
	}

	@Override
	public Iterable<Long> obtenerExamenesIdsConRespuestaAlumno(Long alumnoId) {
		return client.obtenerExamenesIdsConRespuestaAlumno(alumnoId);
	}

	@Override
	public Iterable<Alumno> obtenerAlumnosPorCurso(List<Long> ids) {
		return clienteAlumno.obtenerAlumnosPorCurso(ids);
	}

	@Override
	@Transactional
	public void eliminarCursoAlumnoPorId(Long id) {
		repository.eliminarCursoAlumnoPorId(id);
	}

	

	}


