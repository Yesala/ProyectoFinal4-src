package frontend.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ControllerRegGeneroMus {

    @FXML private TextField generoMusical;
    @FXML private Button registroGeneroMus;

    ControladorMain unControlador = new ControladorMain();

    public void registroGeneroMus(ActionEvent actionEvent) {
        String genero = generoMusical.getText();
        unControlador.agregarGeneros(genero);
    }

    public void back(MouseEvent event) {
        new ToScene().toScene("home.fxml", event);
    }
}
