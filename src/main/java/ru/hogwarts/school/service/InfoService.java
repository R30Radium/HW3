package ru.hogwarts.school.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.Repository.InfoRepository;

@Service
public class InfoService implements InfoRepository {

    @Value("${server.port}")

    private Integer serverPort;

    public ResponseEntity<Integer> getServerPort() {
        return ResponseEntity.ok(serverPort);
    }


}