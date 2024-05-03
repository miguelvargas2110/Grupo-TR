package co.edu.uniquindio.software3.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpDTO {

    @NotEmpty
    private String id;

    @NotEmpty
    private String nombre;

    @NotEmpty
    private String apellido;

    @NotEmpty
    private String telefono;

    @NotEmpty
    private String email;

    @NotEmpty
    private char[] password;

    @NotEmpty
    private String rol_id;

}