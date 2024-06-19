package api.model;

import jakarta.persistence.*;
import api.model.Cita;


@Entity
@Table(name = "medico")

public class Medico {

    @Id
    private long id;
    private String nombre;
    private String especialidad;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;

    }
}

