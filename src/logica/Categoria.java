package logica;

import java.util.List;


public class Categoria {

	private String nombre;
	private double precioModIlimitada;
	private double precioModKms;
	private double precioKmModKms;
	private double precioSeguroTRiesgo;
	private double precioSeguroTerceros;
	private String superior;
	
	//private AlquilerVehiculos alquilerVehiculo;
	//private List<Reserva> listaReservas;
	private List<Coche> listaCoches;
	public double getPrecioModIlimitada() {
		return precioModIlimitada;
	}
		public void setPrecioModIlimitada(double precioModIlimitada) {
		this.precioModIlimitada = precioModIlimitada;
	}
	public double getPrecioModKms() {
		return precioModKms;
	}
	public void setPrecioModKms(double precioModKms) {
		this.precioModKms = precioModKms;
	}
	public double getPrecioKmModKms() {
		return precioKmModKms;
	}
	public void setPrecioKmModKms(double precioKmModKms) {
		this.precioKmModKms = precioKmModKms;
	}
	public double getPrecioSeguroTRiesgo() {
		return precioSeguroTRiesgo;
	}
	public void setPrecioSeguroTRiesgo(double precioSeguroTRiesgo) {
		this.precioSeguroTRiesgo = precioSeguroTRiesgo;
	}
	public double getPrecioSeguroTerceros() {
		return precioSeguroTerceros;
	}
	public void setPrecioSeguroTerceros(double precioSeguroTerceros) {
		this.precioSeguroTerceros = precioSeguroTerceros;
	}
	public String getSuperior() {
		return superior;
	}
	public void setSuperior(String categoriaSuperior) {
		this.superior = categoriaSuperior;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Coche> getListaCoches() {
		return listaCoches;
	}
	public void setListaCoches(List<Coche> listaCoches) {
		this.listaCoches = listaCoches;
	}

	public Categoria(String nombre, double precioModIlimitada, double precioModKms, double precioSeguroTRiesgo, double precioSeguroTerceros, double precioKmModKms, String categoriaSuperior){
		setNombre(nombre);
		setPrecioModIlimitada(precioModIlimitada); 
		setPrecioModKms(precioModKms);
		setPrecioKmModKms(precioKmModKms); 
		setPrecioSeguroTRiesgo(precioSeguroTRiesgo); 
		setPrecioSeguroTerceros(precioSeguroTerceros);
		setSuperior(categoriaSuperior);
	}
	
	/*public AlquilerVehiculos getAlquilerVehiculo() {
		return alquilerVehiculo;
	}
	public void setAlquilerVehiculo(AlquilerVehiculos alquilerVehiculo) {
		this.alquilerVehiculo = alquilerVehiculo;
	}
	public List<Reserva> getListaReservas() {
		return listaReservas;
	}
	public void setListaReservas(List<Reserva> listaReservas) {
		this.listaReservas = listaReservas;
	}*/

}