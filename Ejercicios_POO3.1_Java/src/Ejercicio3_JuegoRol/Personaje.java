package Ejercicio3_JuegoRol;

public class Personaje {
    protected String nombre;
    public int puntosVida;

    public Personaje(String nombre, int puntosVida) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
    }

    public int atacar() {
        return 0;
    }

    public void usarHechizo(Hechizo hechizo) {
        System.out.println(nombre + " no puede usar hechizos.");
    }

    public boolean estaVivo() {
        return puntosVida > 0;
    }

    @Override
    public String toString() {
        return nombre + " (Vida: " + puntosVida + ")";
    }
}