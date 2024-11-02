package Ejercicio2_Hotel

data class Reserva(val cliente: Cliente, val habitacion: Habitacion) {
    override fun toString(): String {
        return "Reserva de ${cliente.nombre} (ID: ${cliente.id}) en habitación ${habitacion.numero}."
    }
}

