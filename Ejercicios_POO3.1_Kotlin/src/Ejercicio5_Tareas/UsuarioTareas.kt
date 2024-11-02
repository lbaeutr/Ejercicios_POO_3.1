package Ejercicio5_Tareas


class UsuarioTareas(val nombre: String) {
    private val proyectos: MutableList<Proyecto> = mutableListOf()

    fun crearProyecto(nombreProyecto: String) {
        val nuevoProyecto = Proyecto(nombreProyecto)
        proyectos.add(nuevoProyecto)
        println("Proyecto '$nombreProyecto' creado.")
    }

    fun obtenerProyecto(nombreProyecto: String): Proyecto? {
        return proyectos.find { it.nombre.equals(nombreProyecto, ignoreCase = true) }
    }

    fun mostrarProyectos() {
        println("Proyectos de $nombre:")
        if (proyectos.isEmpty()) {
            println("No hay proyectos creados.")
        } else {
            for (proyecto in proyectos) {
                println("- ${proyecto.nombre}")
            }
        }
    }
}