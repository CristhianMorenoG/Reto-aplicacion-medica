package Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.service;

import Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.configuration.CitaEstandar;
import Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.models.Cita;
import Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.models.Doctor;
import Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.models.Horario;
import Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.models.Paciente;
import Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.models.dto.CitaDto;
import Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.repository.CitaRepository;
import Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.repository.DoctorRepository;
import Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.repository.HorarioRepository;
import Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.*;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;
    @Autowired
    HorarioRepository horarioRepository;

    @Autowired
    CitaRepository citaRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    public ResponseEntity<Paciente> crear_paciente(Paciente new_paciente) {
        Optional<Paciente> paciente = pacienteRepository.findById(new_paciente.getId());

        if(paciente.isPresent()){
            return new ResponseEntity(paciente, HttpStatus.BAD_REQUEST);
        }
        pacienteRepository.save(new_paciente.getId());
        return new ResponseEntity<>(new_paciente, HttpStatus.CREATED);
    }

    public ResponseEntity<Paciente> actualizar_paciente(Long id, Paciente new_paciente){
        Optional<Paciente>  paciente = pacienteRepository.findById(id);
        if(paciente.isPresent()){
            paciente.get().setEdad(new_paciente.getEdad());
            paciente.get().setNombre(new_paciente.getNombre());
            paciente.get().setId(new_paciente.getId());
            pacienteRepository.save(paciente.get().getId());
            return new ResponseEntity<>(paciente.get(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new_paciente, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> eliminar_paciente(Long id_paciente){
        Optional<Paciente>  paciente = pacienteRepository.findById(id_paciente);
        if(paciente.isPresent()){
            pacienteRepository.deleteById(id_paciente);
            return new ResponseEntity<>("El paciente se elimino con exito!", HttpStatus.OK);
        }
        return new ResponseEntity<>("El paciente no existe", HttpStatus.NOT_FOUND);

    }

    public ArrayList<ManejoHorario> get_horarios_disponibles(){
        List<Horario> horarios = horarioRepository.findAll();
        List<Cita> citas = citaRepository.getCitaByDoctorIdAndConfirmadaIsTrueOrConfirmadaIsNull(Long.valueOf(1083046893));
        Map<Integer, String> dias = new HashMap<Integer, String>();

        dias.put(1,"lunes");
        dias.put(2,"martes");
        dias.put(3,"miercoles");
        dias.put(4,"jueves");
        dias.put(5,"viernes");
        dias.put(6,"sabado");
        dias.put(7,"domingo");

        CitaEstandar citaEstandar = new CitaEstandar();
        ArrayList<ManejoHorario> manejoHorario = new ArrayList();
        horarios.forEach(horario -> {
            LocalTime hora_inicio = LocalTime.of(horario.getHora_inicio(),horario.getMinuto_inicio());
            LocalTime hora_fin = LocalTime.of(horario.getHora_fin(),horario.getMinuto_fin());
            ArrayList<LocalTime> horario_disponible = new ArrayList();
            LocalTime finalHora_inicio = hora_inicio;
            Optional<Cita> cita_selected = citas.stream().filter(cita -> cita.getDia() == horario.getDia() && cita.getHora_cita() == finalHora_inicio.getHour() && cita.getMinuto_cita() == finalHora_inicio.getMinute()).findFirst();
            if(!cita_selected.isPresent()){
                horario_disponible.add(hora_inicio);
            }
            while(hora_inicio.isBefore(hora_fin)){
                hora_inicio = hora_inicio.plusMinutes(citaEstandar.getDURACION_CITA());

                LocalTime hora_inicio_sel = hora_inicio;
                cita_selected = citas.stream().filter(cita -> cita.getDia() == horario.getDia() && cita.getHora_cita() == hora_inicio_sel.getHour() && cita.getMinuto_cita() == hora_inicio_sel.getMinute()).findFirst();
                if(!cita_selected.isPresent()){
                    horario_disponible.add(hora_inicio);
                }

            }

            manejoHorario.add(new ManejoHorario(horario.getDia(),dias.get(horario.getDia()),horario_disponible));
        });

        return manejoHorario;
    }

    public ResponseEntity<String> agendar_cita(CitaDto citaDto){

        if(citaDto.getMinuto()!=30 && citaDto.getMinuto()!=0){
            return new ResponseEntity<>("El minuto que escogiste no es correcto.", HttpStatus.CREATED);
        }

        ArrayList<ManejoHorario> manejoHorarios = this.get_horarios_disponibles();

        Optional<ManejoHorario> selected = manejoHorarios.stream().filter(manejoHorario -> manejoHorario.getDia() == citaDto.getDia() && manejoHorario.getHoras().stream().filter(hora -> hora.equals(LocalTime.of(citaDto.getHora(),citaDto.getMinuto()))).findFirst().isPresent()).findFirst();

        if(!selected.isPresent()){
            return new ResponseEntity<>("El horario no esta disponible", HttpStatus.BAD_REQUEST);
        }
        Optional<Doctor> doctor = doctorRepository.findById(Long.valueOf(1083046893));
        if(!doctor.isPresent()){
            return new ResponseEntity<>("El doctor no existe", HttpStatus.NOT_FOUND);
        }
        Optional<Paciente> paciente = pacienteRepository.findById(citaDto.getPaciente_id());
        if(!paciente.isPresent()){
            return new ResponseEntity<>("El paciente no existe", HttpStatus.NOT_FOUND);
        }

        citaRepository.save(new Cita(doctor.get(), paciente.get(), citaDto.getDia(), citaDto.getHora(), citaDto.getMinuto(), null));
        return new ResponseEntity<>("Cita creada con exito", HttpStatus.CREATED);

    }


}
