package Ejercicio5_Tareas

data class Tarea(val nombre: String) {
    var completada: Boolean = false
        private set

    fun marcarComoCompletada() {
        completada = true
    }

    override fun toString(): String {
        return "Tarea(nombre='$nombre', completada=$completada)"
    }
}