package com.api.subject.controller;

import com.api.subject.repository.SubjectRepository;
import com.api.subject.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v2/subjects")
public class SubjectController {
    @Autowired
    private final SubjectRepository subjectRepository;

    public SubjectController(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @GetMapping
    public ResponseEntity<List<Subject>> getSubjects(){
        return new ResponseEntity<>(subjectRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{name}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable String name){
        return new ResponseEntity<>(subjectRepository.findBySubject(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject){
        return new ResponseEntity<>(subjectRepository.save(subject), HttpStatus.CREATED);
    }

    @PutMapping ("/{code}")
    public ResponseEntity<Subject> editSubject(@PathVariable String code, @RequestBody Subject subject){
       if(!code.isEmpty()){
           subject.setCode(code);
           return new ResponseEntity<>(subjectRepository.save(subject), HttpStatus.CREATED);
       }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Subject> deleteSubject(@PathVariable String code){
        subjectRepository.deleteById(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
