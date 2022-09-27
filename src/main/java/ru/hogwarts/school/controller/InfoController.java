package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.school.Repository.InfoRepository;


@RestController
public class InfoController {

    private final InfoRepository infoRepository;

    public InfoController(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }

    @GetMapping("/getPort")
    public ResponseEntity<Integer> getPort() {
        return infoRepository.getServerPort();
    }

}