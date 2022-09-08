package ru.hogwarts.school.Repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.model.Avatar;

import java.util.List;
import java.util.Optional;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {

    @Query(value = "SELECT FROM table_hogwarts expenses offset 1", nativeQuery = true)
    List<Avatar> getAvatarByPage(PageRequest pageRequest);

    Optional<Avatar> findByStudentId(Long studentId);


}