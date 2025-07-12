package com.api.middlecollegemanager.service.func;

import com.api.middlecollegemanager.model.advanced.Booklet;
import com.api.middlecollegemanager.model.advanced.Course;
import com.api.middlecollegemanager.model.base.school.Appeal;
import com.api.middlecollegemanager.model.base.user.Student;
import com.api.middlecollegemanager.service.AppealService;
import com.api.middlecollegemanager.service.CourseService;
import com.api.middlecollegemanager.service.StudentService;
import com.api.middlecollegemanager.service.path.Path;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookletFunction extends Path {
    private final AppealService appealService;
    private final CourseService courseService;
    private final StudentService studentService;
    public BookletFunction(AppealService appealService, CourseService courseService, StudentService studentService) {
        this.appealService = appealService;
        this.courseService = courseService;
        this.studentService = studentService;
    }

    public Booklet fillBooklet(Booklet booklet){
        Appeal appeal = appealService.getById(booklet.getAppeal());
        booklet.setAppeal(appeal.getId());
        booklet.setAppeal_date(appeal.getDate());
        booklet.setAppeal_type(appeal.getType());
        Course course = courseService.getCourseById(appeal.getCourse());
        booklet.setCourse(course.getId());
        booklet.setCourse_name(course.getSubject_name());
        Student student = studentService.getByFreshman(booklet.getFreshman());
        booklet.setStudent(student.getName() + " " + student.getSurname());
        return booklet;
    }
    public List<Booklet> BindingBooklet(List<Booklet> booklets){
        for (Booklet b: booklets){
            fillBooklet(b);
        }
        return booklets;
    }


}
