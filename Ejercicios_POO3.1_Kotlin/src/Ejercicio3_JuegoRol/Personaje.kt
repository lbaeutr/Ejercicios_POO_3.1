package Ejercicio3_JuegoRol


/*
 la clase personaje es open para que pueda ser heredada por otras clases
 esto significa que se puede sobreescribir sus métodos y propiedades

 */
open class Personaje(val nombre: String, var puntosVida: Int) {
    open fun atacar(): Int {
        return 0 // Método que debe ser sobreescrito
    }

    open fun usarHechizo(hechizo: Hechizo) {
        println("$nombre no puede usar hechizos.")
    }

    fun estaVivo(): Boolean {
        return puntosVida > 0
    }

    override fun toString(): String {
        return "$nombre (Vida: $puntosVida)"
    }
}