import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Ejercicio1_Biblioteca.Biblioteca;
import Ejercicio1_Biblioteca.Libro;
import Ejercicio1_Biblioteca.Usuario;
import Ejercicio2_Reservas_Hotel.Cliente;
import Ejercicio2_Reservas_Hotel.Habitacion;
import Ejercicio2_Reservas_Hotel.Hotel;
import Ejercicio3_JuegoRol.*;
import Ejercicio4_Estudiantes.Curso;
import Ejercicio4_Estudiantes.Estudiante;
import Ejercicio4_Estudiantes.Profesor;
import Ejercicio5_Tareas.Proyecto;
import Ejercicio5_Tareas.Tarea;
import Ejercicio5_Tareas.TareaUsuario;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcionMenu;

        do {
            System.out.println("Bienvenido a la segunda tanda de ejercicios de HLC");
            System.out.println("Elige una opcion: ");
            System.out.println("1. Ejercicio 1");
            System.out.println("2. Ejercicio 2");
            System.out.println("3. Ejercicio 3");
            System.out.println("4. Ejercicio 4");
            System.out.println("5. Ejercicio 5");
            System.out.println("6. Salir");
            System.out.print("Introduce una opcion: ");

            opcionMenu = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea

            switch (opcionMenu) {
                case 1:
                    System.out.println("Ejercicio 1: Ejercicio Biblioteca");
                    Biblioteca biblioteca = new Biblioteca();
                    System.out.println("Bienvenido al Sistema de Gestión de Biblioteca");

                    while (true) {
                        System.out.println("\nSeleccione una opción:");
                        System.out.println("1. Agregar libro");
                        System.out.println("2. Registrar usuario");
                        System.out.println("3. Prestar libro");
                        System.out.println("4. Devolver libro");
                        System.out.println("5. Salir");
                        int opcion = sc.nextInt();
                        sc.nextLine(); // Consumir el salto de línea

                        switch (opcion) {
                            case 1:
                                System.out.print("Ingrese el título del libro: ");
                                String titulo = sc.nextLine();
                                System.out.print("Ingrese el autor del libro: ");
                                String autor = sc.nextLine();
                                biblioteca.agregarLibro(new Libro(titulo, autor));
                                break;

                            case 2:
                                System.out.print("Ingrese el nombre del usuario: ");
                                String nombre = sc.nextLine();
                                System.out.print("Ingrese el ID del usuario: ");
                                String id = sc.nextLine();
                                biblioteca.registrarUsuario(new Usuario(nombre, id));
                                break;

                            case 3:
                                System.out.print("Ingrese el ID del usuario: ");
                                String userId = sc.nextLine();
                                Usuario usuario = biblioteca.buscarUsuarioPorId(userId);
                                if (usuario != null) {
                                    System.out.print("Ingrese el título del libro a prestar: ");
                                    String tituloPrestamo = sc.nextLine();
                                    biblioteca.prestarLibro(usuario, tituloPrestamo);
                                }
                                break;

                            case 4:
                                System.out.print("Ingrese el ID del usuario: ");
                                String userIdDevolucion = sc.nextLine();
                                Usuario usuarioDevolucion = biblioteca.buscarUsuarioPorId(userIdDevolucion);
                                if (usuarioDevolucion != null) {
                                    System.out.print("Ingrese el título del libro a devolver: ");
                                    String tituloDevolucion = sc.nextLine();
                                    biblioteca.devolverLibro(usuarioDevolucion, tituloDevolucion);
                                }
                                break;

                            case 5:
                                System.out.println("Saliendo del sistema de biblioteca...");
                                break;

                            default:
                                System.out.println("Opción inválida. Intente de nuevo.");
                        }

                        if (opcion == 5) {
                            break; // Salir del bucle de biblioteca
                        }
                    }
                    break;

                case 2:
                    System.out.println("Ejercicio 2: Ejercicio Hotel");
                    int opcionMenuHotel = 0;
                    Hotel hotel = new Hotel();
                    hotel.agregarHabitacion(new Habitacion(101));
                    hotel.agregarHabitacion(new Habitacion(102));
                    hotel.agregarHabitacion(new Habitacion(103));
                    hotel.agregarHabitacion(new Habitacion(69));

                    do {
                        System.out.println("\nSeleccione una opción:");
                        System.out.println("1. Registrar cliente");
                        System.out.println("2. Registrar reserva");
                        System.out.println("3. Cancelar reserva");
                        System.out.println("4. Mostrar reservas activas");
                        System.out.println("5. Salir");
                        opcionMenuHotel = sc.nextInt();
                        sc.nextLine(); // Consumir el salto de línea

                        switch (opcionMenuHotel) {
                            case 1:
                                System.out.print("Ingrese el nombre del cliente: ");
                                String nombreCliente = sc.nextLine();
                                System.out.print("Ingrese el ID del cliente: ");
                                String idCliente = sc.nextLine();
                                Cliente cliente = new Cliente(nombreCliente, idCliente);
                                hotel.registrarCliente(cliente);
                                break;

                            case 2:
                                System.out.print("Ingrese el ID del cliente: ");
                                String idClienteReserva = sc.nextLine();
                                Cliente clienteReserva = hotel.buscarClientePorId(idClienteReserva);
                                if (clienteReserva == null) {
                                    System.out.println("Cliente no encontrado. Debe registrar el cliente primero.");
                                    break;
                                }
                                System.out.print("Ingrese el número de la habitación a reservar: ");
                                int numeroHabitacion = sc.nextInt();
                                hotel.registrarReserva(clienteReserva, numeroHabitacion);
                                break;

                            case 3:
                                System.out.print("Ingrese el ID del cliente: ");
                                String idClienteCancelacion = sc.nextLine();
                                Cliente clienteCancelacion = hotel.buscarClientePorId(idClienteCancelacion);
                                if (clienteCancelacion == null) {
                                    System.out.println("Cliente no encontrado.");
                                    break;
                                }
                                System.out.print("Ingrese el número de la habitación a cancelar: ");
                                int numeroHabitacionCancelacion = sc.nextInt();
                                hotel.cancelarReserva(clienteCancelacion, numeroHabitacionCancelacion);
                                break;

                            case 4:
                                hotel.mostrarReservasActivas();
                                break;

                            case 5:
                                System.out.println("Saliendo del sistema de hotel...");
                                break;

                            default:
                                System.out.println("Opción inválida. Intente de nuevo.");
                        }

                    } while (opcionMenuHotel != 5);
                    break;

                case 3:
                    System.out.println("Ejercicio 3 - Juego de Rol");
                    Guerrero guerrero = new Guerrero("Thor", 100);
                    Mago mago = new Mago("Gandalf", 80);
                    Hechizo hechizoFuego = new Hechizo("Bola de Fuego", 25, 15);

                    // Simulación de un combate
                    while (guerrero.estaVivo() && mago.estaVivo()) {
                        // Guerrero ataca
                        int danoGuerrero = guerrero.atacar();
                        mago.puntosVida -= danoGuerrero;
                        System.out.println(mago + " recibe " + danoGuerrero + " de daño. Puntos de vida restantes: " + mago.puntosVida);

                        // Mago ataca o usa un hechizo
                        if (mago.estaVivo()) {
                            if (mago.puntosVida < 50) { // Elige usar hechizo si está bajo de vida
                                mago.usarHechizo(hechizoFuego);
                            } else {
                                int danoMago = mago.atacar();
                                guerrero.puntosVida -= danoMago;
                                System.out.println(guerrero + " recibe " + danoMago + " de daño. Puntos de vida restantes: " + guerrero.puntosVida);
                            }
                        }

                        System.out.println();
                    }

                    // Mensaje final
                    if (!guerrero.estaVivo()) {
                        System.out.println(guerrero + " ha sido derrotado!");
                    }
                    if (!mago.estaVivo()) {
                        System.out.println(mago + " ha sido derrotado!");
                    }
                    break;

                case 4:
                    System.out.println("Ejercicio 4: Ejercicio Estudiantes");

                    List<Estudiante> estudiantes = new ArrayList<>();

                    // Ingreso del nombre del profesor
                    System.out.print("Ingrese el nombre del profesor: ");
                    String nombreProfesor = sc.nextLine();
                    Profesor profesor = new Profesor(nombreProfesor);

                    // Registro de estudiantes
                    String continuar;
                    do {
                        System.out.print("Ingrese el nombre del estudiante: ");
                        String nombreEstudiante = sc.nextLine();
                        Estudiante estudiante = new Estudiante(nombreEstudiante);
                        estudiantes.add(estudiante);

                        // Asignación de curso
                        System.out.print("Ingrese el nombre del curso: ");
                        String nombreCurso = sc.nextLine();
                        System.out.print("Ingrese la calificación del curso: ");
                        double calificacionCurso = Double.parseDouble(sc.nextLine());

                        Curso curso = new Curso(nombreCurso, calificacionCurso);
                        estudiante.agregarCurso(curso);
                        System.out.println("Curso asignado a " + nombreEstudiante + ".");

                        // Preguntar si se desea continuar ingresando estudiantes
                        System.out.print("¿Desea agregar otro estudiante? (si/no): ");
                        continuar = sc.nextLine();

                    } while (continuar.equalsIgnoreCase("si"));

                    // Mostrar resumen de estudiantes
                    System.out.println("\nResumen de estudiantes:");
                    for (Estudiante est : estudiantes) {
                        System.out.println(est);
                    }


                    break;

                case 5:
                    System.out.println("Ejercicio 5: Ejercicio Tareas  ");


                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Introduce tu nombre: ");
                    String nombreUsuario = scanner.nextLine();
                    TareaUsuario usuario = new TareaUsuario(nombreUsuario);

                    while (true) {
                        System.out.println("\n1. Crear Proyecto");
                        System.out.println("2. Mostrar Proyectos");
                        System.out.println("3. Agregar Tarea a Proyecto");
                        System.out.println("4. Mostrar Tareas de Proyecto");
                        System.out.println("5. Marcar Tarea como Completada");
                        System.out.println("6. Salir");
                        System.out.print("Selecciona una opción: ");
                        int opcion = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer

                        switch (opcion) {
                            case 1:
                                System.out.print("Introduce el nombre del proyecto: ");
                                String nombreProyecto = scanner.nextLine();
                                usuario.crearProyecto(nombreProyecto);
                                break;
                            case 2:
                                usuario.mostrarProyectos();
                                break;
                            case 3:
                                System.out.print("Introduce el nombre del proyecto: ");
                                String proyectoNombre = scanner.nextLine();
                                Proyecto proyecto = usuario.obtenerProyecto(proyectoNombre);
                                if (proyecto != null) {
                                    System.out.print("Introduce el nombre de la tarea: ");
                                    String nombreTarea = scanner.nextLine();
                                    proyecto.agregarTarea(new Tarea(nombreTarea));
                                }
                                break;
                            case 4:
                                System.out.print("Introduce el nombre del proyecto: ");
                                String proyectoTareasNombre = scanner.nextLine();
                                Proyecto proyectoTareas = usuario.obtenerProyecto(proyectoTareasNombre);
                                if (proyectoTareas != null) {
                                    proyectoTareas.mostrarTareas();
                                }
                                break;
                            case 5:
                                System.out.print("Introduce el nombre del proyecto: ");
                                String proyectoCompletadaNombre = scanner.nextLine();
                                Proyecto proyectoCompletada = usuario.obtenerProyecto(proyectoCompletadaNombre);
                                if (proyectoCompletada != null) {
                                    System.out.print("Introduce el nombre de la tarea a marcar como completada: ");
                                    String nombreTareaCompletada = scanner.nextLine();
                                    proyectoCompletada.marcarTareaComoCompletada(nombreTareaCompletada);
                                }
                                break;
                            case 6:
                                System.out.println("Saliendo del gestor de tareas...");
                                scanner.close();
                                return;
                            default:
                                System.out.println("Opción no válida. Intenta de nuevo.");
                        }
                    }

                            case 6:
                                System.out.println("Saliendo del programa...");
                                break;

                            default:
                                System.out.println("Opción inválida. Intente de nuevo.");


                        }




        } while (opcionMenu != 6);
    }
}






