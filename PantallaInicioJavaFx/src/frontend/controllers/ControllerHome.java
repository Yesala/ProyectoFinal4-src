package frontend.controllers;

import cr.ac.ucenfotec.ProyectoFinal.gestor.Gestor;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ControllerHome {

    public void agregarCancion(MouseEvent mouseEvent) {
        new ToScene().toScene("agregarCancion.fxml", mouseEvent);
    }

    public void agregarArtista(MouseEvent mouseEvent) {
        new ToScene().toScene("registroArtista.fxml", mouseEvent);
    }

    public void agregarCompositor(MouseEvent mouseEvent) {
        new ToScene().toScene("registroCompositor.fxml", mouseEvent);
    }

    public void agregarGenero(MouseEvent mouseEvent) {
        new ToScene().toScene("registroGeneroMus.fxml", mouseEvent);
    }

    public void agregarLista(MouseEvent mouseEvent) {
        new ToScene().toScene("crearLista.fxml", mouseEvent);
    }

    public void agregarAlbum(MouseEvent mouseEvent) {
        new ToScene().toScene("crearAlbum.fxml", mouseEvent);
    }

    public void listarAlbums(MouseEvent event) {
        new ToScene().toScene("tablaCancionesAlbum.fxml", event);
    }

    public void verListas(MouseEvent event) {
        new ToScene().toScene("listarPlaylist.fxml", event);
    }

    public void listarArtistas(MouseEvent event) {
        new ToScene().toScene("listarArtistas.fxml", event);
    }

    public void verTablaCancionesLista(MouseEvent event) {
        new ToScene().toScene("tablaCancionesLista.fxml",event);
    }

    public void listSongs(MouseEvent event) {
        new ToScene().toScene("listSongs.fxml", event);
    }

    public void tienda(MouseEvent event) {
        new ToScene().toScene("tienda.fxml", event);
    }

    public void closeSesion(MouseEvent mouseEvent) {
        new ToScene().toScene("pantallainicial.fxml", mouseEvent);
    }

}
