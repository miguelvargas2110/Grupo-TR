package co.edu.uniquindio.software3.entidades;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)

public class Administrador extends Persona implements Serializable {


    @JoinColumn(nullable = false)
    @ManyToOne
    private Rol rol;
    public Administrador(String idPersona, String nombre, String apellido, String telefono, String Email, String password, Rol rol) {
        super(idPersona, nombre, apellido, telefono, Email, password);
    }


}
