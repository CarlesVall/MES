package presentacion;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.AlquilerVehiculos;
import logica.Sucursal;
import logica.Coche;

public class ControladorListarCoches extends ControladorCasoDeUso { 
	@FXML 
	private TableView<Coche> coches; 
	@FXML 
	private TableColumn<Coche, String> matricula; 
	@FXML 
	private TableColumn<Coche, Double> km; 
	@FXML 
	private TableColumn<Coche, Integer> sucursal; 
	@FXML 
	private TableColumn<Coche, String> categoria; 
	@FXML 
	private TableView<Sucursal> sucursales;
	@FXML
	private TableColumn<Sucursal,Integer> idSuc;
	@FXML
	private TableColumn<Sucursal,String> direccion;
	@FXML 
	private Button aceptar; 
	
	public void rellenaTabla(Sucursal newValue){
		this.coches.getItems().clear();
		matricula.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getMatricula())); 
		km.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getKmsActuales())); 
		sucursal.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(newValue.getId())); 
		categoria.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getCategoria())); 
		this.coches.getItems().addAll(AlquilerVehiculos.getAlquilerVehiculos().listarCoches(newValue.getId())); 
		
		if(AlquilerVehiculos.getAlquilerVehiculos().listarCoches(newValue.getId()).isEmpty()){
			Alert alerta = new Alert(AlertType.WARNING);
    		alerta.initStyle(StageStyle.UNIFIED);
			alerta.setContentText("No hay coches disponibles para esta sucursal");
			alerta.setHeaderText("");
			alerta.showAndWait();
		}
	}
	
	
	@Override 
	public void initialize(URL location, ResourceBundle resources) { 
		stage = new Stage(StageStyle.DECORATED); 
		stage.setTitle("LISTADO DE COCHES"); 
		aceptar.setOnAction(event -> stage.close()); 
		idSuc.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getId())); 
		direccion.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getDireccion())); 
		this.sucursales.getItems().addAll(AlquilerVehiculos.getAlquilerVehiculos().listarSucursales()); 
		sucursales.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->{
			rellenaTabla(newValue);
		});

		} 
	}