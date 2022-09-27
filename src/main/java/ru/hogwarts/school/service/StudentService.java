package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.Repository.StudentRepository;
import ru.hogwarts.school.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

@Service
public class StudentService {

    Logger logger = LoggerFactory.getLogger(StudentService.class);

    private StudentRepository studentRepository;

    private StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        logger.info("The method that adds the student is invoked");
        logger.debug("Student added {}", student);
        return studentRepository.save(student);
    }

    public Student findStudent(long id) {
        logger.info("The method that finds the student is invoked");
        return studentRepository.findById(id).orElse(null) ;
    }

    public Student editStudent(long id, Student student) {
        logger.info("The method that edits the student is invoked");
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        logger.info("The method that deletes the student is invoked");
        logger.debug("Student terminated {}", studentRepository.findById(id));
        studentRepository.deleteById(id);
    }

    public Collection<Student> findByAge(int age) {
        logger.info("The method that finds the student is invoked");
        return studentRepository.findByAge(age);
    }

    public Collection<Student> findAll() {
        logger.info("The method that finds all the students is invoked");
        return studentRepository.findAll();
    }

    public Collection<Student> findByAgeBetween(int minAge, int maxAge) {
        logger.info("Tht method that finds all the student between min and max ages is invoked");
        return studentRepository.findByAgeBetween(minAge, maxAge);

    }
    public Long getStudentsByAmount() {
        logger.info("The methods that gets students by amount is invoked");
        return studentRepository.getStudentsByAmount();
    }

    public double getStudentsAverageAge() {
        logger.info("The method that gets students average age is invoked");
        return studentRepository.getStudentsAverageAge();
    }

    public java.util.List<Student> getFiveLastStudents() {
        logger.info("The method that gets five last students is invoked");
        return studentRepository.getFiveLastStudents();
    }

    public Collection<Student> getStudentsByName(String name) {
        logger.info("The method that gets students by name is invoked");
        return studentRepository.getStudentByName(name);
    }

}

