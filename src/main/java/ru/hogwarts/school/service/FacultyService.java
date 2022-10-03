package ru.hogwarts.school.service;


import org.springframework.stereotype.Service;
import ru.hogwarts.school.Repository.FacultyRepository;
import ru.hogwarts.school.model.Faculty;

import java.util.Collection;
import java.util.Comparator;

@Service
public class FacultyService {

    private FacultyRepository facultyRepository;

    private FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty addFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(long id) {
        return facultyRepository.findById(id).orElse(null);
    }

    public Faculty editFaculty(Faculty faculty, Long id) {
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id) {
        facultyRepository.deleteById(id);
    }

    public Collection <Faculty> findByColor(String color) {
        return facultyRepository.findByColor(color);
    }

    public Collection<Faculty> findByName(String name) {
        return facultyRepository.findByName(name);
    }

    public Collection<Faculty> findAll() {
        return facultyRepository.findAll();
    }


    public Collection<Faculty> getFacultiesByNameAndColor(String name, String color) {
        return facultyRepository.getFacultiesByNameAndColor(name, color);
    }

    public String getLongestFacultyName() {
        Collection<Faculty> faculties = findAll();
        return faculties.stream()
                .map(Faculty::getName)
                .max(Comparator.comparingInt(String::length))
                .get();
    }
}
