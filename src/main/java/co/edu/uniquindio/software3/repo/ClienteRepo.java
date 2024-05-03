package co.edu.uniquindio.software3.repo;


import co.edu.uniquindio.software3.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente,String> {
    Optional<Cliente> findByEmail(String email);

    Optional<Cliente> findById(String id);
}
