package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import excepciones.DAOExcepcion;
import persistencia.dto.CocheDTO;

public class CocheDAOImp implements ICocheDAO {
	protected static ConnectionManager connManager;

	public CocheDAOImp() throws DAOExcepcion {
		super();
		try{
			connManager= new ConnectionManager("alquilervehiculosBD");
		}
		catch (ClassNotFoundException e){	
			throw new DAOExcepcion(e);
			}
	}
	/*public List<CocheDTO> obtenerCoches() throws DAOExcepcion {
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from COCHE WHERE MATRICULA NOT IN (SELECT COCHEASIGNADO FROM ENTREGA)");	
			connManager.close();
	  	  
			List<CocheDTO> listaCocheDTO = new ArrayList<CocheDTO>();
				
			try{				
				while (rs.next()){
					
					CocheDTO cocDTO = new CocheDTO(
							rs.getString("MATRICULA"),
							rs.getDouble("KMSACTUALES"),
							rs.getInt("SUCURSAL"),
							rs.getString("CATEGORIA"),
							rs.getString("NOMBRE"));
					listaCocheDTO.add(cocDTO);
				}
				return listaCocheDTO;
			}
			catch (Exception e){	throw new DAOExcepcion(e);}
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
		catch (DAOExcepcion e){		throw e;}
	}*/
	public List<CocheDTO> obtenerCoches(int idSucursal) throws DAOExcepcion {
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from COCHE where SUCURSAL="+idSucursal+" AND MATRICULA NOT IN (SELECT COCHEASIGNADO FROM ENTREGA)");				
			connManager.close();
	  	 
			List<CocheDTO> listaCocheDTO = new ArrayList<CocheDTO>();
				
			try{				
				while (rs.next()){
					
							CocheDTO cocDTO = new CocheDTO(
									rs.getString("MATRICULA"),
									rs.getDouble("KMSACTUALES"),
									rs.getInt("SUCURSAL"),
									rs.getString("CATEGORIA"),
									rs.getString("NOMBRE"));
							listaCocheDTO.add(cocDTO);
					
				}
				return listaCocheDTO;
			}
			catch (Exception e){	throw new DAOExcepcion(e);}
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
		catch (DAOExcepcion e){		throw e;}
	}
}
