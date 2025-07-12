package com.api.usercollege.controller;

import com.api.usercollege.model.Student;
import com.api.usercollege.service.StudentService;
import com.api.usercollege.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/student")
public class StudentController extends UserController<Student>{
    @Autowired
    private final StudentService studentService;

    public StudentController(UserService<Student> userService, StudentService studentService) {
        super(userService);
        this.studentService = studentService;
    }
    @PostMapping("/create")
    public ResponseEntity<Student> create(@RequestBody Student student){
        return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.CREATED);
    }



}
