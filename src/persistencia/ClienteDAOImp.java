package persistencia;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import persistencia.dto.ClienteDTO;
import excepciones.DAOExcepcion;

public class ClienteDAOImp implements IClienteDAO {
	int anyo;
	int mes;
	int dia;
	String hora="00:00:00";
	String completo;
	protected ConnectionManager connManager;

	public ClienteDAOImp() throws DAOExcepcion {
		super();
		try{
		connManager= new ConnectionManager("alquilervehiculosBD");
		}
		catch (ClassNotFoundException e){	
			throw new DAOExcepcion(e);
			}
	}

	public void crearCliente(ClienteDTO cliente) throws DAOExcepcion{
		try{
			anyo=cliente.getFechaCanetConducir().getYear();
			mes=cliente.getFechaCanetConducir().getMonthValue();
			dia=cliente.getFechaCanetConducir().getDayOfMonth();
			completo=anyo+"-"+mes+"-"+dia+" "+hora;
			connManager.connect();
			connManager.updateDB("INSERT INTO CLIENTE (DNI, NOMBREAPELLIDOS, DIRECCION, POBLACION, CODPOSTAL, FECHACARNETCONDUCIR, DIGITOSTC,MESTC, \"a\u00f1oTC\", CVCTC, TIPOTC)"
					+ " VALUES('"+cliente.getDni().trim()+"','"+cliente.getNombreyApellidos().trim()+"','"+cliente.getDireccion().trim()+"','"+cliente.getPoblacion().trim()+"','"+cliente.getCodPostal().trim()+"','"+completo+"','"+cliente.getDigitosTC().trim()+"',"+cliente.getMesTC()+","+cliente.getAñoTC()+","+cliente.getCvcTC()+",'"+cliente.getTipoTC().trim()+"')");						
			connManager.close();
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}
		
	}

	public ClienteDTO buscarCliente(String dni) throws DAOExcepcion {
		
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from CLIENTE where DNI= '"+dni+"'");
			connManager.close();
		
			if (rs.next()){
				LocalDateTime fechaCanetConducir = LocalDateTime.of(rs.getDate("FECHACARNETCONDUCIR").toLocalDate(),
						rs.getTime("FECHACARNETCONDUCIR").toLocalTime());
				//System.out.println("DNI: "+rs.getString("DNI")+" Nombre: "+ rs.getString("NOMBREAPELLIDOS")+" Direccion: "+rs.getString("DIRECCION")+" Poblacion: "+rs.getString("POBLACION")+" CP: "+rs.getString("CODPOSTAL")+" Fecha: "+fechaCanetConducir+" Digitos: "+rs.getString("DIGITOSTC"));
				ClienteDTO prueba = new ClienteDTO(
						rs.getString("DNI"),
						rs.getString("NOMBREAPELLIDOS"),
						rs.getString("DIRECCION"),
						rs.getString("POBLACION"),
						rs.getString("CODPOSTAL"),
						fechaCanetConducir,
						rs.getString("DIGITOSTC"),
						rs.getInt("MESTC"),
						rs.getInt("AÑOTC"),
						rs.getInt("CVCTC"),
						rs.getString("TIPOTC"));	
	
				//System.out.println(prueba.getDni());
				 return prueba;
			}else
				return null;	
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
	}

	@Override
	public List<ClienteDTO> obtenerClientes() throws DAOExcepcion {
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from CLIENTE");						
			connManager.close();
	  	  
			List<ClienteDTO> listaClienteDTO = new ArrayList<ClienteDTO>();
				
			try{				
				while (rs.next()){
					LocalDateTime fechaCanetConducir = LocalDateTime.of(rs.getDate("FECHACARNETCONDUCIR").toLocalDate(),
							rs.getTime("FECHACARNETCONDUCIR").toLocalTime());
					ClienteDTO cliDTO = new ClienteDTO(
							rs.getString("DNI"),
							rs.getString("NOMBREAPELLIDOS"),
							rs.getString("DIRECCION"),
							rs.getString("POBLACION"),
							rs.getString("CODPOSTAL"),
							fechaCanetConducir,
							rs.getString("DIGITOSTC"),
							rs.getInt("MESTC"),
							rs.getInt("AÑOTC"),
							rs.getInt("CVCTC"),
							rs.getString("TIPOTC"));	
					listaClienteDTO.add(cliDTO);
				}
				return listaClienteDTO;
			}
			catch (Exception e){	throw new DAOExcepcion(e);}
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
		catch (DAOExcepcion e){		throw e;}
	}

}



