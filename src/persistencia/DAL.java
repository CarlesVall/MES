package persistencia;

import excepciones.DAOExcepcion;

import java.util.*;

import persistencia.dto.*;


public class DAL {
	
	private static DAL instancia;
	private ICategoriaDAO categoriaDAO;
	private ISucursalDAO sucursalDAO;
	private IReservaDAO reservaDAO;
	private IClienteDAO clienteDAO;
	private ICocheDAO cocheDAO;
	private IEntregaDAO entregaDAO;
	
	public DAL() throws DAOExcepcion{
			categoriaDAO = new CategoriaDAOImp();
			sucursalDAO = new SucursalDAOImp();
			clienteDAO = new ClienteDAOImp();
			reservaDAO = new ReservaDAOImp();
			cocheDAO = new CocheDAOImp();
			entregaDAO = new EntregaDAOImp();
	}
	public List<ReservaDTO> obtenerReservas(int idSucursal) {
		try {
		return reservaDAO.obtenerReservasPorSucursalOrigen(idSucursal);
		} catch (DAOExcepcion e) {
		return null;
		}
	}
	public List<ReservaDTO> obtenerReservas() {
		try {
		return reservaDAO.obtenerReservas();
		} catch (DAOExcepcion e) {
		return null;
		}
	}

	public List<CocheDTO> obtenerCoches(int idSucursal) {
		try {
		return cocheDAO.obtenerCoches(idSucursal);
		} catch (DAOExcepcion e) {
		return null;
		}
	}
	/*public List<CocheDTO> obtenerCoches() {
		try {
		return cocheDAO.obtenerCoches();
		} catch (DAOExcepcion e) {
		return null;
		}
	}*/
	public List<ClienteDTO> obtenerClientes() {
		try {
		return clienteDAO.obtenerClientes();
		} catch (DAOExcepcion e) {
		return null;
		}
	}
	public List<SucursalDTO> obtenerSucursales() {
		try {
		return sucursalDAO.obtenerSucursales();
		} catch (DAOExcepcion e) {
		return null;
		}
	}
	
	public List<EntregaDTO> obtenerEntregas() {
		try {
		return entregaDAO.obtenerEntregas();
		} catch (DAOExcepcion e) {
		return null;
		}
	}
	
	public List<CategoriaDTO> obtenerCategorias() {
		try {
		return categoriaDAO.obtenerCategorias();
		} catch (DAOExcepcion e) {
		return null;
		}
	}
	public void crearCategoria (CategoriaDTO c){
		try {
			categoriaDAO.crearCategoria(c);
		} catch (DAOExcepcion e) {
			e.printStackTrace();
		}
	}
	public void crearSucursal(SucursalDTO s){
		try {
			sucursalDAO.crearSucursal(s);
		} catch (DAOExcepcion e) {
			e.printStackTrace();
		}
	}
	public void crearCliente(ClienteDTO c) {
	
		try {
			clienteDAO.crearCliente(c);
		} catch (DAOExcepcion e) {
			e.printStackTrace();
		}
	}
	public void crearEntrega(EntregaDTO en) {
		
		try {
			entregaDAO.crearEntrega(en);
		} catch (DAOExcepcion e) {
			e.printStackTrace();
		}
	}
    public void crearReserva(ReservaDTO reserva) {
    	try {
    		reservaDAO.crearReserva(reserva);
    	}catch (DAOExcepcion e) { }
    }
    public ClienteDTO buscarCliente(String dni) {
    	try {
    		return clienteDAO.buscarCliente(dni);
    	} catch (DAOExcepcion e) {
    		return null;
    	}	
    }
    public SucursalDTO buscarSucursal(int id) {
    	try {
    		return sucursalDAO.buscarSucursal(id);
    	} catch (DAOExcepcion e) {
    		return null;
    	}
    }
	//PATRON SINGLETON
	private static void crearDAL() throws DAOExcepcion {
	        if (instancia == null) { 
	            instancia = new DAL();
	        }
	    }

    public static DAL getDAL() throws DAOExcepcion {
	        if (instancia == null) crearDAL();
	        return instancia;
	 }

}

