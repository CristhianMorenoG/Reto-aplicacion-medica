package Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.repository;

import Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.models.Horario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorarioRepository extends JpaRepository<Horario,Long> {

    public Horario findHorarioByDia(Integer dia);
    public Horario save(Horario horario);

}
