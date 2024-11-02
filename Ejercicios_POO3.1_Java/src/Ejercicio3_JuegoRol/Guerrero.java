package Ejercicio3_JuegoRol;

public class Guerrero extends Personaje {
    private final int poderAtaque = 10;

    public Guerrero(String nombre, int puntosVida) {
        super(nombre, puntosVida);
    }

    @Override
    public int atacar() {
        System.out.println(nombre + " ataca con un golpe poderoso!");
        return poderAtaque;
    }
}
