package persistencia.dto;

public class SucursalDTO {
	private int id;
	private String direccion;
	
	
	public SucursalDTO(int id, String direccion) {
		//super();
		
		setId(id);
		setDireccion(direccion);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
}
