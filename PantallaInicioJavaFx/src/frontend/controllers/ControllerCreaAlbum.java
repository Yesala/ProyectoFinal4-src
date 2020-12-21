package frontend.controllers;

import cr.ac.ucenfotec.ProyectoFinal.bl.entidades.Album;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.CheckComboBox;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ControllerCreaAlbum implements Initializable {

    @FXML private TextField nombreAlbum;
    @FXML private DatePicker fechaLanzamiento;
    @FXML private TextField fotografia;
    @FXML private TextField nombreArtista;
    @FXML private Button BotonCrearAlbum;
    @FXML private CheckComboBox listaCancionesAlbum;

    ControladorMain unControlador = new ControladorMain();

    public void crearAlbum(ActionEvent actionEvent) throws SQLException {
        String nombre = nombreAlbum.getText();
        LocalDate fechaLanzam = fechaLanzamiento.getValue();
        String foto = fotografia.getText();
        String nombreArtist = nombreArtista.getText();
        ObservableList list=listaCancionesAlbum.getCheckModel().getCheckedItems();
        String nombres[]=new String[list.size()];
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
            nombres[i]= String.valueOf(list.get(i));
        }
        unControlador.agruparAlbum(nombre,fechaLanzam,foto,nombreArtist);
        unControlador.listaCancion(nombres,nombre);
    }

    public void regresarHome(MouseEvent mouseEvent) {
        new ToScene().toScene("home.fxml",mouseEvent);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < unControlador.listarCanciones2().length ; i++) {
            listaCancionesAlbum.getItems().addAll(unControlador.listarCanciones2()[i]);
        }
    }
}
