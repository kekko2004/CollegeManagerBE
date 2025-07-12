package com.api.course.service;

import com.api.course.model.Course;
import com.api.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

/*
 * serching methods:
 * by id, prof, subject, categories
 * when starts/ends
 * when subscription are open/close
 * when star/end Subscriptions
 *
 */
@Service
public class Searching {
    @Autowired
    private final CourseRepository courseRepository ;
    public Searching(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    /* query by fields*/
    public Course getCourseById(Long id){
        return courseRepository.findById(id).orElse(null);
    }
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }
    public List<Course> getBySubject(String id ){
        return courseRepository.findBySubject(id);

    }
    public List<Course> getByDepartment(Long id){
        return courseRepository.findByDepartment(id);

    }
    //for courses haven't a prof, in the api just replace code with null
    public List<Course> getCoursesByProfCode(String code){
        return courseRepository.findByProf(code);
    }
    /* query by date*/
    public List<Course> getEndedCourses(){
        return courseRepository.findByEndBefore(new Date());
    }  // ok
   /* public List<Course> getNotEndedCourses(){
         return courseRepository.findByEndAfter(new Date());
    }
    public List<Course> getStartedCourses(){
        return courseRepository.findByStartBefore(new Date());
    }*/
    public List<Course> getRunningCourses(){
        return courseRepository.findByStartBeforeAndEndAfter(new Date(), new Date());
    } // ok
    public List<Course> getNotStartedCourses(){
        return courseRepository.findByStartAfter(new Date());
    }  // ok
    /* query on subscription*/
    public List<Course> getOpenSubscriptionCourse(){
        return courseRepository.findBySubscriptionOpenTrue();
    }
    public List<Course> getClosedSubscriptionCourse(){
        return courseRepository.findBySubscriptionOpenFalse();
    }
}
