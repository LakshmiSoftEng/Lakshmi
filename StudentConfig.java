package Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class StudentConfig {
     @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            student Lakshmi =new student(
                    1L,
                    "Lakshmi",
                    "lakshmi.mareedu@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5)

            );

            student alex =new student(
                    1L,
                    "alex",
                    "alex@gmail.com",
                    LocalDate.of(2004, Month.JANUARY, 5)

            );
            repository.saveAll(
                    List.of(Lakshmi, alex)
            )
        };
    }
}
