package co.edu.uniquindio.software3.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Cliente extends Persona{

   @Column(nullable = false,length = 200)
    private String infoCaso;

    @ToString.Exclude
    @OneToMany(mappedBy = "cliente")
    private List<Caso> casos;

}
