package logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import excepciones.DAOExcepcion;
import persistencia.*;
import persistencia.dto.*;

public class AlquilerVehiculos {
	private DAL dal;
	private HashMap<String,Categoria> mapCategoria;
	private HashMap<Integer,Sucursal> mapSucursal;
	private HashMap<Integer,Reserva> mapReserva;
	private HashMap<Integer,Entrega> mapEntrega;
	private HashMap<String,Cliente> mapCliente;
	private HashMap<String,Coche> mapCoche;
	
	private static AlquilerVehiculos instancia = new AlquilerVehiculos();
	
	public AlquilerVehiculos(){ //throws DAOExcepcion {
		mapSucursal = new HashMap<Integer, Sucursal>();
		mapReserva = new HashMap<Integer, Reserva>();
		mapCliente = new HashMap<String, Cliente>();
		mapCategoria = new HashMap<String, Categoria>();
		mapCoche = new HashMap<String, Coche>();
		mapEntrega = new HashMap<Integer, Entrega>();
		try{
		this.dal= DAL.getDAL();
		} catch(DAOExcepcion e){}
		cargarSistema();
		
	}
	public HashMap<String,Coche> getMapCoche(){
		return mapCoche;
	}
	
    public static AlquilerVehiculos	getAlquilerVehiculos() {//throws DAOExcepcion {
	       // if (instancia == null) crearAlquilerVehiculos();
	        return instancia;
	 }
		

    public List<Cliente> listarClientes() { 
    	cargarClientes();
    	return new ArrayList<Cliente>(mapCliente.values()); 
    	}
    public List<Categoria> listarCategorias() { 
    	return new ArrayList<Categoria>(mapCategoria.values()); 
    	}
    public List<Reserva> listarReservas(Sucursal suc) { 
    	return new ArrayList<Reserva>(mapReserva.values()); 
    	}
    public List<Coche> listarCoches(int idSucursal) {
    	mapCoche.clear();
    	cargarCoches(idSucursal);
    	ArrayList <Coche> c = new ArrayList <Coche> ();
		for(Coche x : mapCoche.values()){ 
			if (x.getSucursal()==idSucursal) c.add(x);
		}
		return c;
    	}
    public List<Sucursal> listarSucursales() { 
    	return new ArrayList<Sucursal>(mapSucursal.values()); 
    	
    	}
    public List<Entrega> listarEntregas() { 
    	cargarEntregas();
    	return new ArrayList<Entrega>(mapEntrega.values()); 
    	
    	}
    public List<Reserva> listarReservas() { 
    	cargarReservas();
        ArrayList <Reserva> r = new ArrayList <Reserva> ();
        for(Reserva x : mapReserva.values()){ 
                if (!consultar_entrega(x.getId()))
                        r.add(x);
        } 
        return r;
    	
    	}
    public boolean consultar_entrega(int id){
        if(mapEntrega.containsKey(id))
                return true;
        else return false;
}
    public boolean consultar_coche(String ma){
        if(mapCoche.containsKey(ma))
                return true;
        else return false;
}
    public List<Reserva> listarReservasSucursal(int s) {
    	cargarReservas(s);
		ArrayList <Reserva> r = new ArrayList <Reserva> ();
		for(Reserva x : mapReserva.values()){ 
			if (x.getIdSucursalRecogida()==s) r.add(x);
		}
		return r;
	}
    
    
    public void anyadirSucursal(Sucursal c){
    	mapSucursal.put(c.getId(), c);   	    	
    }   
    public void anyadirCoche(Coche c){
    	mapCoche.put(c.getMatricula(), c);   	    	
    } 
    public void anyadirReserva(Reserva r){
    	mapReserva.put(r.getId(), r);    	    	
    }     
    public void anyadirCliente(Cliente c){
    	mapCliente.put(c.getDni(), c);  	    	
    } 
    public void anyadirCategoria(Categoria c){
    	mapCategoria.put(c.getNombre(), c);	    	
    }
    public void anyadirEntrega(Entrega e){
    	mapEntrega.put(e.getId(), e);	    	
    }
        
