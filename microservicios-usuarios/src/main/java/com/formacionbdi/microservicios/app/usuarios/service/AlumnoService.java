package com.formacionbdi.microservicios.app.usuarios.service;



import java.util.List;

import com.formacionbdi.microservicios.generic.alumnos.models.entity.Alumno;
import com.formacionbdi.microservicios.generic.services.GenericService;

public interface AlumnoService extends GenericService<Alumno>{
	
	public List<Alumno> findByNombreOrApellido(String term);
	
	public Iterable<Alumno> findAllById(Iterable<Long> ids);
	
	public void eliminarCursoAlumnoPorId(Long id);

}
