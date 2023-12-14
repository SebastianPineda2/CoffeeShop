package co.edu.sena.coffeeshopsena.modelos;

public class Productos {

    private String id;
    private String categoria;
    private String nombre;
    private String cantidad;
    private String descripcion;
    private String precio;

    public Productos() {
    }

    public Productos(String vn, String seccion, String tema, String nom, String cant, String descrip, String preci) {
        this.id = tema;
        this.categoria = seccion;
        this.nombre = nom;
        this.cantidad = cant;
        this.descripcion = descrip;
        this.precio = preci;
    }

    public String getId() {
        return id;
    }

    public void setId(String tema) {
        this.id = tema;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String vn) {
        this.categoria = vn;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nom) {
        this.nombre = nom;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cant) {
        this.cantidad = cant;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descrip) {
        this.descripcion = descrip;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String preci) {
        this.precio = preci;
    }
}
