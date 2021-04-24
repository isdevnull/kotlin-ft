package com.example.lesson9.controllers

import com.example.lesson9.ResourceNotFoundException
import com.example.lesson9.dao.Faculty
import com.example.lesson9.dao.FacultyDAO
import io.swagger.annotations.Api
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@Api(value="Faculty Controller", description="Handle operations with Faculty DAO")
@RestController
@RequestMapping("/faculty")
class FacultyController(private val facultyData: FacultyDAO) {

    @GetMapping("/studentId={id}")
    fun getFacultyByStudentId(@PathVariable id: Int): Faculty? = facultyData.studentToFaculty()[id] ?: throw ResourceNotFoundException()

    @ExceptionHandler
    fun handleResourceNotFoundException(ex: ResourceNotFoundException): ResponseEntity<String> {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(ex.message)
    }
}