package co.edu.uniquindio.software3.entidades;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;


@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Caso implements Serializable {

    @Id
    @Column(length = 10,nullable = false,unique = true)
    private Integer numeroCaso;

    @Column(nullable = false,length = 10)
    private String fechaRecepcion;

    @Column(nullable = false,length = 10)
    private String estado;

    @Column(length = 20)
    private String sentencia;

    @Column(nullable = false,length = 20)
    private String tipoCaso;

    @Column(length = 20)
    private String fechaResolucion;

    @Column(nullable = false,length = 20)
    private String Descripcion;

    @Column(length = 30)
    private Double valorCaso;


    @Builder
    public Caso(Integer numeroCaso, String fechaRecepcion, String estado, String sentencia, String tipoCaso, String fechaResolucion, String descripcion, Double valorCaso) {
        this.numeroCaso = numeroCaso;
        this.fechaRecepcion = fechaRecepcion;
        this.estado = estado;
        this.sentencia = sentencia;
        this.tipoCaso = tipoCaso;
        this.fechaResolucion = fechaResolucion;
        Descripcion = descripcion;
        this.valorCaso = valorCaso;
    }


}
