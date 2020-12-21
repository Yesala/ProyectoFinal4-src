package frontend.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ControllerLoginAdm {

    @FXML private TextField usuarionombre;
    @FXML private TextField contrasennausuario;
    @FXML private Label MostrarErrorUsuario;

    ControladorMain unControlador = new ControladorMain();

    public void iniciarSesion(ActionEvent event) {
        String nombre = usuarionombre.getText();
        String contrasenna = contrasennausuario.getText();

        int resultado = unControlador.iniciarSesionAdm(nombre,contrasenna);

        if (resultado == 0){
            new ToScene().toScene("administrador.fxml",event);
        }else{
            MostrarErrorUsuario.setText("Credenciales incorrectas");
        }
    }

    public void back(MouseEvent event) {
        new ToScene().toScene("pantallainicial.fxml", event);
    }

}
