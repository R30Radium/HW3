package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.Repository.StudentRepository;
import ru.hogwarts.school.model.Student;


import java.util.Collection;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    @Autowired
    private StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findStudent(long id) {
        return studentRepository.findById(id).get() ;
    }

    public Student editStudent(long id, Student student) {
       return studentRepository.save(student);
    }
     /*   students.put(id, student);
        return student;
    } */

    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    public Collection<Student> findByAge(int age) {
        return studentRepository.findAll();
    }

}
   /* public Collection
            <Student> findByAge(int age) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : students.values()) {
            if (student.getAge() == age) {
                result.add(student);
            }
        }
        return result;
    }
}
*/
