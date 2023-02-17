package Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.controller;

import Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.models.dto.CitaDto;
import Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.service.ManejoHorario;
import Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.service.PacienteService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Controller
@Api(tags = "Endpoints Pacientes")
@RestController
public class PacienteController {


    @Autowired
    private PacienteService pacienteService;
    @GetMapping("/ver_disponibilidad")
    public ArrayList<ManejoHorario> listarDisponibilidad(){
        return pacienteService.get_horarios_disponibles();
    }

    @PostMapping("/agendar_cita")
    public ResponseEntity<String> agendarCita(@RequestBody CitaDto citaDto){

        return pacienteService.agendar_cita(citaDto);
    }

}
