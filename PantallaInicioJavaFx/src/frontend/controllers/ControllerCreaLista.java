package frontend.controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.CheckComboBox;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ControllerCreaLista implements Initializable {

    @FXML private Button BotonCrearLista;
    @FXML private TextField nombreLista;
    @FXML private DatePicker fechaLanzamiento;
    @FXML private CheckComboBox listaCancionesPlaylist;

    ControladorMain unControlador = new ControladorMain();

    public void crearLista(ActionEvent actionEvent) throws SQLException {

        String nombreList = nombreLista.getText();
        LocalDate fechaLanzam = fechaLanzamiento.getValue();
        ObservableList list=listaCancionesPlaylist.getCheckModel().getCheckedItems();
        String nombres[]=new String[list.size()];
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
            nombres[i]= String.valueOf(list.get(i));
        }
        unControlador.crearLista(nombreList,fechaLanzam);
        unControlador.listaCancionPlaylist(nombres,nombreList);
    }

    public void regresarHome(MouseEvent mouseEvent) {
        new ToScene().toScene("home.fxml",mouseEvent);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < unControlador.listarCanciones2().length ; i++) {
            listaCancionesPlaylist.getItems().addAll(unControlador.listarCanciones2()[i]);
        }
    }

}
