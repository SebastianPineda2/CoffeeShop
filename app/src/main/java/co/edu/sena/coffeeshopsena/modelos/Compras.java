package co.edu.sena.coffeeshopsena.modelos;

public class Compras {

    private String cantidad;
    private String nombre;
    private String precio;

    public Compras() {
    }

    public Compras(String cantis, String nomes, String precil) {
        this.cantidad=cantis;
        this.nombre=nomes;
        this.precio=precil;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad=cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre=nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio=precio;
    }

    public String toString(){ return "Cantidad: " + nombre + "\n" + "Nombre: " + cantidad  + "\n" + "Precio: " + precio; }
}
