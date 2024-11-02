package Ejercicio4_Estudiantes;

public class Curso {
    private String nombre;
    private double calificacion;

    public Curso(String nombre, double calificacion) {
        this.nombre = nombre;
        this.calificacion = calificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCalificacion() {
        return calificacion;
    }
}
