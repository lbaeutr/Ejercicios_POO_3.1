package Ejercicio5_Tareas;


import java.util.ArrayList;
import java.util.List;

public class Proyecto {
    private String nombre;
    private List<Tarea> tareas;

    public Proyecto(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del proyecto no puede estar vacío.");
        }
        this.nombre = nombre;
        this.tareas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    public void mostrarTareas() {
        System.out.println("Tareas del proyecto '" + nombre + "':");
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas en este proyecto.");
        } else {
            for (Tarea tarea : tareas) {
                System.out.println(tarea);
            }
        }
    }

    public void marcarTareaComoCompletada(String nombreTarea) {
        for (Tarea tarea : tareas) {
            if (tarea.getNombre().equalsIgnoreCase(nombreTarea)) {
                if (!tarea.isCompletada()) {
                    tarea.marcarComoCompletada();
                    System.out.println("Tarea '" + nombreTarea + "' marcada como completada.");
                } else {
                    System.out.println("La tarea '" + nombreTarea + "' ya está completada.");
                }
                return;
            }
        }
        System.out.println("Tarea '" + nombreTarea + "' no encontrada.");
    }
}