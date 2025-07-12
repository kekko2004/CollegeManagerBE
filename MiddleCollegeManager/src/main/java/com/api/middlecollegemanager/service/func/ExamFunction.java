package com.api.middlecollegemanager.service.func;

import com.api.middlecollegemanager.model.advanced.Exam;
import com.api.middlecollegemanager.model.base.school.Appeal;
import com.api.middlecollegemanager.model.base.user.Student;
import com.api.middlecollegemanager.service.AppealService;
import com.api.middlecollegemanager.service.StudentService;
import com.api.middlecollegemanager.service.path.Path;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamFunction extends Path {
    private final AppealService appealService;
    private final StudentService studentService;

    public ExamFunction(AppealService appealService, StudentService studentService) {
        this.appealService = appealService;
        this.studentService = studentService;
    }

    public Exam fillExam(Exam exam){
        Appeal appeal = appealService.getById(exam.getAppeal());
        Student student = studentService.getByFreshman(exam.getFreshman());
        exam.setAppeal_type(appeal.getType());
        exam.setDate(appeal.getDate());
        exam.setCourse_name(appeal.getCourse_name());
        exam.setCourse(appeal.getCourse());
        return exam;
    }
    public List<Exam> bindingExam(List<Exam> exams){
        for(Exam e: exams){
            this.fillExam(e);
        }

        return exams;
    }

}
