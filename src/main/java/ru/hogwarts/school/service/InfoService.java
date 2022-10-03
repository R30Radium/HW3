package ru.hogwarts.school.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.Repository.InfoRepository;

@Service
public class InfoService implements InfoRepository {

    @Value("${server.port}")

    private Integer serverPort;

    public Integer getServerPort() {
        return serverPort; }


}