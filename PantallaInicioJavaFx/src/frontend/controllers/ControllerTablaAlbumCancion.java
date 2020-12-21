package frontend.controllers;

import cr.ac.ucenfotec.ProyectoFinal.bl.entidades.CancionesAlbum;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerTablaAlbumCancion implements Initializable {

    @FXML private TableView<CancionesAlbum> tablaAlbumCancion;
    @FXML private TableColumn<CancionesAlbum, String> columnaNombreAlbum;
    @FXML private TableColumn<CancionesAlbum, String> columnaNombreCancion;

    ControladorMain unControlador = new ControladorMain();

    public void regresarHome(MouseEvent event) {
        new ToScene().toScene("home.fxml", event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        columnaNombreAlbum.setCellValueFactory(new PropertyValueFactory<>("album"));
        columnaNombreCancion.setCellValueFactory(new PropertyValueFactory<>("cancion"));
        tablaAlbumCancion.setItems(unControlador.listarCancionesAlbum());
    }
}
