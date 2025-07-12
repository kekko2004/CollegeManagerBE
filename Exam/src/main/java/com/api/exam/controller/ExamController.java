package com.api.exam.controller;

import com.api.exam.model.Exam;
import com.api.exam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/exam")
public class ExamController {
    @Autowired
    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping("/{freshman}")
    public ResponseEntity<List<Exam>> studentExams(@PathVariable String freshman){
        return new ResponseEntity<>(examService.getStudentExam(freshman), HttpStatus.FOUND);
    }

    @GetMapping("/appeal/{appeal}")
    public ResponseEntity<List<Exam>> examsByAppeal(@PathVariable Long appeal){
        return new ResponseEntity<>(examService.getExamByAppeal(appeal), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<Exam> create(@RequestBody Exam exam){
        return new ResponseEntity<>(examService.create(exam), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id ){
        examService.delete(id);
    }
}
