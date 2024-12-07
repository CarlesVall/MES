package persistencia.dto;

public class CocheDTO {
	private String matricula;
	private double kmsactuales;
	private int sucursal;
	private String categoria;
	private String nombre;

	public CocheDTO(String matricula, double kmsactuales, int sucursal, String categoria, String nombre){
		setMatricula(matricula);
		setKmsActuales(kmsactuales);
		setSucursal(sucursal);
		setCategoria(categoria);
		setNombre(nombre);
	}

	public String getMatricula(){
		return matricula;
	}
	public void setMatricula(String matricula){
		this.matricula=matricula;
	}
	public double getKmsActuales(){
		return kmsactuales;
	}
	public void setKmsActuales(double kmsactuales){
		this.kmsactuales=kmsactuales;
	}
	public int getSucursal(){
		return sucursal;
	}
	public void setSucursal(int sucursal){
		this.sucursal=sucursal;
	}
	public String getCategoria(){
		return categoria;
	}
	public void setCategoria(String categoria){
		this.categoria=categoria;
	}
	public String getNombre(){
		return nombre;
	}
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
}