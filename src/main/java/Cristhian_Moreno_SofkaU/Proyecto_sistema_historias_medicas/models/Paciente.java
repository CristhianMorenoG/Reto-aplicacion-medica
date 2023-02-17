package Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    @Column(name = "documento", nullable = false)
    private Long id;

    private String nombre;

    private Integer edad;


}
