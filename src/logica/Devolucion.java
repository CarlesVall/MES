package logica;

import java.util.ArrayList;
import java.util.List;


public class Devolucion {

	private int id;
	private String fecha;
	private double totalACobrar;
	private double cobrado;
	private double kms;
	private double combustible;
	private Entrega entrega;
	private Empleado empleado;
	private List<Danyo> listaDanyo;
	
	public Devolucion(String fecha, double totalACobrar, double cobrado,
			double kms, double combustible, Empleado empleado, Entrega entrega
			) {
		super();
		setFecha(fecha);
		setTotalACobrar(totalACobrar);
		setCobrado(cobrado);
		setKms(kms);
		setEmpleado(empleado);
		setEntrega(entrega);
		setListaDanyo(new ArrayList<Danyo>());
	}

	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public double getTotalACobrar() {
		return totalACobrar;
	}
	public void setTotalACobrar(double totalACobrar) {
		this.totalACobrar = totalACobrar;
	}
	public double getCobrado() {
		return cobrado;
	}
	public void setCobrado(double cobrado) {
		this.cobrado = cobrado;
	}
	public double getKms() {
		return kms;
	}
	public void setKms(double kms) {
		this.kms = kms;
	}
	public double getCombustible() {
		return combustible;
	}
	public void setCombustible(double combustible) {
		this.combustible = combustible;
	}
	public Entrega getEntrega() {
		return entrega;
	}
	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public List<Danyo> getListaDanyo() {
		return listaDanyo;
	}
	public void setListaDanyo(List<Danyo> listaDanyo) {
		this.listaDanyo = listaDanyo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
