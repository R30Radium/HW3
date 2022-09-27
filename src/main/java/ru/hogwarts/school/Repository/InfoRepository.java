package ru.hogwarts.school.Repository;

import org.springframework.http.ResponseEntity;

public interface InfoRepository {
    ResponseEntity<Integer> getServerPort();

}