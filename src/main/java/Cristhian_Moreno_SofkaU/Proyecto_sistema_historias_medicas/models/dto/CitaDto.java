package Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.models.dto;

import org.springframework.web.bind.annotation.RequestBody;

public class CitaDto {

    private Integer dia;
    private Integer hora;
    private Integer minuto;
    private Long paciente_id;

    public Integer getDia() {
        return dia;
    }

    public Integer getHora() {
        return hora;
    }

    public Integer getMinuto() {
        return minuto;
    }

    public Long getPaciente_id() {
        return paciente_id;
    }
}