    public Sucursal buscarSucursal(int id){  	
    	if( mapSucursal.containsKey(id)) return mapSucursal.get(id);
		else return null;
   }
	public Categoria buscarCategoria(String nombre){
		if( mapCategoria.containsKey(nombre)) return mapCategoria.get(nombre);
		else return null;
	}
	public Reserva buscarReserva(int id){
		if( mapReserva.containsKey(id)) return mapReserva.get(id);
		else return null;
	}
	public void crearCategoria (Categoria categoria){
		CategoriaDTO categoriaDTO = new CategoriaDTO(categoria.getNombre(),categoria.getPrecioModIlimitada(),categoria.getPrecioModKms(),categoria.getPrecioSeguroTRiesgo(),categoria.getPrecioSeguroTerceros(),categoria.getPrecioKmModKms(),categoria.getSuperior());
		mapCategoria.put(categoria.getNombre(), categoria);
		dal.crearCategoria(categoriaDTO);
	}
	public void crearEntrega (Entrega entrega){
		EntregaDTO entregaDTO = new EntregaDTO(entrega.getId(),entrega.getFecha(),entrega.getTipoSeguro(),entrega.getKms(),entrega.getCombustible(),entrega.getCoche(),entrega.getEmpleado());
		mapEntrega.put(entrega.getId(), entrega);
		dal.crearEntrega(entregaDTO);
	}
	public void crearSucursal(Sucursal sucursal){
		SucursalDTO sucursalDTO = new SucursalDTO(sucursal.getId(),sucursal.getDireccion());
		mapSucursal.put(sucursal.getId(), sucursal);
		dal.crearSucursal(sucursalDTO);
	}
	public void crearReserva(Reserva reserva) {
			
		ReservaDTO reservaDTO = new ReservaDTO(reserva.getId(), reserva.getFechaRecogida(), reserva.getFechaDevolucion(),
				reserva.getModalidadAlquiler(), reserva.getDniCliente(),reserva.getCategoria().getNombre(), reserva.getIdSucursalRecogida(),reserva.getIdSucursalDevolucion());
		mapReserva.put(reserva.getId(), reserva);
		dal.crearReserva(reservaDTO);
	}
	public void crearCliente(Cliente cliente) throws DAOExcepcion { 	
		ClienteDTO clienteDTO=new ClienteDTO(cliente.getDni(), cliente.getNombreyApellidos(), cliente.getDireccion(), 
											 cliente.getPoblacion(), cliente.getCodPostal(),cliente.getFechaCarnetConducir(),
											 cliente.getDigitosTC(),cliente.getMesTC(), cliente.getAnyoTC(), 
											 cliente.getCvcTC(), cliente.getTipoTC());
	
	
			mapCliente.put(cliente.getDni(), cliente);
			dal.crearCliente(clienteDTO); 
		}
	public void crearCl(Cliente clienteDTO) throws DAOExcepcion { 	
		Cliente cliente=new Cliente(clienteDTO.getDni(), clienteDTO.getNombreyApellidos(), clienteDTO.getDireccion(), 
				clienteDTO.getPoblacion(), clienteDTO.getCodPostal(),clienteDTO.getFechaCarnetConducir(),
				clienteDTO.getDigitosTC(),clienteDTO.getMesTC(), clienteDTO.getAnyoTC(), 
				clienteDTO.getCvcTC(), clienteDTO.getTipoTC());
	
	
			mapCliente.put(cliente.getDni(), cliente);

		}
	
	public Cliente buscarCliente(String dni){

		Cliente cliente = this.mapCliente.get(dni);
		if (cliente==null){ 
			ClienteDTO clienteDTO = dal.buscarCliente(dni);

			if (clienteDTO != null) {
				cliente=new Cliente(clienteDTO.getDni(), clienteDTO.getNombreyApellidos(), clienteDTO.getDireccion(), 
						clienteDTO.getPoblacion(), clienteDTO.getCodPostal(),clienteDTO.getFechaCanetConducir(),
						clienteDTO.getDigitosTC(),clienteDTO.getMesTC(), clienteDTO.getAñoTC(), 
						clienteDTO.getCvcTC(), clienteDTO.getTipoTC());
				this.mapCliente.put(dni, cliente);
				}
		}
	return cliente;

	}


