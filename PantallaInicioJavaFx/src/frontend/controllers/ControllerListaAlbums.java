package frontend.controllers;

import cr.ac.ucenfotec.ProyectoFinal.bl.entidades.Album;
import cr.ac.ucenfotec.ProyectoFinal.bl.entidades.Artista;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ControllerListaAlbums implements Initializable {

    @FXML private TableView<Album> tablaAlbumes;
    @FXML private TableColumn<Album, String> columnaNombreAlbum;
    @FXML private TableColumn<Album, LocalDate> columnaFechaAlbum;

    ControladorMain unControlador = new ControladorMain();

    public void regresarHome(MouseEvent event) {
        new ToScene().toScene("home.fxml", event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        columnaNombreAlbum.setCellValueFactory(new PropertyValueFactory<>("nombreAlbum"));
        columnaFechaAlbum.setCellValueFactory(new PropertyValueFactory<>("fechaLanzamiento"));
        tablaAlbumes.setItems(unControlador.listarAlbum2());
    }
}
