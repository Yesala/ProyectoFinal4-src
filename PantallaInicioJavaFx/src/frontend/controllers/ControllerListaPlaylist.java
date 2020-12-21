package frontend.controllers;

import cr.ac.ucenfotec.ProyectoFinal.bl.entidades.Lista;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ControllerListaPlaylist implements Initializable {

    @FXML private TableView<Lista> tablaPlaylist;
    @FXML private TableColumn<Lista, String> columnaNombreLista;
    @FXML private TableColumn<Lista, LocalDate> columnaFechaLista;

    ControladorMain unControlador = new ControladorMain();

    public void regresarHome(MouseEvent event) {
        new ToScene().toScene("home.fxml", event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        columnaNombreLista.setCellValueFactory(new PropertyValueFactory<>("nombreLista"));
        columnaFechaLista.setCellValueFactory(new PropertyValueFactory<>("fechaCreacion"));
        tablaPlaylist.setItems(unControlador.listarPlaylist());
    }
}
