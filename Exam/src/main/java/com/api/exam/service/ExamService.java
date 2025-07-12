package com.api.exam.service;

import com.api.exam.model.Exam;
import com.api.exam.repository.ExamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {
    @Autowired
    private final ExamRepo examRepo;

    public ExamService(ExamRepo examRepo) {
        this.examRepo = examRepo;
    }

    public List<Exam> getStudentExam(String freshman){
        return examRepo.findByFreshman(freshman);
    }

    public List<Exam> getExamByAppeal(Long appeal){
        return examRepo.findByAppeal(appeal);
    }

    public Exam create(Exam exam){
        return examRepo.save(exam);
    }

    public void delete(Long id){
        examRepo.deleteById(id);
    }
}
