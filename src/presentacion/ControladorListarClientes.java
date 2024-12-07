package presentacion;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.AlquilerVehiculos;
import logica.Cliente;

public class ControladorListarClientes extends ControladorCasoDeUso { 
	@FXML
    private TableColumn<Cliente, LocalDateTime> fechaCarnet;
    @FXML
    private TableColumn<Cliente, String> codigoPostal;
    @FXML
    private TableColumn<Cliente, Integer> cvcTC;
    @FXML
    private TableView<Cliente> clientes;
    @FXML
    private Button aceptar;
    @FXML
    private TableColumn<Cliente, String> direccion;
    @FXML
    private TableColumn<Cliente, String> nombreApellidos;
    @FXML
    private TableColumn<Cliente, String> poblacion;
    @FXML
    private TableColumn<Cliente, String> digitosTC;
    @FXML
    private TableColumn<Cliente, String> tipoTC;
    @FXML
    private TableColumn<Cliente, String> dni;
    @FXML
    private TableColumn<Cliente, String> caducidadTC;
    @Override 
	public void initialize(URL location, ResourceBundle resources) { 
		stage = new Stage(StageStyle.DECORATED); 
		stage.setTitle("LISTADO DE CLIENTES"); 
		aceptar.setOnAction(event -> stage.close()); 
		
		dni.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getDni())); 
		fechaCarnet.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getFechaCarnetConducir())); 
		codigoPostal.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getCodPostal())); 
		cvcTC.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getCvcTC())); 
		direccion.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getDireccion())); 
		nombreApellidos.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getNombreyApellidos().trim())); 
		poblacion.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getPoblacion().trim())); 
		digitosTC.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getDigitosTC())); 
		tipoTC.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getTipoTC())); 
		caducidadTC.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(""+param.getValue().getAnyoTC()+"-"+param.getValue().getMesTC())); 
		this.clientes.getItems().addAll(AlquilerVehiculos.getAlquilerVehiculos().listarClientes());
		} 
	}