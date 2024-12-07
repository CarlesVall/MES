//ICategoriaDAO
package persistencia;

import java.util.List;
import persistencia.dto.CategoriaDTO;
import excepciones.*;

public interface ICategoriaDAO {
 public CategoriaDTO buscarCategoria(String nombre)throws DAOExcepcion;

 public List <CategoriaDTO> obtenerCategorias() throws DAOExcepcion;
 
 public void crearCategoria(CategoriaDTO categoria) throws DAOExcepcion;
}
