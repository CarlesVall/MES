package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import excepciones.DAOExcepcion;
import persistencia.dto.EntregaDTO;

public class EntregaDAOImp implements IEntregaDAO {
	protected static ConnectionManager connManager;
	static String idmax;
	int anyo;
	int mes;
	int dia;
	String hora="00:00:00";
	String completo;

	public EntregaDAOImp() throws DAOExcepcion {
		super();
		try{
			connManager= new ConnectionManager("alquilervehiculosBD");
		}
		catch (ClassNotFoundException e){	
			throw new DAOExcepcion(e);
			}
	}

	@Override
	public List<EntregaDTO> obtenerEntregas() throws DAOExcepcion {
		List<EntregaDTO> listaEntregaDTO = new ArrayList<EntregaDTO>();
		try {
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from ENTREGA");						
			connManager.close();
			
		while (rs.next()){
			LocalDateTime fecha = LocalDateTime.of(rs.getDate("FECHA").toLocalDate(),
					rs.getTime("FECHA").toLocalTime());
			EntregaDTO entDTO = new EntregaDTO(
					rs.getInt("ID"),
					fecha,
					rs.getString("TIPOSEGURO"),
					rs.getDouble("KMS"),
					rs.getDouble("COMBUSTIBLE"),
					rs.getString("COCHEASIGNADO"),
					rs.getString("EMPLEADOREALIZA")
					
					);	 
			listaEntregaDTO.add(entDTO);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
  	  
		
		return listaEntregaDTO;
	}

	@Override
	public void crearEntrega(EntregaDTO entregaDTO) throws DAOExcepcion {
		try {
			anyo=entregaDTO.getFecha().getYear();
			mes=entregaDTO.getFecha().getMonthValue();
			dia=entregaDTO.getFecha().getDayOfMonth();
			completo=anyo+"-"+mes+"-"+dia+" "+hora;
			System.out.println("Sin trim:" +entregaDTO.getCoche()+"final Longitud: "+entregaDTO.getCoche().length());
			System.out.println("Con trim:" +entregaDTO.getCoche().trim()+"final Longitud: "+entregaDTO.getCoche().trim().length());
			connManager.connect();
			connManager.updateDB("INSERT INTO ENTREGA (ID,FECHA,TIPOSEGURO,KMS,COMBUSTIBLE,COCHEASIGNADO,EMPLEADOREALIZA)"
					+ " VALUES("+entregaDTO.getId()+",'"+completo+"','"+entregaDTO.getTipoSeguro()+"',"+entregaDTO.getKms()+","+entregaDTO.getCombustible()+",'"+entregaDTO.getCoche().trim()+"','"+entregaDTO.getEmpleado()+"')");						
			connManager.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public static String buscarIdMaxEntrega() throws DAOExcepcion{
		
		try {
			connManager.connect();
			ResultSet rs=connManager.queryDB("select ID from Entrega");
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

}
