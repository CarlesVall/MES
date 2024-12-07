package logica;

import java.time.LocalDateTime;


public class Reserva {

	private int id;
	private LocalDateTime fechaRecogida;
	private LocalDateTime fechaDevolucion;
	private int modalidadAlquiler;
	private Sucursal sucursalRecogida;
	private Sucursal sucursalDevolucion;
	private Entrega entrega;
	private Cliente cliente;
	private AlquilerVehiculos alquilerVehiculos; 
	private Categoria categoria;
	private String dniCliente;
	private int idSucursalDevolucion;
	private int idSucursalRecogida;
	private String nombreReserva;
	
	
	public Reserva(int id, LocalDateTime fechaRecogida, LocalDateTime fechaDevolucion, int modalidadAlquiler, Categoria categoria, String dniCliente ,int idSucursalRecogida, int idSucursalDevolucion) {
		setId(id);
		setFechaRecogida(fechaRecogida);
		setFechaDevolucion(fechaDevolucion);
		setModalidadAlquiler(modalidadAlquiler);
		setCategoria(categoria);
		setIdSucursalRecogida(idSucursalRecogida);
		setIdSucursalDevolucion(idSucursalDevolucion);
		setDniCliente(dniCliente);		
		setCliente(AlquilerVehiculos.getAlquilerVehiculos().buscarCliente(getDniCliente()));
		setCategoria(categoria);
		setSucursalDevolucion(AlquilerVehiculos.getAlquilerVehiculos().buscarSucursal(getIdSucursalDevolucion()));
		setSucursalRecogida(AlquilerVehiculos.getAlquilerVehiculos().buscarSucursal(getIdSucursalRecogida()));
	
	}

	public LocalDateTime getFechaRecogida() {
		return fechaRecogida;
	}
	public void setFechaRecogida(LocalDateTime fechaRecogida) {
		this.fechaRecogida = fechaRecogida;
	}
	public LocalDateTime getFechaDevolucion() {
		return fechaDevolucion;
	}
	public void setFechaDevolucion(LocalDateTime fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	public int getModalidadAlquiler() {
		return modalidadAlquiler;
	}
	public void setModalidadAlquiler(int modalidadAlquiler) {
		this.modalidadAlquiler = modalidadAlquiler;
	}
	public Sucursal getSucursalRecogida() {
		return sucursalRecogida;
	}
	public void setSucursalRecogida(Sucursal sucursalRecogida) {
		this.sucursalRecogida = sucursalRecogida;
	}
	public Sucursal getSucursalDevolucion() {
		return sucursalDevolucion;
	}
	public void setSucursalDevolucion(Sucursal sucursalDevolucion) {
		this.sucursalDevolucion = sucursalDevolucion;
	}
	public Entrega getEntrega() {
		return entrega;
	}
	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public AlquilerVehiculos getAlquilerVehiculos() {
		return alquilerVehiculos;
	}
	public void setAlquilerVehiculos(AlquilerVehiculos alquilerVehiculos) {
		this.alquilerVehiculos = alquilerVehiculos;
	}
	public Categoria getCategoria() {
		
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDniCliente() {
		return dniCliente;
	} 
	public void setDniCliente(String dniCliente) {
		this.dniCliente=dniCliente;
	}
	public int getIdSucursalDevolucion() {
		return idSucursalDevolucion;
	}
	public void setIdSucursalDevolucion(int idSucursalDevolucion) {
		this.idSucursalDevolucion = idSucursalDevolucion;
	}
	public int getIdSucursalRecogida() {
		return idSucursalRecogida;
	}
	public void setIdSucursalRecogida(int idSucursalRecogida) {
		this.idSucursalRecogida = idSucursalRecogida;
	}
	public String getNombreReserva() {
		return nombreReserva;
	}
	public void setNombreReserva(String nombreReserva) {
		this.nombreReserva = nombreReserva;
	}
}