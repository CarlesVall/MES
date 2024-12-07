package logica;

import java.time.LocalDateTime;


public class Cliente {

	private String dni;
	private String nombreyApellidos;
	private String direccion;
	private String poblacion;
	private String codPostal;
	private LocalDateTime fechaCarnetConducir;
	private String digitosTC;
	private int mesTC;
	private int anyoTC;
	private int cvcTC;
	private String tipoTC;
	public Cliente(String dni, String nombreyApellidos, String direccion, String poblacion, String codPostal, LocalDateTime fechaCarnetConducir, String digitosTC,
			int mesTC, int anyoTC, int cvcTC, String tipoTC) {
		
		setDni(dni);
		setNombreyApellidos(nombreyApellidos);
		setDireccion(direccion);
		setPoblacion(poblacion);
		setCodPostal(codPostal);
		setFechaCarnetConducir(fechaCarnetConducir);
		setDigitosTC(digitosTC);
		setMesTC(mesTC);
		setAnyoTC(anyoTC);
		setCvcTC(cvcTC);
		setTipoTC(tipoTC);
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
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public String getCodPostal() {
		return codPostal;
	}
	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}
	public LocalDateTime getFechaCarnetConducir() {
		return fechaCarnetConducir;
	}
	public void setFechaCarnetConducir(LocalDateTime fechaCarnetConducir) {
		this.fechaCarnetConducir = fechaCarnetConducir;
	}
	public String getTipoTC() {
		return tipoTC;
	}
	public void setTipoTC(String tipoTC) {
		this.tipoTC = tipoTC;
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
	public int getAnyoTC() {
		return anyoTC;
	}
	public void setAnyoTC(int anyoTC) {
		this.anyoTC = anyoTC;
	}
	public int getCvcTC() {
		return cvcTC;
	}
	public void setCvcTC(int cvcTC) {
		this.cvcTC = cvcTC;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	/*	public AlquilerVehiculos getAlquilerVehiculos() {
	return alquilerVehiculos;
	}
	public void setAlquilerVehiculos(AlquilerVehiculos alquilerVehiculos) {
		this.alquilerVehiculos = alquilerVehiculos;
	}*/
	/*public List<Reserva> getListaReserva() {
		return listaReserva;
	}
	public void setListaReserva(List<Reserva> listaReserva) {
		this.listaReserva = listaReserva;
	}*/
}
