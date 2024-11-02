package Ejercicio4_Estudiantes;

public class Profesor {
    private String nombre;

    public Profesor(String nombre) {
        this.nombre = nombre;
    }

    public void asignarCurso(Estudiante estudiante, Curso curso) {
        estudiante.agregarCurso(curso);
        System.out.println("El curso " + curso.getNombre() + " ha sido asignado a " + estudiante.getNombre());
    }
}
