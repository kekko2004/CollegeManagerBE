package com.api.middlecollegemanager.service;

import com.api.middlecollegemanager.model.advanced.Exam;
import com.api.middlecollegemanager.model.base.school.Appeal;
import com.api.middlecollegemanager.service.func.AppealFunction;
import com.api.middlecollegemanager.service.func.ExamFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ExamService{
    @Autowired
    private final ExamFunction examFunction;
    private final AppealService appealService;

    public ExamService(ExamFunction examFunction, AppealService appealService) {
        this.examFunction = examFunction;
        this.appealService = appealService;
    }

    public List<Exam> getStudentExams(String freshman){
        Exam[] exams = examFunction.restTemplate.getForObject(
                examFunction.getExam() + "/" + freshman,
                Exam[].class
        );
        return exams.length > 0 ?  examFunction.bindingExam(Arrays.asList(exams)) :  Collections.emptyList();
    }

    public List<Exam> getExamsByAppeal(Long appeal){
        Exam[] exams = examFunction.restTemplate.getForObject(
                examFunction.getExam() + "/appeal/" + appeal,
                Exam[].class
        );
         return exams.length > 0 ?  examFunction.bindingExam(Arrays.asList(exams)) :  Collections.emptyList();
    }

}
