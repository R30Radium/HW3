package ru.hogwarts.school.Repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Avatar;

import java.util.List;
import java.util.Optional;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {

    List<Avatar> getAvatarByPage(PageRequest pageRequest);

    Optional<Avatar> findByStudentId(Long studentId);


}