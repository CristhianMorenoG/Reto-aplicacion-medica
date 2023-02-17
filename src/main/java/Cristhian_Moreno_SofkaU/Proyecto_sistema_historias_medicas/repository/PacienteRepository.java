package Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.repository;

import Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Optional<Paciente> findById(Long Id);
    Optional<Paciente> save(Long Id);
    Optional<Paciente>deleteById(Long Id);
}
