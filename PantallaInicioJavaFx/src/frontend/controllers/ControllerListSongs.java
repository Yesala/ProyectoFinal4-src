package frontend.controllers;

import cr.ac.ucenfotec.ProyectoFinal.bl.entidades.Cancion;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerListSongs implements Initializable {

    @FXML private TableView<Cancion> tablaSongs;
    @FXML private TableColumn<Cancion, String> columnaNombreCancion;
    @FXML private TableColumn<Cancion, String> columnaNombreArtista;

    ControladorMain unControlador = new ControladorMain();

    public void regresarHome(MouseEvent event) {
        new ToScene().toScene("home.fxml", event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        columnaNombreCancion.setCellValueFactory(new PropertyValueFactory<>("nombreCancion"));
        columnaNombreArtista.setCellValueFactory(new PropertyValueFactory<>("artista"));
        tablaSongs.setItems(unControlador.listarSongs());
    }
}
