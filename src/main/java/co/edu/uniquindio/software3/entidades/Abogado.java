package co.edu.uniquindio.software3.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    private Disponibilidad disponibilidad;

    @Column(nullable = false)
    private Especializacion especializacion;

    @ToString.Exclude
    @OneToMany(mappedBy = "abogado")
    private List<Caso> casos;

}
