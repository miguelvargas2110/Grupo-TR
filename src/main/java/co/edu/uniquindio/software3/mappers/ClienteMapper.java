package co.edu.uniquindio.software3.mappers;

import co.edu.uniquindio.software3.dto.ClienteDTO;
import co.edu.uniquindio.software3.dto.SignUpDTO;
import co.edu.uniquindio.software3.entidades.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    ClienteDTO toClienteDto(Cliente cliente);

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "rol", ignore = true)

    Cliente signUpToCliente(SignUpDTO signUpDto);

}
