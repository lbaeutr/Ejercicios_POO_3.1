package Ejercicio5_Tareas;

import java.util.ArrayList;
import java.util.List;

public class TareaUsuario {
    private String nombre;
    private List<Proyecto> proyectos;

    public TareaUsuario(String nombre) {
        this.nombre = nombre;
        this.proyectos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void crearProyecto(String nombreProyecto) {
        Proyecto nuevoProyecto = new Proyecto(nombreProyecto);
        proyectos.add(nuevoProyecto);
        System.out.println("Proyecto '" + nombreProyecto + "' creado.");
    }

    public Proyecto obtenerProyecto(String nombreProyecto) {
        for (Proyecto proyecto : proyectos) {
            if (proyecto.getNombre().equalsIgnoreCase(nombreProyecto)) {
                return proyecto;
            }
        }
        System.out.println("Proyecto '" + nombreProyecto + "' no encontrado.");
        return null;
    }

    public void mostrarProyectos() {
        System.out.println("Proyectos de " + nombre + ":");
        if (proyectos.isEmpty()) {
            System.out.println("No hay proyectos creados.");
        } else {
            for (Proyecto proyecto : proyectos) {
                System.out.println("- " + proyecto.getNombre());
            }
        }
    }
}