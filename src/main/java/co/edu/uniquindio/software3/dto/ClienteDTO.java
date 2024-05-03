package co.edu.uniquindio.software3.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDTO {
    String id;
    String email;
    String password;
    String token;
}
