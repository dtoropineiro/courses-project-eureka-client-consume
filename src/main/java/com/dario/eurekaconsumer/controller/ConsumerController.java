package com.dario.eurekaconsumer.controller;

import com.dario.eurekaconsumer.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController("/api/consume")
public class ConsumerController {

    private static final String COURSES_PROJECT_URL = "http://courses-projects";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public List<Student> findAll() {
        ResponseEntity<Student[]> responseEntity = restTemplate.getForEntity(COURSES_PROJECT_URL + "/students/all", Student[].class);
        return Arrays.asList(responseEntity.getBody());
    }

}
