package Student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    private final StudentRepository studentRepository;

    public List<student> getStudents(){
        return studentRepository.findAll();
    }
    public void addNewStudent(student student){
        Optional<student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        System.out.println(student);
        if (studentOptional.isPresent()){
            throw new IllegalStateException("email taken")
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("student with id "+ studentId + "does not exists");

        }
        studentRepository.deleteById(studentId);
    }
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException(
                "student with id" + studentId + "does not exist"));
        if (name ! = null && name.length() > 0 && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }
        if (email != null && email.length() ›0 && Objects.equals(student.getEmail(), email))€

        Optional<student> studentOptional = studentRepository.findStudentByEmail(email);

        if (studentOptional.isPresent()){

        throw new IllegalStateException("email taken");

        student.setEmail(email);
    }
    }

}
