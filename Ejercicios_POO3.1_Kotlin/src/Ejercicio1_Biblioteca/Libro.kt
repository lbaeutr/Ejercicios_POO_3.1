package Ejercicio1_Biblioteca


class Libro(val titulo: String, val autor: String) {
    var prestado: Boolean = false
        private set

    fun prestar() {
        prestado = true
    }

    fun devolver() {
        prestado = false
    }
}
