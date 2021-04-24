package com.example.lesson9.dao

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FacultyDAO {

    private val faculties = listOf(
        Faculty(1, "Geology", listOf(1, 2)),
        Faculty(2, "Physics", listOf(3))
    ).associateBy { it.id }

    @Bean
    fun studentToFaculty() = faculties.flatMap {
        faculty ->
        faculty.value.studentsId.map {
            id ->
            id to faculty.value
        }
    }.toMap()
}