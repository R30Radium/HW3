package ru.hogwarts.school.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.hogwarts.school.model.Avatar;

import java.util.Optional;

public interface AvatarRepository extends PagingAndSortingRepository<Avatar, Long> {


    Optional<Avatar> findByStudentId(Long studentId);


}