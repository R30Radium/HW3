package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.school.model.StudentByCategory;
import ru.hogwarts.school.service.StudentService;

import java.util.List;

@RestController
public class StudentByCategoryController {

    private final StudentService studentService;

    public StudentByCategoryController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/students-average-age")
    public List<StudentByCategory> getStudentsByAverageAge() {
        return studentService.getStudentsByAverageAge();
    }

    @GetMapping("/students-last-id")
    public List<StudentByCategory>getStudentsByLastId() {
        return studentService.getStudentsByLastId();
    }

}
