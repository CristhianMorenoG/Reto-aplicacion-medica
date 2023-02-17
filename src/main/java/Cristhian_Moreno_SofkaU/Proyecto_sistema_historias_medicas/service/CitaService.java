package Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.service;

import Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.models.Cita;
import Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CitaService {

    @Autowired
    CitaRepository citaRepository;
    public ResponseEntity<String> confirmar_cita(Long id, Boolean confirmacion){
        Optional<Cita> cita = citaRepository.findById(id);
        if(!cita.isPresent()){
            return new ResponseEntity<>("Cita no encontrada", HttpStatus.NOT_FOUND);
        }
        cita.get().setConfirmada(confirmacion);
        citaRepository.save(cita.get());
        if(confirmacion){
            return new ResponseEntity<>("Cita confirmada", HttpStatus.OK);
        }
        return new ResponseEntity<>("Cita rechazada", HttpStatus.OK);
    }


}
