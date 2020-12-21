package frontend.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class ControllerAdministrador {

    @FXML private Text Playislit;
    @FXML private Text registrar;
    @FXML private Text modificar;
    @FXML private Text eliminar;
    @FXML private TextField buscarGenComp;
    @FXML private TextField buscarArtist;
    @FXML private Text ventaCanciones;
    @FXML private Text salir;

    public void tienda(MouseEvent event) {
        new ToScene().toScene("tienda.fxml", event);
    }

    public void salirSesion(MouseEvent event) {
        new ToScene().toScene("pantallainicial.fxml",event);
    }

}
