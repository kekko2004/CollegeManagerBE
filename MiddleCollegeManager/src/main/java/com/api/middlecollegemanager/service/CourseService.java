package com.api.middlecollegemanager.service;

import com.api.middlecollegemanager.model.advanced.Course;
import com.api.middlecollegemanager.model.advanced.Subscription;
import com.api.middlecollegemanager.service.func.CourseFunction;
import com.api.middlecollegemanager.service.path.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Service
public class CourseService extends Path{
    //course pattern has: prof: code, name, surname  department: name  subject: name
    private final CourseFunction courseFunction;
    private final SubscriptionService subscriptionService;
    public CourseService (CourseFunction courseFunction, SubscriptionService subscriptionService) {
        this.courseFunction = courseFunction;
        this.subscriptionService = subscriptionService;
    }

    public List<Course> getAll(){
       return courseFunction.baseFunction("");
    }

    public Course getCourseById(Long id){
        return courseFunction.fillCourse(restTemplate.getForObject(getCourse() + "/" + id, Course.class));

    }
    // for professor/subject/department
    public List<Course> getCourseOfStudent(String student){
        List<Course> courses = new ArrayList<>();
        Subscription[] subs = restTemplate.getForObject(
                getRequest() + "/freshman/" + student,
                Subscription[].class
        );
        if(subs ==null || subs.length == 0 ){
            return courses;
        }
        for(Subscription s: subs){
            if(s.getCourse()!=null && s !=null){
                Course c = restTemplate.getForObject(
                        getCourse() +"/" + s.getCourse(),
                        Course.class
                );
                if(c!= null){
                    courses.add(this.courseFunction.fillCourse(c));
                }
            }
        }
        return courses;
    }
    public List<Course> getCourseBySubject(String id){
        return courseFunction.baseFunction("/subject/" + id);
    }
    public  List<Course> getCourseByDeparment(Long id){
        return courseFunction.baseFunction("/department/" + id);
    }
    public  List<Course> getCourseByProfessor(String id){
        return courseFunction.baseFunction("/professor/" + id);
    }
    public List<Course> getCourseOnDate(String path){
        return courseFunction.baseFunction("/" + path);
    }
    public List<Course> getCourseOnDateSubscription(String path) {return courseFunction.baseFunction("/subscription/" + path);}
}
