package persistencia.dto;

import java.time.LocalDateTime;


public class ClienteDTO {
	private String dni;
	private String nombreyApellidos;
	private String direccion;
	private String poblacion;
	private String codPostal;
	private LocalDateTime fechaCarnetConducir;
	private String digitosTC;
	private int mesTC;
	private int añoTC;
	private int cvcTC;
	private String tipoTC;
	
	public ClienteDTO(String dni, String nombreyApellidos,
			String direccion, String poblacion, String codPostal,
			LocalDateTime fechaCanetConducir, String digitosTC, int mesTC,
			int añoTC, int cvcTC, String tipoTC) {
		setDni(dni);
		setNombreyApellidos(nombreyApellidos);
		setDireccion(direccion);
		setPoblacion(poblacion);
		setCodPostal(codPostal);
		setFechaCarnetConducir(fechaCanetConducir);
		setDigitosTC(digitosTC);
		setMesTC(mesTC);
		setAñoTC(añoTC);
		setCvcTC(cvcTC);
		setTipoTC(tipoTC);
	}

	public String getDni() {
		return dni;
	}
	public void setIdentificador(String dni) {
		this.dni = dni;
	}
	public String getNombreyApellidos() {
		return nombreyApellidos;
	}
	public void setNombreyApellidos(String nombreyApellidos) {
		this.nombreyApellidos = nombreyApellidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCodPostal() {
		return codPostal;
	}
	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}
	public LocalDateTime getFechaCanetConducir() {
		return fechaCarnetConducir;
	}
	public void setFechaCarnetConducir(LocalDateTime fechaCanetConducir) {
		this.fechaCarnetConducir = fechaCanetConducir;
	}
	public String getDigitosTC() {
		return digitosTC;
	}
	public void setDigitosTC(String digitosTC) {
		this.digitosTC = digitosTC;
	}
	public int getMesTC() {
		return mesTC;
	}
	public void setMesTC(int mesTC) {
		this.mesTC = mesTC;
	}
	public int getAñoTC() {
		return añoTC;
	}
	public void setAñoTC(int añoTC) {
		this.añoTC = añoTC;
	}
	public int getCvcTC() {
		return cvcTC;
	}
	public void setCvcTC(int cvcTC) {
		this.cvcTC = cvcTC;
	}
	public String getTipoTC() {
		return tipoTC;
	}
	public void setTipoTC(String tipoTC) {
		this.tipoTC = tipoTC;
	}
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
}