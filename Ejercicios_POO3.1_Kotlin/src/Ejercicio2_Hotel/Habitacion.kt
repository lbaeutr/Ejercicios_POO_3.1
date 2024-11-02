package Ejercicio2_Hotel

data class Habitacion(val numero: Int, var disponible: Boolean = true) {
    override fun toString(): String {
        return "Habitación(numero=$numero, disponible=$disponible)"
    }
}