package com.example.lesson9.controllers

import com.example.lesson9.dao.Student
import com.example.lesson9.dao.StudentDAO
import com.example.lesson9.FacultyIntegrationComponent
import com.example.lesson9.ResourceNotFoundException
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Api(value="Student Controller", description = "Handle Operations with Student DAO")
@RestController
@RequestMapping("/student")
class StudentController(private val studentData: StudentDAO, private val facultyComponent: FacultyIntegrationComponent) {

    @ApiOperation(value="Get all students from DAO")
    @GetMapping
    fun getAllStudents(): List<Student> {
        val students = studentData.getData()
        students.forEach { (id, student) ->
            student.faculty = facultyComponent.getFacultyForStudentId(id)?.name
        }
        return students.values.toList()
    }

    @ApiOperation(value="Get student by id from DAO")
    @GetMapping("/{id}")
    fun getStudent(@PathVariable id: Int): Student? {
        val resStudent = studentData.getData()[id]
        if (resStudent == null) {
            throw ResourceNotFoundException()
        }
        else {
            resStudent.faculty = facultyComponent.getFacultyForStudentId(resStudent.id)?.name
        }
        return resStudent
    }

    @ApiOperation(value="Add students to DAO")
    @PostMapping
    fun addStudent(@RequestBody student: Student) {
        studentData.getData()[student.id] = student
        println("Student $student was added.")
    }

    @ApiOperation(value="Update student in DAO by id")
    @PutMapping("/{id}")
    fun updateStudent(@PathVariable id: Int, @RequestBody student: Student) {
        println("Student $student was updated.")
    }

    @ApiOperation(value="Delete student in DAO by id")
    @DeleteMapping("/{id}")
    fun deleteStudent(@PathVariable id: Int, @RequestBody student: Student) {
        println("Student $student was deleted.")
    }

    @ExceptionHandler
    fun handleResourceNotFoundException(ex: ResourceNotFoundException): ResponseEntity<String> {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(ex.message)
    }

}