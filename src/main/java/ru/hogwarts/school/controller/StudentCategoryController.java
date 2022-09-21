package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.List;

@RestController
public class StudentCategoryController {

    private final StudentService studentService;

    public StudentCategoryController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students-by-amount")
    public Long getStudentsByAmount() {
        return studentService.getStudentsByAmount();
    }

    @GetMapping("/students-average-age")
    public double getStudentsAverageAge() {
        return studentService.getStudentsAverageAge();
    }

    @GetMapping("/students-last-five")
    public List<Student> getFiveLastStudents() {
        return studentService.getFiveLastStudents();
    }

}