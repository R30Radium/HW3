package ru.hogwarts.school.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

    @Query(value = "SELECT ALL(age) FROM table_hogwarts", nativeQuery = true)
    List<Student> getStudentsByAge(int age);

    @Query(value = "SELECT AVG(age) FROM table_hogwarts ", nativeQuery = true)
    List<Integer> getStudentsByAverageAge();

    @Query(value = "SELECT * FROM table_hogwarts ORDER BY id DESC LIMIT 5", nativeQuery = true)
    List<Long> getStudentsByLastId(long id);


    List<Student> findByAge(int age);

    Collection<Student> findByAgeBetween(int age, int properAge);



}
