package ru.hogwarts.school.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

    List<Student> findByAge(int age);

    Collection<Student> findByAgeBetween(int age);

}
