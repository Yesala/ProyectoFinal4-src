package frontend.controllers;

import cr.ac.ucenfotec.ProyectoFinal.bl.entidades.*;
import cr.ac.ucenfotec.ProyectoFinal.gestor.Gestor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class ControladorMain {

    private Gestor gestor = new Gestor();

    public int iniciarSesion(String nombre, String contrasenna){
        int resultado = 0;

        List<UsuarioFinal> unUsuarioFinal = null;
        unUsuarioFinal = gestor.findAllUsuarioFinal();
        for(UsuarioFinal unoUsuarioFinal : unUsuarioFinal){
            if(unoUsuarioFinal.getNombreUsuarioFinal().equals(nombre) && unoUsuarioFinal.getContrasenna().equals(contrasenna)){
                resultado = 0;
                break;
            }else{
                resultado++;
            }
        }
        return resultado;
    }

    public int iniciarSesionAdm(String nombre, String contrasenna){
            int resultado = 0;
            List<Administrador> unAdministrador = null;
            unAdministrador = gestor.findAdministrador();
            for(Administrador unoAdministrador : unAdministrador){
                if(unoAdministrador.getNombreUsuario().equals(nombre) && unoAdministrador.getContrasenna().equals(contrasenna)){
                    break;
                }else{
                    resultado++;
                }
            }
            return resultado;
        }

    public void crearUsuario(String nombre, String apellido1, String apellido2, String identificacion, String paisProcedencia, Integer edad, String correoElectronico, String foto, String nombreUsuarioFinal, String contrasenna ) {
        gestor.crearUsuario(nombre,apellido1,apellido2,identificacion,paisProcedencia,edad,correoElectronico,foto,nombreUsuarioFinal,contrasenna);
    }

    public void agregarArtistas(String nombre, String apellido1, String apellido2, String alias, String paisNacimiento, LocalDate fechaNacimiento, LocalDate fechaDefuncion, Integer edad, String nombreGenero, String referencia) {
        gestor.agregarArtista(nombre,apellido1,apellido2,alias,paisNacimiento,String.valueOf(fechaNacimiento),String.valueOf(fechaDefuncion),edad,nombreGenero,referencia);
    }

    public void agregarCompositores(String nombre, String apellido1, String apellido2,String paisNacimiento,Integer edad, String nombreGenero) {
        gestor.agregarCompositor(nombre,apellido1,apellido2,paisNacimiento,edad,nombreGenero);
    }

    public void agregarGeneros(String nombreGenero) {
        gestor.agregarGenero(nombreGenero);
    }

    public void crearCancion(String nombreCancion, String nombreArtista) {
        gestor.crearCancion(nombreCancion,nombreArtista);
    }

    public void crearLista(String nombreLista, LocalDate fechaLista){
        gestor.crearLista(nombreLista, String.valueOf(fechaLista));
    }

    public void agruparAlbum(String nombreAlbum, LocalDate fechaLanzam, String imagen, String artista){
        gestor.agregarAlbum(nombreAlbum, String.valueOf(fechaLanzam),imagen,artista);
    }

    public String[] listarCanciones2() {
        int i = 0;
        List<Cancion> unCancion = gestor.findCanciones();
        String [] listarCancion = new String[unCancion.size()];
        for(Cancion unaCancion : unCancion){
            listarCancion[i] = unaCancion.getNombreCancion();
            i++;
        }
        return listarCancion;
    }

    public void listaCancion(String [] lista, String nombre) throws SQLException {
        CancionesAlbum cancionAlbum = new CancionesAlbum();
        Cancion song = new Cancion();
        Album albums = new Album();
        for (int i = 0; i < lista.length; i++) {
            song.setNombreCancion(lista[i]);
            albums.setNombreAlbum(nombre);
            cancionAlbum.setAlbum(albums);
            cancionAlbum.setCancion(song);
            gestor.listaCancion1(cancionAlbum);
        }
    }

    public void listaCancionPlaylist(String [] lista, String nombre) throws SQLException {
        CancionesLista cancionLista = new CancionesLista();
        Cancion song = new Cancion();
        Lista list = new Lista();
        for (int i = 0; i < lista.length; i++) {
            song.setNombreCancion(lista[i]);
            list.setNombreLista(nombre);
            cancionLista.setLista(list);
            cancionLista.setCancion(song);
            gestor.listaCancion2(cancionLista);
        }
    }

    public ObservableList<Album> listarAlbum2() {
        int i = 0;
        List<Album> unAlbum = gestor.findAlbum();
        ObservableList<Album> listaAlbumes =  FXCollections.observableArrayList();;
        for(Album unoAlbum : unAlbum){
            listaAlbumes.add(unoAlbum);
        }
        return listaAlbumes;
    }

    public ObservableList<Lista> listarPlaylist() {
        int i = 0;
        List<Lista> unLista = gestor.findListas();
        ObservableList<Lista> listaListas =  FXCollections.observableArrayList();;
        for(Lista unoLista : unLista){
            listaListas.add(unoLista);
        }
        return listaListas;
    }

    public ObservableList<Artista> listarArtistas() {
        int i = 0;
        List<Artista> unArtista = gestor.findArtista();
        ObservableList<Artista> listaArtistas =  FXCollections.observableArrayList();;
        for(Artista unoArtista : unArtista){
            listaArtistas.add(unoArtista);
        }
        return listaArtistas;
    }

    public ObservableList<CancionesLista> listarCancionesLista() {
        int i = 0;
        List<CancionesLista> unCancionLista = gestor.findCancionesLista();
        ObservableList<CancionesLista> listaTCancionesLista =  FXCollections.observableArrayList();;
        for(CancionesLista unoCancionesLista : unCancionLista){
            listaTCancionesLista.add(unoCancionesLista);
        }
        return listaTCancionesLista;
    }

    public ObservableList<CancionesAlbum> listarCancionesAlbum() {
        int i = 0;
        List<CancionesAlbum> unCancionAlbum = gestor.findCancionesAlbum();
        ObservableList<CancionesAlbum> listaTCancionesAlbum =  FXCollections.observableArrayList();;
        for(CancionesAlbum unoCancionesAlbum : unCancionAlbum){
            listaTCancionesAlbum.add(unoCancionesAlbum);
        }
        return listaTCancionesAlbum;
    }

    public ObservableList<Cancion> listarSongs() {
        int i = 0;
        List<Cancion> unCancion = gestor.findCanciones();
        ObservableList<Cancion> listaSong =  FXCollections.observableArrayList();;
        for(Cancion unaCancion : unCancion){
            listaSong.add(unaCancion);
        }
        return listaSong;
    }


}
