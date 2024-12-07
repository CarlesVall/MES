package persistencia;

import java.util.List;

import excepciones.DAOExcepcion;
import persistencia.dto.CocheDTO;

public interface ICocheDAO {
	public List<CocheDTO> obtenerCoches(int idSucursal) throws DAOExcepcion;

	//public List<CocheDTO> obtenerCoches()throws DAOExcepcion;
}
