package Ejercicio4_Estudiantes


class Estudiante(val nombre: String) {
    private val cursos = mutableListOf<Curso>()

    fun agregarCurso(curso: Curso) {
        cursos.add(curso)
    }

    fun calcularPromedio(): Double {
        // Si no hay cursos, el promedio es 0 (para evitar la división por 0)
        // Si hay cursos, se calcula la suma de las calificaciones y se divide por la cantidad de cursos
        // Se utiliza el método sumOf para sumar las calificaciones de los cursos
        // Se utiliza el método size para obtener la cantidad de cursos
        // Se utiliza el método calificacion para obtener la calificación de cada curso

        return if (cursos.isEmpty()) 0.0 else cursos.sumOf { it.calificacion } / cursos.size
    }

    override fun toString(): String {
        return "Estudiante(nombre='$nombre', promedio=${calcularPromedio()})"
    }
}