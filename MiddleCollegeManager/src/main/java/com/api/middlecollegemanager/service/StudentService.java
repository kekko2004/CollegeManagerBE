package com.api.middlecollegemanager.service;

import com.api.middlecollegemanager.model.advanced.Course;
import com.api.middlecollegemanager.model.advanced.Subscription;
import com.api.middlecollegemanager.model.base.user.Student;
import com.api.middlecollegemanager.model.base.user.User;
import com.api.middlecollegemanager.service.base.UserService;
import com.api.middlecollegemanager.service.func.GenericService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService extends UserService<Student> {
    private final CourseService courseService;
    private final SubscriptionService subscriptionService;
    protected StudentService(GenericService<Student> genericService, CourseService courseService, SubscriptionService subscriptionService) {
        super(genericService);
        this.courseService = courseService;
        this.subscriptionService = subscriptionService;
    }

    public Student getByFreshman(String freshman){
        return  restTemplate.getForObject(getStudent() +"/freshman/" + freshman, Student.class);
    }
    public List<Student> getStudentAssociatedToProfessor(String professor){
        List<Course> courses = courseService.getCourseByProfessor(professor);
        List<Student> students= new ArrayList<>();
        for (Course c: courses){
            for(Subscription s: subscriptionService.courseSubs(c.getId())){
                students.add(this.getByFreshman(s.getStudent()));
            }
        }
        return students.stream()
                .collect(Collectors.toMap(
                        Student::getFreshman,
                        student -> student,
                        (existing, replacement) -> existing))
                .values()
                .stream()
                .toList();
    }

}
