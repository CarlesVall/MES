package presentacion;

import excepciones.LogicaExcepcion;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class ControladorPrincipal { 
	@FXML
	private MenuItem salir;
	@FXML
	private MenuItem crearReserva;
	@FXML
	private MenuItem crearCliente;
	@FXML
	private MenuItem listarReservasSucursal;
	@FXML
	private MenuItem listarCoches;
	
	
	private static final String CREAR_CLIENTE = "crear-cliente.fxml";
	private static final String LISTAR_RESERVAS = "listar-reservas.fxml";
	private static final String LISTAR_RESERVAS_SUCURSAL = "listar-reservas-sucursales.fxml";
	private static final String LISTAR_SUCURSALES = "listar-sucursales.fxml"; 
	private static final String CREAR_RESERVA = "crear-reserva.fxml";
	private static final String LISTAR_COCHES = "listar-coches.fxml";
	private static final String LISTAR_CATEGORIAS = "listar-categorias.fxml";
	private static final String CREAR_CATEGORIA = "crear-categoria.fxml";
	private static final String CREAR_SUCURSAL = "crear-sucursal.fxml";
	private static final String LISTAR_CLIENTES = "listar-clientes.fxml";
	private static final String LISTAR_ENTREGAS = "listar-entregas.fxml";
	//TODO añadir constantes de tipo String para la vistas correspondientes a los casos de uso Crear Reserva y Listar Reservas de una Sucursal 
	
	private Stage primaryStage; 
	@FXML 
	void listarClientes(ActionEvent event) throws LogicaExcepcion { 
		initCasoDeUso(LISTAR_CLIENTES, ControladorListarClientes.class).show(); 
		}
	@FXML 
	void listarReservasSucursal(ActionEvent event) throws LogicaExcepcion { 
		initCasoDeUso(LISTAR_RESERVAS_SUCURSAL, ControladorListarReservasSucursal.class).show(); 
		}
	@FXML
	void listarReservas(ActionEvent event) throws LogicaExcepcion { 
		initCasoDeUso(LISTAR_RESERVAS, ControladorListarReservas.class).show(); 
		}
	@FXML 
	void listarEntregas(ActionEvent event) throws LogicaExcepcion { 
		initCasoDeUso(LISTAR_ENTREGAS, ControladorListarEntregas.class).show(); 
		}
	@FXML 
	void listarCategorias(ActionEvent event) throws LogicaExcepcion { 
		initCasoDeUso(LISTAR_CATEGORIAS, ControladorListarCategorias.class).show(); 
		}
	@FXML 
	void listarSucursales(ActionEvent event) throws LogicaExcepcion { 
		initCasoDeUso(LISTAR_SUCURSALES, ControladorListarSucursales.class).show(); 
		}
	@FXML 
	void crearSucursal(ActionEvent event) throws LogicaExcepcion {
		initCasoDeUso(CREAR_SUCURSAL, ControladorCrearSucursal.class).show(); 
		}
	@FXML 
	void crearCategoria(ActionEvent event) throws LogicaExcepcion {
		initCasoDeUso(CREAR_CATEGORIA, ControladorCrearCategoria.class).show(); 
		}
	@FXML 
	void crearCliente(ActionEvent event) throws LogicaExcepcion {
		initCasoDeUso(CREAR_CLIENTE, ControladorCrearCliente.class).show(); 
		}
	@FXML 
	void crearReserva(ActionEvent event) throws LogicaExcepcion  { 
		initCasoDeUso(CREAR_RESERVA, ControladorCrearReserva.class).show();
		}
	@FXML
	void listarCoches(ActionEvent event) throws LogicaExcepcion { 
			initCasoDeUso(LISTAR_COCHES, ControladorListarCoches.class).show();
			}
	@FXML 
	void salir(ActionEvent event) { 
		Platform.exit(); 
		}
	@FXML
	void AcercaDe(ActionEvent event){
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.initStyle(StageStyle.DECORATED);
		alerta.setContentText("Práctica realizada por:\n\nJavier Cruz Selvi\nCarlos García Del Río\nAlejandro Gil Contreras\nAntoni Giménez Rodríguez");
		alerta.setHeaderText("Autores");
		alerta.showAndWait();
	}
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage; 
		}
	private <T extends ControladorCasoDeUso> T initCasoDeUso(String urlVista, Class<T> controlClass) {
		return ControladorCasoDeUso.initCasoDeUso(urlVista, controlClass, primaryStage, ControladorPrincipal.this); 
		} 
	
	}
