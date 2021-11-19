package model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Persona")

public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator="con_personas")// Genera un autoincremento en el id con el tipo de dato long
	
	@Column
	private long id_persona;
	
	
	@Column
	private String Nombre;
	
	@Column(name ="Ap_Pat")
	private String Ap_Pat;
	
	@Column(name = "Ap_Mat")
	private String Ap_Mat;
	
	@Column(name ="Edad")
	private Integer Edad;
	
	@Column(name ="Peso")
	private Float Peso;
	
	@Column(name ="Estatura")
	private Float Estatura;
	
	@Column(name ="Estado_civil")
	private String Estado_civil;
	
	

	public long getId_persona() {
		return id_persona;
	}

	public void setId_persona(long id_persona) {
		this.id_persona = id_persona;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getAp_Pat() {
		return Ap_Pat;
	}

	public void setAp_Pat(String ap_Pat) {
		Ap_Pat = ap_Pat;
	}

	public String getAp_Mat() {
		return Ap_Mat;
	}

	public void setAp_Mat(String ap_Mat) {
		Ap_Mat = ap_Mat;
	}

	public Integer getEdad() {
		return Edad;
	}

	public void setEdad(Integer edad) {
		Edad = edad;
	}

	public Float getPeso() {
		return Peso;
	}

	public void setPeso(Float peso) {
		Peso = peso;
	}

	public Float getEstatura() {
		return Estatura;
	}

	public void setEstatura(Float estatura) {
		Estatura = estatura;
	}

	public String getEstado_civil() {
		return Estado_civil;
	}

	public void setEstado_civil(String estado_civil) {
		Estado_civil = estado_civil;
	}

	public Persona(String nombre, String ap_Pat, String ap_Mat, Integer edad, Float peso,
			Float estatura, String estado_civil) {
		super();
		this.id_persona = id_persona;
		Nombre = nombre;
		Ap_Pat = ap_Pat;
		Ap_Mat = ap_Mat;
		Edad = edad;
		Peso = peso;
		Estatura = estatura;
		Estado_civil = estado_civil;
	}

	
	
	
}
