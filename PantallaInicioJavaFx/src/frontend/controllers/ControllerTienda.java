package frontend.controllers;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class ControllerTienda {

    @FXML private Text back;

    public void regresar(MouseEvent event) {
        new ToScene().toScene("home.fxml", event);
    }

}
