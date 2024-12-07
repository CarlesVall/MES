package persistencia.dto;

import java.time.LocalDateTime;


public class EntregaDTO {
	private int id;
	private LocalDateTime fecha;
	private String tipoSeguro;
	private double kms;
	private double combustible;
	private String coche;
	private String empleado;

	
	public EntregaDTO(int id, LocalDateTime fecha, String tipoSeguro, double kms, double combustible, String coche, String empleado){
		setId(id);
		setFecha(fecha);
		setTipoSeguro(tipoSeguro);
		setKms(kms);
		setCombustible(combustible);
		setCoche(coche);
		setEmpleado(empleado);
	}
	
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
