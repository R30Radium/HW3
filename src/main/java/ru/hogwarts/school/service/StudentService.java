package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.Repository.StudentRepository;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.model.StudentByCategory;

import java.util.Collection;
import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    private StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findStudent(long id) {
        return studentRepository.findById(id).orElse(null) ;
    }

    public Student editStudent(long id, Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    public Collection<Student> findByAge(int age) {
        return studentRepository.findByAge(age);
    }

    public Collection<Student> findAll() {
        return studentRepository.findAll();
    }

    public Collection<Student> findByAgeBetween(int minAge, int maxAge) {
        return studentRepository.findByAgeBetween(minAge, maxAge);

    }

    public List<StudentByCategory> getStudentsByAverageAge() {
        return studentRepository.getStudentsByAverageAge();
    }

    public List<StudentByCategory> getStudentsByLastId () {
        return studentRepository.getStudentsByLastId();
    }

}

