package co.edu.uniquindio.software3.servicios.implementacion;

import co.edu.uniquindio.software3.entidades.Rol;
import co.edu.uniquindio.software3.repo.RolRepo;
import co.edu.uniquindio.software3.servicios.interfaces.RolServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolServicioIMPL implements RolServicio {

    private final RolRepo rolRepo;

    @Autowired
    public RolServicioIMPL(RolRepo rolRepo) {
        this.rolRepo = rolRepo;
    }

    @Override
    public Rol obtenerRolPorId(String idRol) {
        return rolRepo.findById(idRol).orElse(null);
    }
}
