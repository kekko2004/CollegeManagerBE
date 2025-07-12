package com.api.course.controller;

import com.api.course.model.Course;
import com.api.course.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/course")
public class CourseController extends SearchingController{
    public CourseController(CourseService courseService) {
        super(courseService);
    }
    @PostMapping("/create")
    public ResponseEntity<Course> createCourse(@RequestBody Course course){
        return new ResponseEntity<>(super.getCourseService().createCourse(course), HttpStatus.CREATED);
    }
    @PostMapping("/open/subscription")
    public void openSubs(){
        super.getCourseService().openSubscription();
    }
    @PostMapping("/close/subscription")
    public void closeSubs(){
        super.getCourseService().closeSubscription();
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        super.getCourseService().deleteCourse(id);
    }

    @DeleteMapping("/delete/professor/{freshman}")
    public void deleteByFreshman(@PathVariable String freshman){
        super.getCourseService().deleteCoursesByProfId(freshman);
    }

}
