package persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import persistencia.dto.SucursalDTO;
import excepciones.DAOExcepcion;

public class SucursalDAOImp implements ISucursalDAO {
	static String idmax;
	protected static ConnectionManager connManager;

	public SucursalDAOImp() throws DAOExcepcion {
		super();
		try{
		connManager= new ConnectionManager("alquilervehiculosBD");
		}
		catch (ClassNotFoundException e){	
			throw new DAOExcepcion(e);
			}
	}
	public void crearSucursal (SucursalDTO sucursal){
		try {
			connManager.connect();
			connManager.updateDB("INSERT INTO SUCURSAL (ID, DIRECCION)"
					+ " VALUES("+sucursal.getId()+",'"+sucursal.getDireccion().trim()+"')");						
			connManager.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public SucursalDTO buscarSucursal(int id) throws DAOExcepcion {
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from Sucursal where ID= '"+id+"'");
			connManager.close();
		
			if (rs.next())
				return new SucursalDTO(
						rs.getInt("ID"), 
						rs.getString("DIRECCION"));
			else
				return null;	
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
	}

	public static String buscarIdMaxReserva() throws DAOExcepcion{
		
		try {
			connManager.connect();
			ResultSet rs=connManager.queryDB("select ID from Sucursal");
			connManager.close();
			
			while (rs.next()){
				idmax=rs.getString("ID");
				int idmaxAux=Integer.parseInt(idmax);
				idmax = Integer.toString(idmaxAux+=1);
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return idmax;
	}
	public List<SucursalDTO> obtenerSucursales() throws DAOExcepcion {
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from Sucursal");						
			connManager.close();
	  	  
			List<SucursalDTO> listaSucursalDTO = new ArrayList<SucursalDTO>();
				
			try{				
				while (rs.next()){

					SucursalDTO sucDTO = new SucursalDTO(
							rs.getInt("ID"),
							rs.getString("Direccion"));
								 
					listaSucursalDTO.add(sucDTO);
				}
				return listaSucursalDTO;
			}
			catch (Exception e){	throw new DAOExcepcion(e);}
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
		catch (DAOExcepcion e){		throw e;}

	}
}
