package com.api.middlecollegemanager.service.func;

import com.api.middlecollegemanager.model.advanced.Course;
import com.api.middlecollegemanager.model.advanced.Notification;
import com.api.middlecollegemanager.model.base.user.Student;
import com.api.middlecollegemanager.service.CourseService;
import com.api.middlecollegemanager.service.StudentService;
import com.api.middlecollegemanager.service.path.Path;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationFunction extends Path {
    private final StudentService studentService;

   private final CourseService courseService;

    public NotificationFunction(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    public Notification fillNotification(Notification notification){
        Student student = studentService.getByFreshman(notification.getStudent());
        Course course = courseService.getCourseById(notification.getCourse());
        notification.setStud_name(student.getName());
        notification.setStud_surname(student.getSurname());
        notification.setCourse_name(course.getSubject_name());
        return notification;
    }

    public List<Notification> bindingNotification(List<Notification> notifications){
        for(Notification n: notifications){
            this.fillNotification(n);
        }
        return notifications;
    }

}
