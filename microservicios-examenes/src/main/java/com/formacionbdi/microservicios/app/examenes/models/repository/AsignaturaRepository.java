package com.formacionbdi.microservicios.app.examenes.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.formacionbdi.microservicios.generic.examenes.models.entity.Asignatura;

public interface AsignaturaRepository extends PagingAndSortingRepository<Asignatura, Long>{

}
