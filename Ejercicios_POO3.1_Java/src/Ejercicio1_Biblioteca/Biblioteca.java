package Ejercicio1_Biblioteca;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Biblioteca {
    private List<Libro> libros = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private Map<Usuario, List<Libro>> prestamos = new HashMap<>();

    public void agregarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("Libro agregado: " + libro.getTitulo());
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuario registrado: " + usuario.getNombre());
    }

    public void prestarLibro(Usuario usuario, String tituloLibro) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(tituloLibro)) {
                if (libro.isPrestado()) {
                    System.out.println("El libro '" + tituloLibro + "' ya está prestado.");
                } else {
                    libro.prestar();
                    prestamos.computeIfAbsent(usuario, k -> new ArrayList<>()).add(libro);
                    System.out.println("Libro '" + tituloLibro + "' prestado a " + usuario.getNombre());
                }
                return;
            }
        }
        System.out.println("El libro '" + tituloLibro + "' no está disponible en la biblioteca.");
    }

    public void devolverLibro(Usuario usuario, String tituloLibro) {
        List<Libro> librosPrestados = prestamos.get(usuario);
        if (librosPrestados != null) {
            for (Libro libro : librosPrestados) {
                if (libro.getTitulo().equalsIgnoreCase(tituloLibro)) {
                    libro.devolver();
                    librosPrestados.remove(libro);
                    System.out.println("Libro '" + tituloLibro + "' devuelto por " + usuario.getNombre());
                    return;
                }
            }
        }
        System.out.println("El usuario " + usuario.getNombre() + " no tiene prestado el libro '" + tituloLibro + "'.");
    }

    public Usuario buscarUsuarioPorId(String id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        System.out.println("Usuario no encontrado.");
        return null;
    }
}