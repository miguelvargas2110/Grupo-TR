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

    @JoinColumn(nullable = false)
    @ManyToOne
    private Disponibilidad disponibilidad;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Especializacion especializacion;

    @ToString.Exclude
    @OneToMany(mappedBy = "abogado")
    private List<Caso> casos;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Rol rol;

}
