package Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.service;

import Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.models.Cita;
import Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.models.Doctor;
import Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.models.Horario;
import Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.repository.CitaRepository;
import Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.repository.DoctorRepository;
import Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    HorarioRepository horarioRepository;

    @Autowired
    CitaRepository citaRepository;
    public ResponseEntity<Horario> crear_horario(Horario horario){
        horarioRepository.save(horario);
        return new ResponseEntity<>(horario, HttpStatus.CREATED);
    }

    public Boolean buscar_horario_por_dia(Integer dia){
        Horario horario = horarioRepository.findHorarioByDia(dia);
        if (horario != null){
            return true;
        }
        return false;
    }

    public Doctor crear_doctor(Doctor doctor){
        doctorRepository.save(doctor);
        return doctor;
    }

    public List<Cita> traerCitasSinConfirmar(){
        return citaRepository.getCitaByDoctorIdAndConfirmadaIsNull(Long.valueOf(1083046893));
    }


}
