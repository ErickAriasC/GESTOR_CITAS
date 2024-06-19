package api.controller;

import api.model.Paciente;
import api.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


@RestController
@RequestMapping("/api/paciente")

public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ArrayList<Paciente> getAllPacientes() {
        return this.pacienteService.getAllPacientes();
    }

    @PostMapping
    public Paciente saveUser(@RequestBody Paciente paciente) {
        return this.pacienteService.saveUser(paciente);
    }

    @GetMapping(path = "/{id}")
    public Optional<Paciente> getPacienteById(@PathVariable("id") Long id) {
        return this.pacienteService.getPacienteById(id);
    }

    @PutMapping(path = "/{id}")
    public Paciente updatePaciente(@RequestBody Paciente request,@PathVariable( "id") Long id) {
        return this.pacienteService.updatePaciente(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deletePaciente(@PathVariable("id") Long id) {
        boolean ok = this.pacienteService.deletePaciente(id);
        if (ok){
            return "Paciente con id " + id + " eliminado";
        }else{
            return "No existe el paciente con el ID: "+ id ;
        }
    }
}
