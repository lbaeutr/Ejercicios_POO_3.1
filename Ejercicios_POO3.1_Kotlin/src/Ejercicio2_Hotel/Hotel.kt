package Ejercicio2_Hotel


class Hotel {
    private val habitaciones = mutableListOf<Habitacion>()
    private val reservas = mutableListOf<Reserva>()
    private val clientes = mutableListOf<Cliente>()

    fun agregarHabitacion(habitacion: Habitacion) {
        habitaciones.add(habitacion)
    }

    fun registrarCliente(cliente: Cliente) {
        clientes.add(cliente)
        println("Cliente registrado: ${cliente.nombre} con ID ${cliente.id}")
    }

    fun registrarReserva(cliente: Cliente, numeroHabitacion: Int) {
        val habitacion = buscarHabitacion(numeroHabitacion)
        if (habitacion != null && habitacion.disponible) {
            habitacion.disponible = false
            val reserva = Reserva(cliente, habitacion)
            reservas.add(reserva)
            println("Reserva realizada: $reserva")
        } else {
            println("La habitación $numeroHabitacion no está disponible.")
        }
    }

    fun cancelarReserva(cliente: Cliente, numeroHabitacion: Int) {
        val reserva = buscarReserva(cliente, numeroHabitacion)
        if (reserva != null) {
            reservas.remove(reserva)
            reserva.habitacion.disponible = true
            println("Reserva cancelada para la habitación $numeroHabitacion")
        } else {
            println("No se encontró una reserva para el cliente en la habitación $numeroHabitacion")
        }
    }

    fun mostrarReservasActivas() {
        if (reservas.isEmpty()) {
            println("No hay reservas activas.")
        } else {
            println("Reservas activas:")
            reservas.forEach { println(it) }
        }
    }

    private fun buscarHabitacion(numero: Int): Habitacion? {
        return habitaciones.find { it.numero == numero }
    }

    private fun buscarReserva(cliente: Cliente, numeroHabitacion: Int): Reserva? {
        return reservas.find { it.cliente.id == cliente.id && it.habitacion.numero == numeroHabitacion }
    }

    fun buscarClientePorId(id: String): Cliente? {
        return clientes.find { it.id == id }
    }
}