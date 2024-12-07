package presentacion;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.AlquilerVehiculos;
import logica.Categoria;

public class ControladorListarCategorias extends ControladorCasoDeUso {
	

    @FXML
    private TableColumn<Categoria, String> categoriaSuperior;
    @FXML
    private TableColumn<Categoria, Double> precioKmModKms;
    @FXML
    private TableColumn<Categoria, Double> precioSeguroTerceros;
    @FXML
    private TableView<Categoria> categorias;
    @FXML
    private TableColumn<Categoria, Double> precioSeguroTRiesgo;
    @FXML
    private Button aceptar;
    @FXML
    private TableColumn<Categoria, Double> precioModKms;
    @FXML
    private TableColumn<Categoria, String> nombre;
    @FXML
    private TableColumn<Categoria, Double> precioModIlimitada;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		stage = new Stage(StageStyle.DECORATED); 
		stage.setTitle("LISTADO DE CATEGORIAS"); 
		aceptar.setOnAction(event -> stage.close()); 
		nombre.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getNombre().trim()));
		categoriaSuperior.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getSuperior()));
		precioKmModKms.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getPrecioKmModKms()));
		precioSeguroTerceros.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getPrecioSeguroTerceros()));
		precioSeguroTRiesgo.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getPrecioSeguroTRiesgo()));
		precioModKms.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getPrecioModKms()));
		precioModIlimitada.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getPrecioModIlimitada()));
		this.categorias.getItems().addAll(AlquilerVehiculos.getAlquilerVehiculos().listarCategorias()); 
	}

}
