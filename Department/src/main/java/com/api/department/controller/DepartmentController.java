package com.api.department.controller;

import com.api.department.model.Department;
import com.api.department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2/department")
public class DepartmentController {
    @Autowired
    private final DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAll(){
        return new ResponseEntity<>(departmentRepository.findAll(), HttpStatus.FOUND);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Department> getById(@PathVariable Long id){
        return new ResponseEntity<>(departmentRepository.findById(id).orElse(null), HttpStatus.FOUND);
    }
    @PostMapping
    public ResponseEntity<Department> create(@RequestBody Department department){
        return new ResponseEntity<>(departmentRepository.save(department), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Department> update(@PathVariable Long id, @RequestBody Department department){
        if(departmentRepository.findById(id).isPresent()){
            department.setId(id);
        }
        return new ResponseEntity<>(departmentRepository.save(department), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void Delete(@PathVariable Long id){
        departmentRepository.deleteById(id);
    }

}
