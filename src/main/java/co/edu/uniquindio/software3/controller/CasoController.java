package co.edu.uniquindio.software3.controller;

import co.edu.uniquindio.software3.entidades.Caso;
import co.edu.uniquindio.software3.servicios.implementacion.CasoServicioIMPL;
import co.edu.uniquindio.software3.servicios.interfaces.CasoServicio;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/caso")
public class CasoController {
    private final CasoServicioIMPL casoServicio;

    public CasoController(CasoServicioIMPL casoServicio) {
        this.casoServicio = casoServicio;
    }

    @GetMapping("/{id}")
    public Caso obtenerCaso(@PathVariable("id") Integer id) throws Exception {
        return casoServicio.obtenerCaso(id);
    }
}
