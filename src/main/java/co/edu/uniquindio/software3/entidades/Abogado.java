package co.edu.uniquindio.software3.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Abogado extends Persona implements Serializable  {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Disponibilidad disponibilidad;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Especializacion especializacion;

    @ToString.Exclude
    @OneToMany(mappedBy = "abogado")
    private List<Caso> casos;

}
