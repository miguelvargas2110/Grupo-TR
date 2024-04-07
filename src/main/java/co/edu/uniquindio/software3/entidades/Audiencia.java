package co.edu.uniquindio.software3.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Audiencia {

    @Id
    @Column(length = 10,nullable = false,unique = true)
    private Integer idAudiencia;

    @Column(nullable = false)
    private TipoAudiencia tipoAudiencia;

    @Column(nullable = false,length = 20)
    private String fecha;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Caso caso;

    public Audiencia(TipoAudiencia tipoAudiencia, String fecha) {
        this.tipoAudiencia = tipoAudiencia;
        this.fecha = fecha;
    }
}
