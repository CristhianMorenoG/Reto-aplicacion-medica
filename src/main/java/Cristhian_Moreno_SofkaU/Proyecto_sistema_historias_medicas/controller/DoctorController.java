package Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.controller;

import Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.models.Cita;
import Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.models.Horario;
import Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.models.Paciente;
import Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.service.CitaService;
import Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.service.DoctorService;
import Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.service.PacienteService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags = "Endpoints Doctores")
@RestController
public class DoctorController {

    @Autowired
    PacienteService pacienteService;
    @Autowired
    DoctorService doctorService;
    @Autowired
    CitaService citaService;
    @PostMapping("/crear_paciente")
    public ResponseEntity<Paciente> crearPaciente(@RequestBody Paciente paciente){

        return pacienteService.crear_paciente(paciente);
    }

    @PatchMapping("/paciente/{doc_paciente}")
    public ResponseEntity<Paciente> actualizarPaciente(@PathVariable Long doc_paciente,@RequestBody  Paciente paciente){

        return pacienteService.actualizar_paciente(doc_paciente, paciente);
    }

    @PostMapping("/crear_horario")
    public ResponseEntity<Horario> crearHorarioDisponibilidadDr(@RequestBody Horario horario){

        if(doctorService.buscar_horario_por_dia(horario.getDia()) || horario.getDia()<=0 || horario.getDia()>7){
            return new ResponseEntity<>(horario, HttpStatus.BAD_REQUEST);
        }
        return doctorService.crear_horario(horario);
    }

    @DeleteMapping("/paciente/{doc_paciente}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable Long doc_paciente){

        return pacienteService.eliminar_paciente(doc_paciente);
    }

    @GetMapping("/citas_sin_confirmar")
    public List<Cita> getCitasSinConfirmar(){
        return doctorService.traerCitasSinConfirmar();
    }

    @PostMapping("/confirmar_cita/cita/{cita_id}")
    public ResponseEntity<String>confirmarCita(@PathVariable Long cita_id){
        return citaService.confirmar_cita(cita_id,true);
    }
    @PostMapping("/rechazar_cita/cita/{cita_id}")
    public ResponseEntity<String> rechazarCita(@PathVariable Long cita_id){
        return citaService.confirmar_cita(cita_id,false);
    }

}
