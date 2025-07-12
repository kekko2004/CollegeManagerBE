package com.api.course.service;

import com.api.course.model.Course;
import com.api.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CourseService {
    // only CRUD operation, even less: create and delete, something update general updating
    @Autowired
    private final CourseRepository courseRepository ;
    @Autowired
    public final Searching searching;
    public CourseService(CourseRepository courseRepository, Searching searching) {
        this.courseRepository = courseRepository;
        this.searching = searching;
    }

    public Course createCourse(Course course){
        return courseRepository.save(course);
    }
    public void openSubscription(){
        for(Course c: courseRepository.findBySubscriptionStartDayAfter(new Date())){
            c.setSubscriptionOpen(true);
            courseRepository.save(c);
        }
    }

    public void closeSubscription(){
        for(Course c: courseRepository.findBySubscriptionEndDayBefore(new Date())){
            c.setSubscriptionOpen(false);
            courseRepository.save(c);
        }
    }
    public void deleteCourse(Long id){
        courseRepository.deleteById(id);
    }
    //delete only courses that are open not terminated
    //for that non terminated will be created a list where it's need a prof replacement
    public void deleteCoursesByProfId(String freshman){
        for(Course c: searching.getCoursesByProfCode(freshman)) {
            if (c.isSubscriptionOpen() || c.getStart().after(new Date())) {
                deleteCourse(c.getId());
            }else{
                if(!c.getEnd().before(new Date())){
                    c.setProf(null);
                }else{
                    deleteCourse(c.getId());
                }
                //forzatura da fare
            }
        }
    }




}
