package Ejercicio3_JuegoRol;

public class Hechizo {
    private String nombre;
    private int poder;
    private int costoMana;

    public Hechizo(String nombre, int poder, int costoMana) {
        this.nombre = nombre;
        this.poder = poder;
        this.costoMana = costoMana;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPoder() {
        return poder;
    }

    public int getCostoMana() {
        return costoMana;
    }
}