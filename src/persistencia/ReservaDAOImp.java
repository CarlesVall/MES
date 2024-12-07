package persistencia;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import persistencia.dto.ReservaDTO;
import excepciones.DAOExcepcion;

public class ReservaDAOImp implements IReservaDAO {
	int anyoDev;
	int mesDev;
	int diaDev;
	String completoDev;
	int anyoRec;
	int mesRec;
	int diaRec;
	String completoRec;
	String hora="00:00:00";
	static String idmax;
	protected static ConnectionManager connManager;

	public ReservaDAOImp() throws DAOExcepcion {
		super();
		try{
		connManager= new ConnectionManager("alquilervehiculosBD");
		}
		catch (ClassNotFoundException e){	
			throw new DAOExcepcion(e);
			}
	}

	public void crearReserva(ReservaDTO reserva) throws DAOExcepcion{
		try{
	    	anyoDev=reserva.getFechaDevolucion().getYear();
			mesDev=reserva.getFechaDevolucion().getMonthValue();
			diaDev=reserva.getFechaDevolucion().getDayOfMonth();
			completoDev=anyoDev+"-"+mesDev+"-"+diaDev+" "+hora;
	    	anyoRec=reserva.getFechaRecogida().getYear();
			mesRec=reserva.getFechaRecogida().getMonthValue();
			diaRec=reserva.getFechaRecogida().getDayOfMonth();
			completoRec=anyoDev+"-"+mesDev+"-"+diaDev+" "+hora;
			connManager.connect();
			connManager.updateDB("INSERT INTO RESERVA (ID, FECHARECOGIDA, FECHADEVOLUCION, MODALIDADALQUILER, CATEGORIA, CLIENTEREALIZA, SUCURSALRECOGIDA, SUCURSALDEVOLUCION)"
					+ " VALUES("+reserva.getId()+",'"+completoRec+"','"+completoDev+"','"+reserva.getModalidadAlquiler()+"','"+reserva.getNombreCategoria().trim()+"','"+reserva.getDniCliente().trim()+"',"+reserva.getIdSucursalRecogida()+","+reserva.getIdSucursalDevolucion()+")");						
			connManager.close();	
		}
		catch (SQLException e){
			e.printStackTrace();}
	}
	public List<ReservaDTO> obtenerReservas() throws DAOExcepcion {
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from RESERVA");						
			connManager.close();
			List<ReservaDTO> listaReservaDTO = new ArrayList<ReservaDTO>();
			try{				
				while (rs.next()){
					LocalDateTime fechaRecogida = LocalDateTime.of(rs.getDate("FECHARECOGIDA").toLocalDate(),
							rs.getTime("FECHARECOGIDA").toLocalTime());
					LocalDateTime fechaDevolucion = LocalDateTime.of(rs.getDate("FECHADEVOLUCION").toLocalDate(),
							rs.getTime("FECHADEVOLUCION").toLocalTime());
					
					
					ReservaDTO resDTO = new ReservaDTO(
							rs.getInt("ID"),
							fechaRecogida,
							fechaDevolucion,
							rs.getInt("MODALIDADALQUILER"),
							rs.getString("CLIENTEREALIZA"),
							rs.getString("CATEGORIA").trim(),
							rs.getInt("SUCURSALRECOGIDA"),
							rs.getInt("SUCURSALDEVOLUCION"));
					listaReservaDTO.add(resDTO);
				}
				return listaReservaDTO;
			}
			catch (Exception e){	throw new DAOExcepcion(e);}
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
		catch (DAOExcepcion e){		throw e;}
	}
	public List<ReservaDTO> obtenerReservasPorSucursalOrigen(int idSucursal) throws DAOExcepcion {
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from RESERVA where SUCURSALRECOGIDA= "+idSucursal);						
			connManager.close();
			List<ReservaDTO> listaReservaDTO = new ArrayList<ReservaDTO>();
			try{				
				while (rs.next()){
					LocalDateTime fechaRecogida = LocalDateTime.of(rs.getDate("FECHARECOGIDA").toLocalDate(),
							rs.getTime("FECHARECOGIDA").toLocalTime());
					LocalDateTime fechaDevolucion = LocalDateTime.of(rs.getDate("FECHADEVOLUCION").toLocalDate(),
							rs.getTime("FECHADEVOLUCION").toLocalTime());
					ReservaDTO resDTO = new ReservaDTO(
							rs.getInt("ID"),
							fechaRecogida,
							fechaDevolucion,
							rs.getInt("MODALIDADALQUILER"),
							rs.getString("CLIENTEREALIZA"),
							rs.getString("CATEGORIA").trim(),
							rs.getInt("SUCURSALRECOGIDA"),
							rs.getInt("SUCURSALDEVOLUCION"));
					listaReservaDTO.add(resDTO);
				}
				return listaReservaDTO;
			}
			catch (Exception e){	throw new DAOExcepcion(e);}
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
		catch (DAOExcepcion e){		throw e;}
	}
	public ReservaDTO buscarReserva(int id) throws DAOExcepcion {
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from Reserva where ID= "+id);
			connManager.close();
			if (rs.next()){
				LocalDateTime fechaRecogida = LocalDateTime.of(rs.getDate("FECHARECOGIDA").toLocalDate(),
						rs.getTime("FECHARECOGIDA").toLocalTime());
				LocalDateTime fechaDevolucion = LocalDateTime.of(rs.getDate("FECHADEVOLUCION").toLocalDate(),
						rs.getTime("FECHADEVOLUCION").toLocalTime());
				return new ReservaDTO(
						rs.getInt("ID"),
						fechaRecogida,
						fechaDevolucion,
						rs.getInt("MODALIDADALQUILER"),
						rs.getString("CLIENTEREALIZA"),
						rs.getString("CATEGORIA"),
						rs.getInt("SUCURSALRECOGIDA"),
						rs.getInt("SUCURSALDEVOLUCION"));	
			}else
				return null;	
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
	}
	
	public static String buscarIdMaxReserva() throws DAOExcepcion{
		
		try {
			connManager.connect();
			ResultSet rs=connManager.queryDB("select ID from Reserva");
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