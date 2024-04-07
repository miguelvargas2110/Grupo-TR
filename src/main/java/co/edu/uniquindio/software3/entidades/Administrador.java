package co.edu.uniquindio.software3.entidades;

import java.io.Serializable;

public class Administrador extends Persona implements Serializable {

    public Administrador(Integer idPersona, String nombre, String apellido, String telefono, String Email, String password, Rol rol) {
        super(idPersona, nombre, apellido, telefono, Email, password, rol);
    }
}
