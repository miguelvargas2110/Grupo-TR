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
public class TipoAudiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String tipoAudicencia;

    @OneToMany(mappedBy = "tipoAudiencia")
    private List<Audiencia> audiencias;
}
