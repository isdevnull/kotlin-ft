package com.example.lesson9

import com.example.lesson9.dao.Faculty
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class FacultyIntegrationComponent {

    private val facultyServer = WebClient.create("http://localhost:8080")

    fun getFacultyForStudentId(id: Int) = facultyServer
        .get()
        .uri("/faculty/studentId=${id}")
        .retrieve()
        .bodyToMono(Faculty::class.java)
        .block()
}