package co.edu.sena.coffeeshopsena.modelos;

public class Usuarios {

    private String nombre;
    private String apellido;
    private String tipoCedula;
    private String mumeroDocumento;
    private String correo;
    private String password;
    private String genero;
    private String rol;
    private String idUsuario;

    public Usuarios() {
    }

    public Usuarios(String nombre, String apellido, String tipoCedula, String mumeroDocumento, String correo, String password, String genero, String rol, String idUsuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoCedula = tipoCedula;
        this.mumeroDocumento = mumeroDocumento;
        this.correo = correo;
        this.password = password;
        this.genero = genero;
        this.rol = rol;
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre=nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido=apellido;
    }

    public String getTipoCedula() {
        return tipoCedula;
    }

    public void setTipoCedula(String tipoCedula) {
        this.tipoCedula=tipoCedula;
    }

    public String getMumeroDocumento() {
        return mumeroDocumento;
    }

    public void setMumeroDocumento(String mumeroDocumento) {
        this.mumeroDocumento=mumeroDocumento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo=correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password=password;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero=genero;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol=rol;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario=idUsuario;
    }

    public String toString(){ return "Rol: " + rol + "\n" + nombre + " " + apellido + "\n" + correo; }

}
