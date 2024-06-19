package api.services;

import api.model.Paciente;
import api.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    IPacienteRepository pacienteRepository;

    public ArrayList<Paciente> getAllPacientes() {
        return (ArrayList<Paciente>) pacienteRepository.findAll();
    }

    public Paciente saveUser(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Optional<Paciente> getPacienteById(Long id) {
        return pacienteRepository.findById(id);
    }

    public Paciente updatePaciente(Paciente request, Long id) {

        if (pacienteRepository.existsById(id)) {
            try {
                Paciente pacienteOptional = pacienteRepository.findById(id).get();

                pacienteOptional.setNombre(request.getNombre());
                pacienteOptional.setApellido(request.getApellido());
                pacienteOptional.setEmail(request.getEmail());

                return pacienteRepository.save(pacienteOptional);
            }catch (Exception e){
                return null;
            }
        }else {
            return null;
        }


    }

    public boolean deletePaciente(Long id) {

        if (pacienteRepository.existsById(id)) {
            try {
                pacienteRepository.deleteById(id);
                return true;
            }catch(Exception e) {
                return false;
            }
        }else {
            return false;
        }

    }
}
