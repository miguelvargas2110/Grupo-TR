package co.edu.uniquindio.software3.controller;

import co.edu.uniquindio.software3.config.UserAuthenticationProvider;
import co.edu.uniquindio.software3.dto.ClienteDTO;
import co.edu.uniquindio.software3.dto.CredentialsDTO;
import co.edu.uniquindio.software3.dto.SignUpDTO;
import co.edu.uniquindio.software3.servicios.interfaces.ClienteServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RequiredArgsConstructor
@RestController
public class AuthController {

    private final ClienteServicio clienteService;
    private final UserAuthenticationProvider clienteAuthenticationProvider;

    @PreAuthorize("permitAll")
    @PostMapping("/login")
    public ResponseEntity<ClienteDTO> login(@RequestBody @Valid CredentialsDTO credentialsDTO) {
        ClienteDTO clienteDTO = clienteService.login(credentialsDTO);
        clienteDTO.setToken(clienteAuthenticationProvider.createToken(clienteDTO.getEmail()));
        return ResponseEntity.ok(clienteDTO);
    }

    @PreAuthorize("permitAll")
    @PostMapping("/register")
    public ResponseEntity<ClienteDTO> register(@RequestBody @Valid SignUpDTO cliente) {
        ClienteDTO createdCliente = clienteService.register(cliente);
        System.out.println("createdCliente: " + createdCliente);
        createdCliente.setToken(clienteAuthenticationProvider.createToken(cliente.getEmail()));
        return ResponseEntity.created(URI.create("/clientes/" + createdCliente.getId())).body(createdCliente);

    }

}
