package com.api.usercollege.controller;

import com.api.usercollege.model.Student;
import com.api.usercollege.service.StudentService;
import com.api.usercollege.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/year/{year}")
    public ResponseEntity<List<Student>> getStudentByYearOfRegistration(@PathVariable int year){
        return new ResponseEntity<>(studentService.getStudentByYearOfRegistration(year), HttpStatus.FOUND);
    }

}
