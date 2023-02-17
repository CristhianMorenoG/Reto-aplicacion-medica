package Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas;

import Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.models.Doctor;
import Cristhian_Moreno_SofkaU.Proyecto_sistema_historias_medicas.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class ClinicaApplication {

	public static void main(String[] args) {

		SpringApplication.run(ClinicaApplication.class, args);

	}


}
