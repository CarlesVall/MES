package presentacion;

import java.net.URL;
import java.util.ResourceBundle;

import excepciones.DAOExcepcion;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.AlquilerVehiculos;
import logica.Sucursal;
import persistencia.SucursalDAOImp;

public class ControladorCrearSucursal extends ControladorCasoDeUso {
	@FXML
	private TextField id;
	@FXML
	private TextField direccion;
	@FXML
	private Button aceptar;
	@FXML
	private Button cancelar;
	private Sucursal nuevaSucursal;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			id.setText(SucursalDAOImp.buscarIdMaxReserva());
		} catch (DAOExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("CREAR SUCURSAL");
        cancelar.setOnAction(event -> stage.close());
        aceptar.setOnAction(event -> {
        	String error="";
        	if (direccion.getText().trim().length() == 0) {
                error += "Introduce la dirección\n";
            }
        	if (direccion.getText().trim().length() > 20) {
                error += "La longitud máxima para la dirección es de 20 carácteres\n";
            }
        	if(error.length()!=0){
        		Alert alerta = new Alert(AlertType.ERROR);
        		alerta.initStyle(StageStyle.UNIFIED);
				alerta.setContentText(error);
				alerta.setHeaderText("Error");
				alerta.showAndWait();
        	} else {
        		nuevaSucursal = new Sucursal(Integer.parseInt(id.getText()),direccion.getText());
        	}
        	if (nuevaSucursal != null){
        		AlquilerVehiculos.getAlquilerVehiculos().crearSucursal(nuevaSucursal);
        		Alert alerta = new Alert(AlertType.CONFIRMATION);
        		alerta.initStyle(StageStyle.UNIFIED);
				alerta.setContentText("Sucursal creada correctamente");
				alerta.setHeaderText("");
				alerta.showAndWait();
        		Stage stage = (Stage) aceptar.getScene().getWindow();
                stage.close();
        }
        });
	}

}
