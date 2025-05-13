/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

/**
 *
 * @author mabel
 */
public class Usuario {
 
private String idUsuario;
private String nombre;
private String apellido;
private String correo;
private String contrasenia;
private String tipoUsuario;
private String estado;
private float moraTotal;

// Constructor vacío
public Usuario() {}

// Constructor completo
public Usuario(String idUsuario, String nombre, String apellido, String correo, String contrasenia,
               String tipoUsuario, String estado, float moraTotal) {
    this.idUsuario = idUsuario;
    this.nombre = nombre;
    this.apellido = apellido;
    this.correo = correo;
    this.contrasenia = contrasenia;
    this.tipoUsuario = tipoUsuario;
    this.estado = estado;
    this.moraTotal = moraTotal;
}

// Getters y Setters
public String getIdUsuario() {
    return idUsuario;
}

public void setIdUsuario(String idUsuario) {
    this.idUsuario = idUsuario;
}

public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public String getApellido() {
    return apellido;
}

public void setApellido(String apellido) {
    this.apellido = apellido;
}

public String getCorreo() {
    return correo;
}

public void setCorreo(String correo) {
    this.correo = correo;
}

public String getContrasenia() {
    return contrasenia;
}

public void setContrasenia(String contrasenia) {
    this.contrasenia = contrasenia;
}

public String getTipoUsuario() {
    return tipoUsuario;
}

public void setTipoUsuario(String tipoUsuario) {
    this.tipoUsuario = tipoUsuario;
}

public String getEstado() {
    return estado;
}

public void setEstado(String estado) {
    this.estado = estado;
}

public float getMoraTotal() {
    return moraTotal;
}

public void setMoraTotal(float moraTotal) {
    this.moraTotal = moraTotal;
}

}
