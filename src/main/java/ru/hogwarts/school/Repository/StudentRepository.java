package ru.hogwarts.school.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.model.StudentByCategory;

import java.util.Collection;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

    @Query(value = "SELECT FROM table_hogwarts LIMIT all", nativeQuery = true)
    List<Student> getStudentsByAge();

    @Query(value = "SELECT FROM table_hogwarts AVG(age)", nativeQuery = true)
    List<StudentByCategory> getStudentsByAverageAge();

    @Query(value = "SELECT FROM table_hogwarts ORDER BY id DESC LIMIT 5", nativeQuery = true)
    List<StudentByCategory> getStudentsByLastId();


    List<Student> findByAge(int age);

    Collection<Student> findByAgeBetween(int age, int properAge);



}
