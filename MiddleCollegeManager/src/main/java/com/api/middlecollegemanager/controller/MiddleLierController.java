package com.api.middlecollegemanager.controller;
import com.api.middlecollegemanager.model.advanced.*;
import com.api.middlecollegemanager.model.base.school.Appeal;
import com.api.middlecollegemanager.model.base.user.Student;
import com.api.middlecollegemanager.service.*;
import com.api.middlecollegemanager.service.func.BookletFunction;
import com.api.middlecollegemanager.service.login.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class MiddleLierController {
    private final NotificationService notificationService;
    private final SubscriptionService subscriptionService;
    private final BookletService bookletService;
    private final CourseService courseService;
    private final AppealService appealService;
    private final LoginService loginService;
    private final BookletFunction bookletFunction;
    private final ExamService examService;
    private final StudentService studentService;
    public MiddleLierController(NotificationService notificationService, SubscriptionService subscriptionService, BookletService bookletService, CourseService courseService, AppealService appealService, LoginService loginService, BookletFunction bookletFunction, ExamService examService, StudentService studentService) {
        this.notificationService = notificationService;
        this.subscriptionService = subscriptionService;
        this.bookletService = bookletService;
        this.courseService = courseService;
        this.appealService = appealService;
        this.loginService = loginService;
        this.bookletFunction = bookletFunction;
        this.examService = examService;
        this.studentService = studentService;
    }

    @GetMapping("/Course")
    public ResponseEntity<List<Course>> getAllCourses(){
        return new ResponseEntity<>(courseService.getAll(), HttpStatus.FOUND);
    }

    @GetMapping("/login")
    public ResponseEntity<UserLoginResponse> login(@RequestBody UserLogin loginRequest) {
        return new ResponseEntity<>(loginService.login(loginRequest), HttpStatus.OK);
    }
    @GetMapping("/List/Subscription/{course}")
    public ResponseEntity<List<Subscription>> getSubscriptionOfCourse(@PathVariable Long course){


        return new ResponseEntity<>(subscriptionService.courseSubs(course), HttpStatus.FOUND);
    }
    @GetMapping("/List/Notifications")
    public ResponseEntity<List<Notification>> getNotification(){
        return new ResponseEntity<>(notificationService.getAll(), HttpStatus.FOUND);
    }
    // ended subscription/close or open  running notStarted
    @GetMapping("Course/date/{path}")
    public ResponseEntity<List<Course>> getCourseByDate(@PathVariable String path){
        return switch (path) {
            case "ended", "running", "notStarted" ->
                    new ResponseEntity<>(courseService.getCourseOnDate(path), HttpStatus.FOUND);
            default -> new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        };
    }
    @GetMapping("Course/date/subscription/{path}")
    public ResponseEntity<List<Course>> getCourseByDateSubscriptions(@PathVariable String path){
        return switch (path) {
            case "open", "close" ->
                    new ResponseEntity<>(courseService.getCourseOnDateSubscription(path), HttpStatus.FOUND);
            default -> new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        };
    }

    @GetMapping("/Course/id/{id}")//path will be added to api request in FE
    public ResponseEntity<Course> getCourseById(@PathVariable Long id){
        return new ResponseEntity<>(courseService.getCourseById(id), HttpStatus.FOUND);
    }
    @GetMapping("/Course/department/{id}")//path will be added to api request in FE
    public ResponseEntity<List<Course>> getCourseByDeparment(@PathVariable Long id){
        return new ResponseEntity<>(courseService.getCourseByDeparment(id), HttpStatus.FOUND);
    }
    @GetMapping("/Course/subject/{id}")//path will be added to api request in FE
    public ResponseEntity<List<Course>> getCourseBySubject(@PathVariable String id){
        return new ResponseEntity<>(courseService.getCourseBySubject(id), HttpStatus.FOUND);
    }
    @GetMapping("/Course/professor/{id}")//path will be added to api request in FE
    public ResponseEntity<List<Course>> getCourseByProfessor(@PathVariable String id){
        return new ResponseEntity<>(courseService.getCourseByProfessor(id), HttpStatus.FOUND);
    }

    @GetMapping("/Appeal/course/{course}")
    public ResponseEntity<List<Appeal>> getAppealByCourse(@PathVariable Long course){


        return new ResponseEntity<>(appealService.getAppealByCourse(course), HttpStatus.FOUND);
    }
    @GetMapping("/Appeal/ended")
    public ResponseEntity<List<Appeal>> getAppealByDate(){
        return new ResponseEntity<>(appealService.getEndedAppeals(), HttpStatus.FOUND);
    }

    @GetMapping("/Appeal/{date}")
    public ResponseEntity<List<Appeal>> getAppealByDateAfter(@PathVariable String date){
        System.out.println(date);
        return new ResponseEntity<>(appealService.getAppealsAfter( date), HttpStatus.FOUND);
    }
    @GetMapping("/Exam/{student}")
    public ResponseEntity<List<Exam>> getExamOfStudent(@PathVariable String student){
        return new ResponseEntity<>(examService.getStudentExams(student), HttpStatus.FOUND);
    }
    @GetMapping("/Student/professor/{professor}")
    public ResponseEntity<List<Student>> getStudent(@PathVariable String professor){
        return new ResponseEntity<>(studentService.getStudentAssociatedToProfessor(professor), HttpStatus.FOUND);
    }
    @GetMapping("/Course/student/{freshman}")
    public ResponseEntity<List<Course>> getCourseOfStudent(@PathVariable String freshman){
        return new ResponseEntity<>(courseService.getCourseOfStudent(freshman), HttpStatus.FOUND);
    }

    @GetMapping("/Booklet/{student}")
    public ResponseEntity<List<Booklet>> getStudentBooklet(@PathVariable String student){
        return new ResponseEntity<>(bookletService.StudentBooklet(student), HttpStatus.FOUND);
    }
    @GetMapping("/Course/register/{course}")
    public ResponseEntity<List<Booklet>> getRegisterCourse(@PathVariable Long course){
        return new ResponseEntity<>(bookletFunction.BindingBooklet(bookletService.register(course)), HttpStatus.FOUND);
    }



}
