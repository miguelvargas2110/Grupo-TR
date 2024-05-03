package co.edu.uniquindio.software3.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Cliente extends Persona{

   @Column(length = 300)
    private String infoCaso;

    @ToString.Exclude
    @OneToMany(mappedBy = "cliente")
    private List<Caso> casos;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Rol rol;

}
