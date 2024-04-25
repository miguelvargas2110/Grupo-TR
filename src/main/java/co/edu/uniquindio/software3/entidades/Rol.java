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
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String rol;

    @OneToMany(mappedBy = "rol")
    private List<Administrador> administradorList;

    @OneToMany(mappedBy = "rol")
    private List<Cliente> clientes;

    @OneToMany(mappedBy = "rol")
    private List<Abogado> abogados;
}
