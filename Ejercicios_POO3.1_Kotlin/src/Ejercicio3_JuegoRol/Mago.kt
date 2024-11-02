package Ejercicio3_JuegoRol

class Mago(nombre: String, puntosVida: Int) : Personaje(nombre, puntosVida) {
    private val poderAtaque = 8
    private var mana = 50

    override fun atacar(): Int {
        println("$nombre lanza un hechizo!")
        return poderAtaque
    }
    override fun usarHechizo(hechizo: Hechizo) {
        if (mana >= hechizo.costoMana) {
            println("$nombre usa ${hechizo.nombre}!")
            println("Causa ${hechizo.poder} de daño!")
            mana -= hechizo.costoMana // Restar el costo de mana
        } else {
            println("$nombre no tiene suficiente mana para usar ${hechizo.nombre}.")
        }
    }
}