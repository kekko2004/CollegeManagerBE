package com.api.middlecollegemanager.service.func;

import com.api.middlecollegemanager.model.advanced.Course;
import com.api.middlecollegemanager.model.base.school.Appeal;
import com.api.middlecollegemanager.service.CourseService;
import com.api.middlecollegemanager.service.path.Path;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppealFunction extends Path {
    private final CourseService courseService;

    public AppealFunction(CourseService courseService) {
        this.courseService = courseService;
    }

    public Appeal fillAppeal(Appeal appeal){
        Course course = courseService.getCourseById(appeal.getCourse());
        appeal.setCourse(course.getId());
        appeal.setCourse_name(course.getSubject_name());
        return appeal;
    }

    public List<Appeal> BindingList(List<Appeal> appeals){
        for(Appeal a: appeals){
            this.fillAppeal(a);
        }
        return appeals;
    }
}
