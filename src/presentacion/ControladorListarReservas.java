package presentacion;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.AlquilerVehiculos;
import logica.Categoria;
import logica.Coche;
import logica.Reserva;

public class ControladorListarReservas extends ControladorCasoDeUso { 
	@FXML
	private TableView<Reserva> reservas;
	@FXML
	private TableColumn<Reserva, Integer> idRes;
	@FXML
	private TableColumn<Reserva, LocalDateTime> fechaRec;
	@FXML
	private TableColumn<Reserva, LocalDateTime> fechaDev;
	@FXML
	private TableColumn<Reserva, Integer> modalidadAlquiler;
	@FXML
	private TableColumn<Reserva, String> sucDev;
	@FXML
	private TableColumn<Reserva, String> sucRec;
	@FXML
	private TableColumn<Reserva, String> cat;
	@FXML
	private TableColumn<Reserva, String> cliente;
	@FXML
	private TableColumn<Reserva, String> dni;
	@FXML
	private Button  aceptar;
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
	Categoria categoriaActual;
	public static String matriculaCoche;
	
	
	static String id;
	LocalDate fecha;
	String tipoSeguro;
	double kms;
	double combustible;
	String cocheAsignado;
	String empleadoRealiza;
	
	
	public void rellenaTabla(Reserva newValue){
		
		coches.getItems().clear();
		List<Coche> listaCoche=null;
		listaCoche = AlquilerVehiculos.getAlquilerVehiculos().listarCoches(newValue.getIdSucursalRecogida());
		List<Coche> listaCocheRes=new ArrayList<Coche>();
		matricula.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getMatricula())); 
		km.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getKmsActuales())); 
		sucursal.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getSucursal())); 
		categoria.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getNombre())); 
		
		categoriaActual=AlquilerVehiculos.getAlquilerVehiculos().buscarCategoria(newValue.getCategoria().getNombre().trim());
		while(categoriaActual.getSuperior()!=null){
		for(int i=0;i<listaCoche.size();i++){
			if(categoriaActual.getNombre().trim().equals(listaCoche.get(i).getNombre().trim()))
				listaCocheRes.add(listaCoche.get(i));
		}
		categoriaActual=AlquilerVehiculos.getAlquilerVehiculos().buscarCategoria(categoriaActual.getSuperior());
		}
		
		for(int i=0;i<listaCoche.size();i++)
		if(listaCoche.get(i).getNombre().trim().equals("luxury"))
			listaCocheRes.add(listaCoche.get(i));
		
		this.coches.getItems().addAll(listaCocheRes);
		
		
		
		if(this.coches.getItems().isEmpty()){
			Alert alerta = new Alert(AlertType.WARNING);
    		alerta.initStyle(StageStyle.UNIFIED);
			alerta.setContentText("No hay coches disponibles para esta sucursal");
			alerta.setHeaderText("");
			alerta.showAndWait();
		}
	}
	public void setMat(String matr){
		ControladorListarReservas.matriculaCoche=matr;
	}
	public static String getMat(){
		return matriculaCoche;
	}
	public static String getIdReserva(){
		return id;
	}
	
    @Override 
	public void initialize(URL location, ResourceBundle resources) { 
    	stage = new Stage(StageStyle.DECORATED); 
    	reservas.getItems().clear();
		stage.setTitle("LISTADO DE RESERVAS"); 
		aceptar.setOnAction(event -> stage.close()); 
		idRes.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getId()));
		fechaRec.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getFechaRecogida()));
		fechaDev.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getFechaDevolucion()));
		modalidadAlquiler.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getModalidadAlquiler()));
		cat.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getCategoria().getNombre()));
		cliente.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getCliente().getNombreyApellidos()));
		dni.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getCliente().getDni()));
		sucDev.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getSucursalDevolucion().getDireccion()));
		sucRec.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getSucursalRecogida().getDireccion()));
		this.reservas.getItems().addAll(AlquilerVehiculos.getAlquilerVehiculos().listarReservas());
		reservas.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->{
			id = Integer.toString(newValue.getId());
			rellenaTabla(newValue);
		//AlquilerVehiculos.getAlquilerVehiculos().cargarSistema();
		});
		
		
		coches.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, nuevoValor)->{
		if (nuevoValor!=null){
			setMat(nuevoValor.getMatricula());

			Stage ventana = new Stage();
			FXMLLoader loader = new FXMLLoader(AlquilerVehiculosApp.class.getResource("crear-entrega.fxml"));
            GridPane ventanaDos = null;
			try {
				ventanaDos = (GridPane) loader.load();
			} catch (Exception e) {
				e.printStackTrace();
			}
            
            ventana.setTitle("CREAR ENTREGA");
            ventana.initOwner(stage);
            Scene scene = new Scene(ventanaDos);
            ventana.setScene(scene);
            ControladorCrearEntrega controller = loader.getController();
            controller.setControladorPrincipal(controladorPrincipal);
            ventana.show();		
          
          
		}
		
		});

    }
       
}