package logica;

import java.util.List;


public class Empleado {

	private int id;
	private String nombre;
	private boolean	administrador; 
	private Sucursal sucursal;
	private List<Entrega> listaEntrega;
	private List<Devolucion> listaDevolucion;
	
	public Empleado(int id, String nombre, boolean administrador, Sucursal sucursal, List<Entrega> listaEntrega, List<Devolucion> listaDevolucion){
		setId(id);
		setNombre(nombre);
		setAdministrador(administrador);
		setSucursal(sucursal);
		setListaEntrega(listaEntrega);
		setListaDevolucion(listaDevolucion);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isAdministrador() {
		return administrador;
	}
	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}
	public Sucursal getSucursal() {
		return sucursal;
	}
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	public List<Entrega> getListaEntrega() {
		return listaEntrega;
	}
	public void setListaEntrega(List<Entrega> listaEntrega) {
		this.listaEntrega = listaEntrega;
	}
	public List<Devolucion> getListaDevolucion() {
		return listaDevolucion;
	}
	public void setListaDevolucion(List<Devolucion> listaDevolucion) {
		this.listaDevolucion = listaDevolucion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
