package co.edu.uniquindio.software3.servicios.interfaces;

import co.edu.uniquindio.software3.dto.ClienteDTO;
import co.edu.uniquindio.software3.dto.CredentialsDTO;
import co.edu.uniquindio.software3.dto.SignUpDTO;

public interface AdminServicio {
    ClienteDTO login(CredentialsDTO credentialsDto);
    ClienteDTO register(SignUpDTO adminDTO);
    ClienteDTO findByLogin(String login);
}
