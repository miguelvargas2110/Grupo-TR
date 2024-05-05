package co.edu.uniquindio.software3.servicios.implementacion;

import co.edu.uniquindio.software3.dto.ClienteDTO;
import co.edu.uniquindio.software3.dto.CredentialsDTO;
import co.edu.uniquindio.software3.dto.SignUpDTO;
import co.edu.uniquindio.software3.entidades.Cliente;
import co.edu.uniquindio.software3.mappers.ClienteMapper;
import co.edu.uniquindio.software3.repo.ClienteRepo;
import co.edu.uniquindio.software3.servicios.interfaces.ClienteServicio;
import org.springframework.stereotype.Service;

import co.edu.uniquindio.software3.exceptions.AppException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.nio.CharBuffer;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClienteServicioIMPL implements ClienteServicio {

    private final ClienteRepo clienteRepo;
    private final PasswordEncoder passwordEncoder;
    private final ClienteMapper clienteMapper;
    private final RolServicioIMPL rolServicioIMPL;

    @Override
    public ClienteDTO login(CredentialsDTO credentialsDto) {
        Cliente cliente = clienteRepo.findByEmail(credentialsDto.getLogin())
                .orElseThrow(() -> new AppException("No se encontro el usuario, revisalo o sino estas registrado, registrate", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.getPassword()), cliente.getPassword())) {
            return clienteMapper.toClienteDto(cliente);
        }
        throw new AppException("La constraseña es incorrecta", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ClienteDTO register(SignUpDTO clienteDto) {
        Optional<Cliente> optionalUser = clienteRepo.findById(clienteDto.getId());
        Optional<Cliente> optionalUserByEmail = clienteRepo.findByEmail(clienteDto.getEmail());

        if (optionalUser.isPresent()) {
            throw new AppException("Tu cedula ya esta registrada, verificala o intenta con otra", HttpStatus.BAD_REQUEST);
        }

        if (optionalUserByEmail.isPresent()) {
            throw new AppException("El email ya esta registrado, verifica que este correcto o intenta con otro", HttpStatus.BAD_REQUEST);
        }


        Cliente cliente = clienteMapper.signUpToCliente(clienteDto);
        cliente.setPassword(passwordEncoder.encode(CharBuffer.wrap(clienteDto.getPassword())));
        cliente.setRol(this.rolServicioIMPL.obtenerRolPorId("1"));
        Cliente savedUser = clienteRepo.save(cliente);

        return clienteMapper.toClienteDto(savedUser);
    }



    @Override
    public ClienteDTO findByEmail(String email) {
        Cliente cliente = clienteRepo.findByEmail(email)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return clienteMapper.toClienteDto(cliente);
    }

    @Override
    public ClienteDTO findById(String id) {
        Cliente cliente = clienteRepo.findById(id)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return clienteMapper.toClienteDto(cliente);
    }
}
