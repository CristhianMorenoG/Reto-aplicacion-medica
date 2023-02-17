package Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.models;

import lombok.Data;
import java.time.DayOfWeek;
import java.time.LocalTime;
import javax.persistence.*;
@Data
@Entity
@Table(name = "horarios")
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "dia", nullable = false)
    private Integer dia;

    @Column(name = "hora_inicio", nullable = false)
    private Integer hora_inicio;

    @Column(name = "minuto_inicio", nullable = false)
    private Integer minuto_inicio;

    @Column(name = "hora_fin", nullable = false)
    private Integer hora_fin;

    @Column(name = "minuto_fin", nullable = false)
    private Integer minuto_fin;

}