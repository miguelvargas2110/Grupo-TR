package co.edu.uniquindio.software3.servicios.implementacion;

import co.edu.uniquindio.software3.entidades.Caso;
import co.edu.uniquindio.software3.repo.CasoRepo;
import co.edu.uniquindio.software3.servicios.interfaces.CasoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CasoServicioIMPL implements CasoServicio {

    @Autowired
    private final CasoRepo casoRepo;

    public CasoServicioIMPL(CasoRepo casoRepo) {
        this.casoRepo = casoRepo;
    }

    @Override
    public Caso obtenerCaso(Integer idCaso) throws Exception {
        Optional<Caso> caso= casoRepo.findById(idCaso);
        if(caso.isEmpty()){
           throw new Exception("No hay un caso con ese codigo");
        }
        return caso.get();
    }
}
