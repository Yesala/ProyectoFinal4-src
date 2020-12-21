package frontend.controllers;

import cr.ac.ucenfotec.ProyectoFinal.bl.entidades.Artista;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerListaArtistas implements Initializable {

    @FXML private TableView<Artista> tablaArtistas;
    @FXML private TableColumn<Artista, String> columnaAliasArtista;
    @FXML private TableColumn<Artista, String> columnaPaisNacArtista;
    @FXML private TableColumn<Artista, Integer> columnaEdadArtista;
    @FXML private TableColumn<Artista, String> columnaGeneroArtista;

    ControladorMain unControlador = new ControladorMain();

    public void regresarHome(MouseEvent event) {
        new ToScene().toScene("home.fxml", event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        columnaAliasArtista.setCellValueFactory(new PropertyValueFactory<>("alias"));
        columnaPaisNacArtista.setCellValueFactory(new PropertyValueFactory<>("paisNacimiento"));
        columnaEdadArtista.setCellValueFactory(new PropertyValueFactory<>("edad"));
        columnaGeneroArtista.setCellValueFactory(new PropertyValueFactory<>("genero"));
        tablaArtistas.setItems(unControlador.listarArtistas());
    }
}
