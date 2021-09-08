package com.examenPractico.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "clientes")
public class Clientes {
	//private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cliente_ID")
	private Integer Cliente_ID;
	@Column (name = "Nombre_Usuario", length = 150)
	private String Nombre_Usuario;
	@Column (name = "Contrasena", length = 150)
	private String Contrasena;
	@Column (name = "Nombre", length = 150)
	private String Nombre;
	@Column (name = "Apellidos", length = 150)
	private String Apellidos;
	@Column (name = "Correo_Electronico", length = 150)
	private String Correo_Electronico;
	@Column (name = "Edad")
	private Integer Edad;
	@Column (name = "Estatura")
	private Float Estatura;
	@Column (name = "Peso")
	private Float Peso;
	@Column (name = "IMC")
	private Float IMC;
	@Column (name = "GEB")
	private Float GEB;
	@Column (name = "ETA")
	private Float ETA;
	@Column (name = "Fecha_Creacion")
	private Date Fecha_Creacion;
	@Column (name = "Fecha_Actualizacion")
	private Date Fecha_Actualizacion;
	public Clientes() {}
	public Clientes(String nombre_Usuario, String contrasena, String nombre, String apellidos,
			String correo_Electronico) {
		Nombre_Usuario = nombre_Usuario;
		Contrasena = contrasena;
		Nombre = nombre;
		Apellidos = apellidos;
		Correo_Electronico = correo_Electronico;
	}
	public Clientes(String nombre_Usuario, String contrasena, String nombre, String apellidos,
			String correo_Electronico, Integer edad, Float estatura, Float peso, Float iMC, Float gEB, Float eTA,
			Date fecha_Creacion, Date fecha_Actualizacion) {
		super();
		Nombre_Usuario = nombre_Usuario;
		Contrasena = contrasena;
		Nombre = nombre;
		Apellidos = apellidos;
		Correo_Electronico = correo_Electronico;
		Edad = edad;
		Estatura = estatura;
		Peso = peso;
		IMC = iMC;
		GEB = gEB;
		ETA = eTA;
		Fecha_Creacion = fecha_Creacion;
		Fecha_Actualizacion = fecha_Actualizacion;
	}
	public String getNombre_Usuario() {
		return Nombre_Usuario;
	}
	public void setNombre_Usuario(String nombre_Usuario) {
		Nombre_Usuario = nombre_Usuario;
	}
	public String getContrasena() {
		return Contrasena;
	}
	public void setContrasena(String contrasena) {
		Contrasena = contrasena;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}
	public String getCorreo_Electronico() {
		return Correo_Electronico;
	}
	public void setCorreo_Electronico(String correo_Electronico) {
		Correo_Electronico = correo_Electronico;
	}
	public Integer getEdad() {
		return Edad;
	}
	public void setEdad(Integer edad) {
		Edad = edad;
	}
	public Float getEstatura() {
		return Estatura;
	}
	public void setEstatura(Float estatura) {
		Estatura = estatura;
	}
	public Float getPeso() {
		return Peso;
	}
	public void setPeso(Float peso) {
		Peso = peso;
	}
	public Float getIMC() {
		return IMC;
	}
	public void setIMC(Float iMC) {
		IMC = iMC;
	}
	public Float getGEB() {
		return GEB;
	}
	public void setGEB(Float gEB) {
		GEB = gEB;
	}
	public Float getETA() {
		return ETA;
	}
	public void setETA(Float eTA) {
		ETA = eTA;
	}
	public Date getFecha_Creacion() {
		return Fecha_Creacion;
	}
	public void setFecha_Creacion(Date fecha_Creacion) {
		Fecha_Creacion = fecha_Creacion;
	}
	public Date getFecha_Actualizacion() {
		return Fecha_Actualizacion;
	}
	public void setFecha_Actualizacion(Date fecha_Actualizacion) {
		Fecha_Actualizacion = fecha_Actualizacion;
	}
}
