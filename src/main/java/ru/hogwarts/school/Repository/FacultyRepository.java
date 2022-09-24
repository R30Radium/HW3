package ru.hogwarts.school.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;

@Repository
public interface FacultyRepository extends JpaRepository <Faculty, Long> {

    Collection<Faculty> findByColor(String color);

    Collection<Student> getStudentByName(String name);
    Collection<Faculty> findByName(String name);


    Collection<Faculty> getFacultiesByNameAndColor(String name, String color);
}
