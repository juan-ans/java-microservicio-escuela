package com.formacionbdi.microservicios.app.respuestas.models.entity;





import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.formacionbdi.microservicios.generic.alumnos.models.entity.Alumno;
import com.formacionbdi.microservicios.generic.examenes.models.entity.Pregunta;

@Document(collection = "respuestas")
public class Respuesta {
	
	@Id
	private String id;
	
	private String texto;
	
	
	//muchas respuestas un alumno
	//@ManyToOne(fetch = FetchType.LAZY)
	@Transient
	private Alumno alumno;
	
	//@Column(name="alumno_id")
	private Long alumnoId;
	
	//una Respuesta una Pregunta
	//@OneToOne(fetch = FetchType.LAZY)
	@Transient
	private Pregunta pregunta;
	
	private Long preguntaId;
	
	

	public Long getAlumnoId() {
		return alumnoId;
	}

	public void setAlumnoId(Long alumnoId) {
		this.alumnoId = alumnoId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public Long getPreguntaId() {
		return preguntaId;
	}

	public void setPreguntaId(Long preguntaId) {
		this.preguntaId = preguntaId;
	}
	
	
	
	
	
}
