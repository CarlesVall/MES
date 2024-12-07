package logica;

import java.time.LocalDateTime;
import java.util.List;


public class Entrega {

	private int id;
	private LocalDateTime fecha;
	private String tipoSeguro;
	private double kms;
	private double combustible;
	private String coche;
	private String empleado;
	private Devolucion devolucion;
	private Reserva reserva;
	private List<Danyo> listaDanyos;
	
	public Entrega(int id, LocalDateTime fecha, String tipoSeguro, double kms, double combustible, String coche, String empleado){
		setId(id);
		setFecha(fecha);
		setTipoSeguro(tipoSeguro);
		setKms(kms);
		setCombustible(combustible);
		setCoche(coche);
		setEmpleado(empleado);
		//setDevolucion(devolucion);
		//setReserva(reserva);
		//setListaDanyos(listaDanyos);
	}
	
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime localDateTime) {
		this.fecha = localDateTime;
	}
	public String getTipoSeguro() {
		return tipoSeguro;
	}
	public void setTipoSeguro(String tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
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
	public String getCoche() {
		return coche;
	}
	public void setCoche(String coche) {
		this.coche = coche;
	}
	public String getEmpleado() {
		return empleado;
	}
	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}
	public Devolucion getDevolucion() {
		return devolucion;
	}
	public void setDevolucion(Devolucion devolucion) {
		this.devolucion = devolucion;
	}
	public Reserva getReserva() {
		return reserva;
	}
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	public List<Danyo> getListaDanyos() {
		return listaDanyos;
	}
	public void setListaDanyos(List<Danyo> listaDanyos) {
		this.listaDanyos = listaDanyos;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
