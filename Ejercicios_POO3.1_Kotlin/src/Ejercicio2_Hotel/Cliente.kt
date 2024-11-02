package Ejercicio2_Hotel

data class Cliente(val nombre: String, val id: String) {
    override fun toString(): String {
        return "Cliente(nombre='$nombre', id='$id')"
    }
}