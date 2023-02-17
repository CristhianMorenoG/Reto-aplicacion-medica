package Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.configuration;

import Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.models.Doctor;
import Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private DoctorRepository doctorRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        doctorRepository.save(new Doctor(Long.valueOf(1083046893),"Daniel",30));
    }
}



