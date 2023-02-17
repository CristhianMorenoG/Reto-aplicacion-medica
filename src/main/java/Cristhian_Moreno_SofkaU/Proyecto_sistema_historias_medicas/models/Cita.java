package Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "citas")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "doc_doctor", nullable = false)
    private Doctor doctor;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "doc_paciente", nullable = false)
    private Paciente paciente;

    private Integer dia;
    private Integer hora_cita;
    private Integer minuto_cita;
    private Boolean confirmada;

    public Cita(Doctor doctor, Paciente paciente, Integer dia, Integer hora_cita, Integer minuto_cita, Boolean confirmada) {
        this.doctor = doctor;
        this.paciente = paciente;
        this.dia = dia;
        this.hora_cita = hora_cita;
        this.minuto_cita = minuto_cita;
        this.confirmada = confirmada;
    }

    public Cita() {
    }
}