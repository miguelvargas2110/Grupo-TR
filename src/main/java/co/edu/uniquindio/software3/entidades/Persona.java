package co.edu.uniquindio.software3.entidades;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Persona implements Serializable {

    @Id
    @Column(length = 15, nullable = false, unique = true)
    private String id;

    @Column(nullable = false, length = 40)
    private String nombre;

    @Column(nullable = false, length = 40)
    private String apellido;

    @Column(nullable = false, length = 20)
    private String telefono;

    @Column(nullable = false, length = 100)
    private String email;

    @ToString.Exclude
    @Column(nullable = false)
    private String password;

    public Persona(String id, String nombre, String apellido, String telefono, String email, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
    }

    public Persona() {
    }
}
