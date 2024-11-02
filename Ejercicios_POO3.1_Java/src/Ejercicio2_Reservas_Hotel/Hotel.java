package Ejercicio2_Reservas_Hotel;


import java.util.ArrayList;
import java.util.List;
public class Hotel {
    private List<Habitacion> habitaciones = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    public void agregarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }

    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente registrado: " + cliente.getNombre() + " con ID " + cliente.getId());
    }

    public void registrarReserva(Cliente cliente, int numeroHabitacion) {
        Habitacion habitacion = buscarHabitacion(numeroHabitacion);
        if (habitacion != null && habitacion.isDisponible()) {
            habitacion.reservar();
            Reserva reserva = new Reserva(cliente, habitacion);
            reservas.add(reserva);
            System.out.println("Reserva realizada: " + reserva);
        } else {
            System.out.println("La habitación " + numeroHabitacion + " no está disponible.");
        }
    }

    public void cancelarReserva(Cliente cliente, int numeroHabitacion) {
        Reserva reserva = buscarReserva(cliente, numeroHabitacion);
        if (reserva != null) {
            reservas.remove(reserva);
            reserva.getHabitacion().liberar();
            System.out.println("Reserva cancelada para la habitación " + numeroHabitacion);
        } else {
            System.out.println("No se encontró una reserva para el cliente en la habitación " + numeroHabitacion);
        }
    }

    public void mostrarReservasActivas() {
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas activas.");
        } else {
            System.out.println("Reservas activas:");
            for (Reserva reserva : reservas) {
                System.out.println(reserva);
            }
        }
    }

    public Habitacion buscarHabitacion(int numero) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero() == numero) {
                return habitacion;
            }
        }
        return null;
    }

    public Reserva buscarReserva(Cliente cliente, int numeroHabitacion) {
        for (Reserva reserva : reservas) {
            if (reserva.getCliente().getId().equals(cliente.getId()) &&
                    reserva.getHabitacion().getNumero() == numeroHabitacion) {
                return reserva;
            }
        }
        return null;
    }

    public Cliente buscarClientePorId(String id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }
}