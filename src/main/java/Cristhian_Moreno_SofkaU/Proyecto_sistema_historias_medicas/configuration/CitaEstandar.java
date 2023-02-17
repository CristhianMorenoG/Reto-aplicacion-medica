package Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.configuration;

import org.springframework.context.annotation.Configuration;

@Configuration
public class CitaEstandar {

    private final Integer DURACION_CITA = 30;

    public Integer getDURACION_CITA() {
        return DURACION_CITA;
    }
}