	public void cargarReservas(int idSucursal) {
		List<ReservaDTO> listaresDTO = dal.obtenerReservas(idSucursal);
		//System.out.println(listaresDTO);
		for (ReservaDTO reservaDTO : listaresDTO) {
			anyadirReserva(new Reserva(reservaDTO.getId(),reservaDTO.getFechaDevolucion(),reservaDTO.getFechaRecogida(),
					reservaDTO.getModalidadAlquiler(), buscarCategoria(reservaDTO.getNombreCategoria()),(reservaDTO.getDniCliente()),(reservaDTO.getIdSucursalRecogida()),(reservaDTO.getIdSucursalDevolucion())
					));
		}
	}

	public void cargarCoches(int idSucursal){
		List<CocheDTO> listaresDTO = dal.obtenerCoches(idSucursal);
		for (CocheDTO cocheDTO : listaresDTO) {
			//if (!consultar_coche(cocheDTO.getMatricula()))
			anyadirCoche(new Coche(cocheDTO.getMatricula(), cocheDTO.getKmsActuales(),cocheDTO.getSucursal(),cocheDTO.getCategoria(),cocheDTO.getNombre()
					));
		}
	}	
	public void cargarClientes(){
		List<ClienteDTO> listaresDTO = dal.obtenerClientes();
		for (ClienteDTO clienteDTO : listaresDTO) {
			anyadirCliente(new Cliente(clienteDTO.getDni(), clienteDTO.getNombreyApellidos(), clienteDTO.getDireccion(),clienteDTO.getPoblacion(),clienteDTO.getCodPostal(),clienteDTO.getFechaCanetConducir(), clienteDTO.getDigitosTC(),clienteDTO.getMesTC(),clienteDTO.getAñoTC(),clienteDTO.getCvcTC(),clienteDTO.getTipoTC()
					));
		}
	}
	public void cargarEntregas(){
		List<EntregaDTO> listaresDTO = dal.obtenerEntregas();
		for (EntregaDTO entregaDTO : listaresDTO) {
			anyadirEntrega(new Entrega(entregaDTO.getId(), entregaDTO.getFecha(), entregaDTO.getTipoSeguro(), entregaDTO.getKms(), entregaDTO.getCombustible(), entregaDTO.getCoche(), entregaDTO.getEmpleado()
					));
		}
	}
/*	public void cargarCoches(){
		List<CocheDTO> listaresDTO = dal.obtenerCoches();
		for (CocheDTO cocheDTO : listaresDTO) {
			if (!consultar_coche(cocheDTO.getMatricula()))
			anyadirCoche(new Coche(cocheDTO.getMatricula(), cocheDTO.getKmsActuales(), cocheDTO.getSucursal(),cocheDTO.getCategoria(),cocheDTO.getNombre()
					));
		}
	}*/
public void cargarSistema(){
		
		cargarCategorias();
		cargarSucursales();
		cargarEntregas();
		//cargarCoches();

	}
	private void cargarCategorias() {
		List<CategoriaDTO> listacatDTO = dal.obtenerCategorias();
		for (CategoriaDTO catDTO : listacatDTO) {
			anyadirCategoria(new Categoria(catDTO.getNombre(),
			catDTO.getPrecioModIlimitada(), 
			catDTO.getPrecioModKms(),
			catDTO.getPrecioKMModKms(), 
			catDTO.getPrecioSeguroTRiesgo(), 
			catDTO.getPrecioSeguroTerceros(),
			catDTO.getNombreCategoriaSuperior()));
		}
		for (CategoriaDTO catDTO : listacatDTO)
			if (catDTO.getNombreCategoriaSuperior() != null) 
				buscarCategoria(catDTO.getNombre()).setSuperior(catDTO.getNombreCategoriaSuperior());
		}
	private void cargarSucursales() {
		List<SucursalDTO> listasucDTO = dal.obtenerSucursales();
		for (SucursalDTO sucDTO : listasucDTO) {
			anyadirSucursal(new Sucursal(sucDTO.getId(),
			sucDTO.getDireccion()));
		}
	}
	public void cargarReservas() {
		List<ReservaDTO> listaresDTO = dal.obtenerReservas();
		for (ReservaDTO reservaDTO : listaresDTO) {
			anyadirReserva(new Reserva(reservaDTO.getId(),reservaDTO.getFechaDevolucion(),reservaDTO.getFechaRecogida(),
					reservaDTO.getModalidadAlquiler(), buscarCategoria(reservaDTO.getNombreCategoria()),(reservaDTO.getDniCliente()),(reservaDTO.getIdSucursalRecogida()),(reservaDTO.getIdSucursalDevolucion())
					));
		}
	}
}