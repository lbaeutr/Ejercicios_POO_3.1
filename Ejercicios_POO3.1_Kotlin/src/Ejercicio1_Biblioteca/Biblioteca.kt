package Ejercicio1_Biblioteca

class Biblioteca {
    private val libros = mutableListOf<Libro>()
    private val usuarios = mutableListOf<Usuario>()
    private val prestamos = mutableMapOf<Usuario, MutableList<Libro>>()

    fun agregarLibro(libro: Libro) {
        libros.add(libro)
        println("Libro agregado: ${libro.titulo}")
    }

    fun registrarUsuario(usuario: Usuario) {
        usuarios.add(usuario)
        println("Usuario registrado: ${usuario.nombre}")
    }

    fun prestarLibro(usuario: Usuario, tituloLibro: String) {
        val libro = libros.find { it.titulo.equals(tituloLibro, ignoreCase = true) }
        if (libro != null) {
            if (libro.prestado) {
                println("El libro '$tituloLibro' ya está prestado.")
            } else {
                libro.prestar()
                prestamos.getOrPut(usuario) { mutableListOf() }.add(libro)
                println("Libro '$tituloLibro' prestado a ${usuario.nombre}")
            }
        } else {
            println("El libro '$tituloLibro' no está disponible en la biblioteca.")
        }
    }

    fun devolverLibro(usuario: Usuario, tituloLibro: String) {
        val librosPrestados = prestamos[usuario]
        if (librosPrestados != null) {
            val libro = librosPrestados.find { it.titulo.equals(tituloLibro, ignoreCase = true) }
            if (libro != null) {
                libro.devolver()
                librosPrestados.remove(libro)
                println("Libro '$tituloLibro' devuelto por ${usuario.nombre}")
                return
            }
        }
        println("El usuario ${usuario.nombre} no tiene prestado el libro '$tituloLibro'.")
    }

    fun buscarUsuarioPorId(id: String): Usuario? {
        return usuarios.find { it.id == id } ?: run {
            println("Usuario no encontrado.")
            null
        }
    }
}