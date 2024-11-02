package Ejercicio5_Tareas


class Proyecto(val nombre: String) {
    private val tareas: MutableList<Tarea> = mutableListOf()

    fun agregarTarea(tarea: Tarea) {
        tareas.add(tarea)
    }

    fun mostrarTareas() {
        println("Tareas del proyecto '$nombre':")
        if (tareas.isEmpty()) {
            println("No hay tareas en este proyecto.")
        } else {
            for (tarea in tareas) {
                println(tarea)
            }
        }
    }

    fun marcarTareaComoCompletada(nombreTarea: String) {
        val tarea = tareas.find { it.nombre.equals(nombreTarea, ignoreCase = true) }
        if (tarea != null) {
            if (!tarea.completada) {
                tarea.marcarComoCompletada()
                println("Tarea '$nombreTarea' marcada como completada.")
            } else {
                println("La tarea '$nombreTarea' ya está completada.")
            }
        } else {
            println("Tarea '$nombreTarea' no encontrada.")
        }
    }
}