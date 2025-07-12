package com.api.course.controller;

import com.api.course.model.Course;
import com.api.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchingController {
    @Autowired
    private final CourseService courseService;
    private final HttpStatus F = HttpStatus.FOUND;
    public CourseService getCourseService(){
        return this.courseService;
    }
    public SearchingController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAll(){
        return new ResponseEntity<>(courseService.searching.getAllCourses(), F);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Course> getById(@PathVariable Long id){
        return new ResponseEntity<>(courseService.searching.getCourseById(id), F);
    }
    //subject code
    @GetMapping("/subject/{subject}")
    public ResponseEntity<List<Course>> getBySubject(@PathVariable String subject){
        return new ResponseEntity<>(courseService.searching.getBySubject(subject), F);
    }

    @GetMapping("/department/{department}")
    public ResponseEntity<List<Course>> getByDepartment(@PathVariable Long department){
        return new ResponseEntity<>(courseService.searching.getByDepartment(department), F);
    }

    @GetMapping("/professor/{freshman}")
    public ResponseEntity<List<Course>> getByProf_code(@PathVariable String freshman){
        return new ResponseEntity<>(courseService.searching.getCoursesByProfCode(freshman), F);
    }
   /*
   * id
   * subject/
   * department/
   * professor/
   * ended
   * subscription/close or open
   * running
   * notStarted
   *
   * */
    @GetMapping("/ended")
    public ResponseEntity<List<Course>> getEndedCourse(){
        return new ResponseEntity<>(courseService.searching.getEndedCourses(), F);
    }

    @GetMapping("/notStarted")
    public ResponseEntity<List<Course>> getNotStartedCourse(){
        return new ResponseEntity<>(courseService.searching.getNotStartedCourses(), F);
    }

    @GetMapping("/running")
    public ResponseEntity<List<Course>> getCourseOnRunning(){
        return new ResponseEntity<>(courseService.searching.getRunningCourses(), F);
    }
    @GetMapping("/subscription/open")
    public ResponseEntity<List<Course>> getCourseWithOpenSubs(){
        return new ResponseEntity<>(courseService.searching.getOpenSubscriptionCourse(), F);
    }

    @GetMapping("/subscription/close")
    public ResponseEntity<List<Course>> getCourseWithClosedSubs(){
        return new ResponseEntity<>(courseService.searching.getClosedSubscriptionCourse(), F);
    }
}
