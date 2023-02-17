package Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.repository;

import Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    Optional<Doctor> findById(Long Id);
    Optional<Doctor> save(Doctor doctor);



}
