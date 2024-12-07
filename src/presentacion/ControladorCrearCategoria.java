package presentacion;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.AlquilerVehiculos;
import logica.Categoria;

public class ControladorCrearCategoria extends ControladorCasoDeUso {
	@FXML
	private TextField nombre;
	@FXML
	private TextField precioModIlimitada;
	@FXML
	private TextField precioModKms;
	@FXML
	private TextField precioSeguroTRiesgo;
	@FXML
	private TextField precioSeguroTerceros;
	@FXML
	private ComboBox<String> categoriaSuperior;
	@FXML
	private TextField precioKmModKms;
	@FXML
	private Button aceptar;
	@FXML
	private Button cancelar;
	private Categoria nuevaCategoria;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("CREAR CATEGORIA");
        List<Categoria> listaCategoria = null;
		listaCategoria = AlquilerVehiculos.getAlquilerVehiculos().listarCategorias();
        for(Categoria cat : listaCategoria){
        	categoriaSuperior.getItems().add(cat.getNombre());
        }
        cancelar.setOnAction(event -> stage.close());
        aceptar.setOnAction(event -> {
        	String error="";
        	if (nombre.getText().trim().length() == 0) {
                error += "Introduce la dirección\n";
            }
        	if (nombre.getText().trim().length() > 20) {
                error += "La longitud máxima para el nombre es de 20 carácteres\n";
            }
        	if (precioModIlimitada.getText().trim().length() == 0) {
                error += "Introduce el precioModIlimitada\n";
            }
        	if (precioModKms.getText().trim().length() == 0) {
                error += "Introduce el precioModKms\n";
            }
        	if (precioSeguroTRiesgo.getText().trim().length() == 0) {
                error += "Introduce el precio del seguro a Todo Riesgo\n";
            }
        	if (precioSeguroTerceros.getText().trim().length() == 0) {
                error += "Introduce el precio del seguro a Terceros\n";
            }
        	if (categoriaSuperior.getValue() == null) {
                error += "Seleccione la categoria superior\n";
            }
        	if (precioModKms.getText().trim().length() == 0) {
                error += "Introduce el precioModKms\n";
            }
        	if(error.length()!=0){
        		Alert alerta = new Alert(AlertType.ERROR);
        		alerta.initStyle(StageStyle.UNIFIED);
				alerta.setContentText(error);
				alerta.setHeaderText("Error");
				alerta.showAndWait();
        	} else {
        		nuevaCategoria = new Categoria(nombre.getText(),Double.parseDouble(precioModIlimitada.getText()),Double.parseDouble(precioModKms.getText()),Double.parseDouble(precioSeguroTRiesgo.getText()),Double.parseDouble(precioSeguroTerceros.getText()),Double.parseDouble(precioKmModKms.getText()),categoriaSuperior.getValue());
        	}
        	if (nuevaCategoria != null){
        		AlquilerVehiculos.getAlquilerVehiculos().crearCategoria(nuevaCategoria);
        		Alert alerta = new Alert(AlertType.CONFIRMATION);
        		alerta.initStyle(StageStyle.UNIFIED);
				alerta.setContentText("Categoria creada correctamente");
				alerta.setHeaderText("");
				alerta.showAndWait();
        		Stage stage = (Stage) aceptar.getScene().getWindow();
                stage.close();
        	}
        });
        
		
	}
}
