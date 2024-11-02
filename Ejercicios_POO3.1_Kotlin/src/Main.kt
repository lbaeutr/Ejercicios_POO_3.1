import Ejercicio1_Biblioteca.Biblioteca
import Ejercicio1_Biblioteca.Libro
import Ejercicio1_Biblioteca.Usuario
import Ejercicio2_Hotel.Cliente
import Ejercicio2_Hotel.Hotel
import Ejercicio2_Hotel.Habitacion
import Ejercicio3_JuegoRol.Guerrero
import Ejercicio3_JuegoRol.Hechizo
import Ejercicio3_JuegoRol.Mago
import Ejercicio4_Estudiantes.Curso
import Ejercicio4_Estudiantes.Estudiante
import Ejercicio4_Estudiantes.Profesor
import Ejercicio5_Tareas.Tarea
import Ejercicio5_Tareas.UsuarioTareas


fun main() {

    var opcionMenu: Int


    do {
        var biblioteca = Biblioteca()

        println("Bienvenido a la segunda tanda de ejercicios de HLC")
        println("Elige una opción:")
        println("1. Ejercicio 1")
        println("2. Ejercicio 2")
        println("3. Ejercicio 3")
        println("4. Ejercicio 4")
        println("5. Ejericio 5")
        println("6. Salir")

        println("Introduce una opción:")
        opcionMenu = readLine()!!.toIntOrNull() ?: 0

        when (opcionMenu) {
            1 -> {
                println("Bienvenido al Sistema de Gestión de Biblioteca.")

                while (true) {
                    println("\nSeleccione una opción:")
                    println("1. Agregar libro")
                    println("2. Registrar usuario")
                    println("3. Prestar libro")
                    println("4. Devolver libro")
                    println("5. Salir")

                    val opcion = readLine()?.toIntOrNull()
                    when (opcion) {
                        1 -> {
                            print("Ingrese el título del libro: ")
                            val titulo = readLine().orEmpty()
                            print("Ingrese el autor del libro: ")
                            val autor = readLine().orEmpty()
                            biblioteca.agregarLibro(Libro(titulo, autor))
                        }

                        2 -> {
                            print("Ingrese el nombre del usuario: ")
                            val nombre = readLine().orEmpty()
                            print("Ingrese el ID del usuario: ")
                            val id = readLine().orEmpty()
                            biblioteca.registrarUsuario(Usuario(nombre, id))
                        }

                        3 -> {
                            print("Ingrese el ID del usuario: ")
                            val userId = readLine().orEmpty()
                            val usuario = biblioteca.buscarUsuarioPorId(userId)
                            if (usuario != null) {
                                print("Ingrese el título del libro a prestar: ")
                                val tituloPrestamo = readLine().orEmpty()
                                biblioteca.prestarLibro(usuario, tituloPrestamo)
                            }
                        }

                        4 -> {
                            print("Ingrese el ID del usuario: ")
                            val userIdDevolucion = readLine().orEmpty()
                            val usuarioDevolucion = biblioteca.buscarUsuarioPorId(userIdDevolucion)
                            if (usuarioDevolucion != null) {
                                print("Ingrese el título del libro a devolver: ")
                                val tituloDevolucion = readLine().orEmpty()
                                biblioteca.devolverLibro(usuarioDevolucion, tituloDevolucion)
                            }
                        }

                        5 -> {
                            println("Saliendo del sistema...")
                            break
                        }

                        else -> println("Opción inválida. Intente de nuevo.")
                    }
                }
            }

            2 -> {
                println("Bienvenido al Sistema de Gestión de Reservas de Hotel.")

                var opcionMenuHotel: Int = 0

                val hotel = Hotel()

                // Agregar habitaciones al hotel
                hotel.agregarHabitacion(Habitacion(101))
                hotel.agregarHabitacion(Habitacion(102))
                hotel.agregarHabitacion(Habitacion(103))


                do {
                    println("\nSeleccione una opción:")
                    println("1. Registrar cliente")
                    println("2. Registrar reserva")
                    println("3. Cancelar reserva")
                    println("4. Mostrar reservas activas")
                    println("5. Salir")

                    val opcionMenuHotel = readLine()?.toIntOrNull() ?: 0

                    when (opcionMenuHotel) {
                        1 -> {
                            print("Ingrese el nombre del cliente: ")
                            val nombre = readLine() ?: ""
                            print("Ingrese el ID del cliente: ")
                            val id = readLine() ?: ""
                            val cliente = Cliente(nombre, id)
                            hotel.registrarCliente(cliente)
                        }
                        2 -> {
                            print("Ingrese el ID del cliente: ")
                            val idCliente = readLine() ?: ""
                            val clienteReserva = hotel.buscarClientePorId(idCliente)
                            if (clienteReserva == null) {
                                println("Cliente no encontrado. Debe registrar el cliente primero.")
                                continue
                            }
                            print("Ingrese el número de la habitación a reservar: ")
                            val numeroHabitacion = readLine()?.toIntOrNull() ?: -1
                            hotel.registrarReserva(clienteReserva, numeroHabitacion)
                        }
                        3 -> {
                            print("Ingrese el ID del cliente: ")
                            val idClienteCancelacion = readLine() ?: ""
                            val clienteCancelacion = hotel.buscarClientePorId(idClienteCancelacion)
                            if (clienteCancelacion == null) {
                                println("Cliente no encontrado.")
                                continue
                            }
                            print("Ingrese el número de la habitación a cancelar: ")
                            val numeroHabitacionCancelacion = readLine()?.toIntOrNull() ?: -1
                            hotel.cancelarReserva(clienteCancelacion, numeroHabitacionCancelacion)
                        }
                        4 -> hotel.mostrarReservasActivas()
                        5 -> {
                            println("Saliendo del sistema...")
                        }
                        else -> {
                            println("Opción inválida. Intente de nuevo.")
                        }
                    }
                } while (opcionMenuHotel != 5)


            }
            3 -> {
                println("Bienvenido al Sistema de Gestión de Juego de Rol.")

                val guerrero = Guerrero("Thor", 100)
                val mago = Mago("Gandalf", 80)

                val hechizoFuego = Hechizo("Bola de Fuego", 25, 15)

                // Simulación de un combate
                while (guerrero.estaVivo() && mago.estaVivo()) {
                    // Guerrero ataca
                    val danoGuerrero = guerrero.atacar()
                    mago.puntosVida -= danoGuerrero
                    println("${mago.nombre} recibe $danoGuerrero de daño. Puntos de vida restantes: ${mago.puntosVida}")

                    // Mago ataca o usa un hechizo
                    if (mago.estaVivo()) {
                        if (mago.puntosVida < 50) { // Elige usar hechizo si está bajo de vida
                            mago.usarHechizo(hechizoFuego)
                        } else {
                            val danoMago = mago.atacar()
                            guerrero.puntosVida -= danoMago
                            println("${guerrero.nombre} recibe $danoMago de daño. Puntos de vida restantes: ${guerrero.puntosVida}")
                        }
                    }

                    println() // Línea en blanco para separar los turnos
                }

                // Mensaje final
                if (!guerrero.estaVivo()) {
                    println("${guerrero.nombre} ha sido derrotado!")
                }
                if (!mago.estaVivo()) {
                    println("${mago.nombre} ha sido derrotado!")
                }
            }
            4 -> {
                println("Bienvenido al Sistema de Gestión de Estudiantes.")

                val estudiantes = mutableListOf<Estudiante>()

                // Ingreso del nombre del profesor
                println("Ingrese el nombre del profesor:")
                val nombreProfesor = readLine() ?: ""
                val profesor = Profesor(nombreProfesor)

                // Registro de estudiantes
                println("Ingrese el número de estudiantes a registrar:")
                val numeroEstudiantes = readLine()?.toIntOrNull() ?: 0

                for (i in 1..numeroEstudiantes) {
                    println("Ingrese el nombre del estudiante $i:")
                    val nombreEstudiante = readLine() ?: ""
                    val estudiante = Estudiante(nombreEstudiante)
                    estudiantes.add(estudiante)

                    // Asignación de curso
                    println("Ingrese el nombre del curso:")
                    val nombreCurso = readLine() ?: ""
                    println("Ingrese la calificación del curso:")
                    val calificacionCurso = readLine()?.toDoubleOrNull() ?: 0.0

                    val curso = Curso(nombreCurso, calificacionCurso)
                    estudiante.agregarCurso(curso)
                    println("Curso asignado a $nombreEstudiante.")
                }

                // Mostrar resumen de estudiantes
                println("\nResumen de estudiantes:")
                for (est in estudiantes) {
                    println(est)
                }

            }
            5 -> {
                println("Bienvenido al Sistema de Gestor de tareas.")

                println("Introduce tu nombre:")
                val nombreUsuario = readLine() ?: "Usuario"
                val usuarioTareas = UsuarioTareas(nombreUsuario)

                while (true) {
                    println("\nMenu:")
                    println("1. Crear proyecto")
                    println("2. Agregar tarea a un proyecto")
                    println("3. Marcar tarea como completada")
                    println("4. Mostrar proyectos")
                    println("5. Mostrar tareas de un proyecto")
                    println("6. Salir")

                    print("Selecciona una opción: ")
                    when (readLine()) {
                        "1" -> {
                            print("Introduce el nombre del proyecto: ")
                            val nombreProyecto = readLine() ?: ""
                            usuarioTareas.crearProyecto(nombreProyecto)
                        }
                        "2" -> {
                            print("Introduce el nombre del proyecto al que quieres agregar una tarea: ")
                            val nombreProyecto = readLine() ?: ""
                            val proyecto = usuarioTareas.obtenerProyecto(nombreProyecto)
                            if (proyecto != null) {
                                print("Introduce el nombre de la tarea: ")
                                val nombreTarea = readLine() ?: ""
                                proyecto.agregarTarea(Tarea(nombreTarea))
                            } else {
                                println("Proyecto no encontrado.")
                            }
                        }
                        "3" -> {
                            print("Introduce el nombre del proyecto: ")
                            val nombreProyecto = readLine() ?: ""
                            val proyecto = usuarioTareas.obtenerProyecto(nombreProyecto)
                            if (proyecto != null) {
                                print("Introduce el nombre de la tarea a marcar como completada: ")
                                val nombreTarea = readLine() ?: ""
                                proyecto.marcarTareaComoCompletada(nombreTarea)
                            } else {
                                println("Proyecto no encontrado.")
                            }
                        }
                        "4" -> usuarioTareas.mostrarProyectos()
                        "5" -> {
                            print("Introduce el nombre del proyecto para mostrar sus tareas: ")
                            val nombreProyecto = readLine() ?: ""
                            val proyecto = usuarioTareas.obtenerProyecto(nombreProyecto)
                            if (proyecto != null) {
                                proyecto.mostrarTareas()
                            } else {
                                println("Proyecto no encontrado.")
                            }
                        }
                        "6" -> {
                            println("Saliendo...")
                            return
                        }
                        else -> println("Opción no válida. Inténtalo de nuevo.")
                    }
                }


            }
            6 -> println("Hasta luego")
            else -> println("Opción no válida")
        }


    }while (opcionMenu != 6)










}