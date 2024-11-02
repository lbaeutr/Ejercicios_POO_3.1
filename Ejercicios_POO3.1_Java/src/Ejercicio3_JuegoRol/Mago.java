package Ejercicio3_JuegoRol;

public class Mago extends Personaje {
    private final int poderAtaque = 8;
    private int mana = 50;

    public Mago(String nombre, int puntosVida) {
        super(nombre, puntosVida);
    }

    @Override
    public int atacar() {
        System.out.println(nombre + " lanza un hechizo!");
        return poderAtaque;
    }
    @Override
    public void usarHechizo(Hechizo hechizo) {
        if (mana >= hechizo.getCostoMana()) {
            System.out.println(nombre + " usa " + hechizo.getNombre() + "!");
            System.out.println("Causa " + hechizo.getPoder() + " de daño!");
            mana -= hechizo.getCostoMana(); // Restar el costo de mana
        } else {
            System.out.println(nombre + " no tiene suficiente mana para usar " + hechizo.getNombre() + ".");
        }
    }
}