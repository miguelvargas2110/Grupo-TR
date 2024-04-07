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
public class Caso implements Serializable {

    @Id
    @Column(length = 10,nullable = false,unique = true)
    private Integer idCaso;

    @Column(nullable = false,length = 10)
    private String fechaRecepcion;

    @Column(nullable = false,length = 10)
    private String estado;

    @Column(length = 20)
    private String sentencia;

    @Column(nullable = false,length = 20)
    private Especializacion tipoCaso;

    @Column(length = 20)
    private String fechaResolucion;

    @Column(nullable = false,length = 20)
    private String Descripcion;

    @Column(length = 30)
    private Double valorCaso;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Abogado abogado;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Cliente cliente;

    @ToString.Exclude
    @OneToMany(mappedBy = "caso")
    private List<Audiencia> audiencias;



}
