package logica;

import java.util.List;


public class Coche {

	
	private String matricula;
	private double  kmsActuales;
	private int sucursal;
	private String categoria;
	private String nombre;
	private List<Entrega> listaEntrega;
	private int id;
	
	
	public Coche(String matricula, double kmsactuales, int sucursal, String categoria, String nombre){
		setMatricula(matricula);
		setKmsActuales(kmsactuales);
		setSucursal(sucursal);
		setCategoria(categoria);
		setNombre(nombre);
	}
	
	
	
	public String getNombre(){
		return nombre;
	}
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public double getKmsActuales() {
		return kmsActuales;
	}
	public void setKmsActuales(double kmsActuales) {
		this.kmsActuales = kmsActuales;
	}
	public int getSucursal() {
		return sucursal;
	}
	public void setSucursal(int sucursal) {
		this.sucursal = sucursal;
	}
	public List<Entrega> getListaEntega() {
		return listaEntrega;
	}
	public void setListaEntega(List<Entrega> listaEntega) {
		this.listaEntrega = listaEntega;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
