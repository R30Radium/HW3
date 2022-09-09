package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentInfo(@PathVariable Long id) {
        Student student = studentService.findStudent(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> editStudent( @PathVariable Student student, Long id) {
        Student foundStudent = studentService.editStudent(id, student);
        return ResponseEntity.ok(foundStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{age}")
    public ResponseEntity<Collection<Student>> findStudents(@RequestParam(required = false) Integer age) {
        if (age != null) {
            return ResponseEntity.ok(studentService.findByAge(age));
        }
        return ResponseEntity.ok(Collections.emptyList());
    }

    @GetMapping
    public ResponseEntity<Collection<Student>> findStudents
            (@RequestParam(required = false) Integer age,
             @RequestParam(required = false) Integer minAge,
             @RequestParam(required = false) Integer maxAge) {



        if (minAge != null && maxAge != null && minAge > 0 && maxAge < Integer.MAX_VALUE) {
            return ResponseEntity.ok(studentService.findByAgeBetween(minAge, maxAge));
        }
        if (age != null && age > 0) {
            return ResponseEntity.ok(studentService.findByAge(age));
        }
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/{id}/faculty") public ResponseEntity<Faculty>
    findFacultyByStudent(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.findStudent(id).getFaculty());
    }

    @GetMapping("/students-average-age")
    public List<Integer> getStudentsByAverageAge() {
        return studentService.getStudentsByAverageAge();
    }

    @GetMapping("/students-last-id")
    public List<Long>getStudentsByLastId(long id) {
        return studentService.getStudentsByLastId(id);
    }
}

