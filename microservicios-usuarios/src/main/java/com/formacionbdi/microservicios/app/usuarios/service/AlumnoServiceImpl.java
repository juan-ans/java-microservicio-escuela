package com.formacionbdi.microservicios.app.usuarios.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionbdi.microservicios.app.usuarios.client.CursoFeignClient;
import com.formacionbdi.microservicios.app.usuarios.models.repository.AlumnoRepository;
import com.formacionbdi.microservicios.generic.alumnos.models.entity.Alumno;
import com.formacionbdi.microservicios.generic.services.GenericServiceImpl;


@Service
public class AlumnoServiceImpl extends GenericServiceImpl<Alumno, AlumnoRepository> implements AlumnoService {
	
	@Autowired
	private CursoFeignClient clienteCurso;
	
	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findByNombreOrApellido(String term) {
		
		return repository.findByNombreOrApellido(term);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Alumno> findAllById(Iterable<Long> ids) {
		return repository.findAllById(null);
	}

	@Override
	public void eliminarCursoAlumnoPorId(Long id) {
		clienteCurso.eliminarCursoAlumnoPorId(id);		
	}
	
	@Override
	@Transactional
	public void deleteById(Long id) {
		super.deleteById(id);
		this.eliminarCursoAlumnoPorId(id);
	}
	
	

}