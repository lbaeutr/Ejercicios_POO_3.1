package Ejercicio3_JuegoRol

class Guerrero(nombre: String, puntosVida: Int) : Personaje(nombre, puntosVida) {
    private val poderAtaque = 10

    override fun atacar(): Int {
        println("$nombre ataca con un golpe poderoso!")
        return poderAtaque
    }
}