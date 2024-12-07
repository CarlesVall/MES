package logica;

import java.util.ArrayList;
import java.util.List;


public class Sucursal {

	private int id;
	private String direccion;
	private AlquilerVehiculos alquiler;
	private List<Coche> listaCoche;
	private List<Reserva> reservaRecogida;
	private List<Reserva> reservaDevolucion;
	private List<Empleado> listaEmpleados;
	
	
	public Sucursal(int id, String direccion) {
		setId(id);
		setDireccion(direccion);
		setListaCoche(new ArrayList<Coche>());
		setListaEmpleados(new ArrayList<Empleado>());
		setReservaDevolucion(new ArrayList<Reserva>());
		setReservaRecogida(new ArrayList<Reserva>());
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public AlquilerVehiculos getAlquiler() {
		return alquiler;
	}
	public void setAlquiler(AlquilerVehiculos alquiler) {
		this.alquiler = alquiler;
	}
	public List<Coche> getListaCoche() {
		return listaCoche;
	}
	public void setListaCoche(List<Coche> listaCoche) {
		this.listaCoche = listaCoche;
	}
	public List<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}
	public void setListaEmpleados(List<Empleado> listaEmpleado) {
		this.listaEmpleados = listaEmpleado;
	}
	public List<Reserva> getReservaRecogida() {
		return reservaRecogida;
	}
	public void setReservaRecogida(List<Reserva> reservaRecogida) {
		this.reservaRecogida = reservaRecogida;
	}
	public List<Reserva> getReservaDevolucion() {
		return reservaDevolucion;
	}
	public void setReservaDevolucion(List<Reserva> reservaDevolucion) {
		this.reservaDevolucion = reservaDevolucion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}