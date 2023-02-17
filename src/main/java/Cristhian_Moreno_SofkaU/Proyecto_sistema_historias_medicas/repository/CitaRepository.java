package Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.repository;

import Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.models.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {

    public List<Cita> getCitaByDoctorIdAndConfirmadaIsTrueOrConfirmadaIsNull(Long idDoctor);
    public List<Cita> getCitaByDoctorIdAndConfirmadaIsNull(Long idDoctor);
    Optional <Cita> findById(Long id);
    Optional <Cita> save(Cita cita);
}
