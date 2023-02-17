package Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.models;

import lombok.Data;
import javax.persistence.*;
@Entity
@Data
@Table(name = "doctores")
public class Doctor {
    @Id
    @Column(name = "documento", nullable = false)
    private Long id;

    private String nombre;

    private Integer edad;

    public Doctor(Long id, String nombre, Integer edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    public Doctor() {

    }
}
