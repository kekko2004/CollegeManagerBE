package com.api.usercollege.controller;

import com.api.usercollege.model.Professor;
import com.api.usercollege.service.ProfessorService;
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
@RequestMapping("/api/v2/professor")
public class ProfessorController extends UserController<Professor>{
    @Autowired
    private final ProfessorService professorService;
    public ProfessorController(UserService<Professor> userService, ProfessorService professorService) {
        super(userService);

        this.professorService = professorService;
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<List<Professor>> getProfessorsByRole(@PathVariable String role){
        return new ResponseEntity<>(professorService.gets(role), HttpStatus.FOUND);
    }


}
