package Ejercicio2_Reservas_Hotel;

public class Cliente {
    private String nombre;
    private String id;

    public Cliente(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }
}