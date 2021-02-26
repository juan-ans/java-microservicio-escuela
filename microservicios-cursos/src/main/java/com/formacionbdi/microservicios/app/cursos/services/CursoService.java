package com.formacionbdi.microservicios.app.cursos.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.formacionbdi.microservicios.app.cursos.models.entity.Curso;
import com.formacionbdi.microservicios.generic.alumnos.models.entity.Alumno;
import com.formacionbdi.microservicios.generic.services.GenericService;

public interface CursoService extends GenericService<Curso> {

	
	public Curso findCursoByAlumnoId(Long id);
	
	public Iterable<Long> obtenerExamenesIdsConRespuestaAlumno(Long alumnoId);
	
	public Iterable<Alumno> obtenerAlumnosPorCurso(List<Long> ids);
	
	public void eliminarCursoAlumnoPorId(Long id);
	
}
