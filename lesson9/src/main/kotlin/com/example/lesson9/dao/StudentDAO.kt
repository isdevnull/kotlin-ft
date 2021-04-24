package com.example.lesson9.dao

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class StudentDAO {

    @Bean
    fun getData(): MutableMap<Int, Student> = listOf(
        Student(1, "Joshua", "Hensley"),
        Student(2, "James", "Roxley"),
        Student(3, "Dave", "Meyers")
    ).associateBy { it.id }.toMutableMap()
}