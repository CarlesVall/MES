package persistencia;

import java.util.List;

import excepciones.DAOExcepcion;
import persistencia.dto.EntregaDTO;

public interface IEntregaDAO {
	public List <EntregaDTO> obtenerEntregas() throws DAOExcepcion;
	public void crearEntrega(EntregaDTO entregaDTO) throws DAOExcepcion;
}
