package Ejercicio4_Estudiantes;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {
    private String nombre;
    private List<Curso> cursos;

    public Estudiante(String nombre) {
        this.nombre = nombre;
        this.cursos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }

    public double calcularPromedio() {
        double suma = 0;
        for (Curso curso : cursos) {
            suma += curso.getCalificacion();
        }
        return cursos.isEmpty() ? 0 : suma / cursos.size();
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", promedio=" + calcularPromedio() +
                '}';
    }
}
