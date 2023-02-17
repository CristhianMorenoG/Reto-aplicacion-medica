package Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.service;

import java.time.LocalTime;
import java.util.List;

public class ManejoHorario {

    private Integer dia;
    private String nombreDia;
    private List<LocalTime> horas;

    public ManejoHorario(Integer dia, String nombreDia, List<LocalTime> horas) {
        this.dia = dia;
        this.nombreDia = nombreDia;
        this.horas = horas;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public String getNombreDia() {
        return nombreDia;
    }

    public void setNombreDia(String nombreDia) {
        this.nombreDia = nombreDia;
    }

    public List<LocalTime> getHoras() {
        return horas;
    }

    public void setHoras(List<LocalTime> horas) {
        this.horas = horas;
    }
}
