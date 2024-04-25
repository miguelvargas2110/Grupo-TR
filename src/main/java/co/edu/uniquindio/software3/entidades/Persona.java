package co.edu.uniquindio.software3.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Persona implements Serializable {

    @Id
    @Column(length = 10,nullable = false,unique = true)
    private Integer id;

    @Column(nullable = false,length = 20)
    private String nombre;

    @Column(nullable = false,length = 20)
    private String apellido;

    @Column(nullable = false,length = 20)
    private String telefono;

    @Column(nullable = false,length = 20)
    private String Email;

    @ToString.Exclude
    @Column(nullable = false,length = 20)
    private String password;

}
