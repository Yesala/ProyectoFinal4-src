package frontend.controllers;

import cr.ac.ucenfotec.ProyectoFinal.bl.entidades.Cancion;
import cr.ac.ucenfotec.ProyectoFinal.bl.entidades.CancionesLista;
import cr.ac.ucenfotec.ProyectoFinal.bl.entidades.Lista;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerTablaListCancion implements Initializable {

    @FXML private TableView<CancionesLista> tablaListaCancion;
    @FXML private TableColumn<CancionesLista, String> columnaNombreLista;
    @FXML private TableColumn<CancionesLista, String> columnaNombreCancion;

    ControladorMain unControlador = new ControladorMain();

    public void regresarHome(MouseEvent event) {
        new ToScene().toScene("home.fxml", event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        columnaNombreLista.setCellValueFactory(new PropertyValueFactory<>("lista"));
        columnaNombreCancion.setCellValueFactory(new PropertyValueFactory<>("cancion"));
        tablaListaCancion.setItems(unControlador.listarCancionesLista());
    }
}
