package com.api.middlecollegemanager.service.func;

import com.api.middlecollegemanager.model.advanced.Course;
import com.api.middlecollegemanager.model.base.school.Department;
import com.api.middlecollegemanager.model.base.school.Subject;
import com.api.middlecollegemanager.model.base.user.Professor;
import com.api.middlecollegemanager.service.DepartmentService;
import com.api.middlecollegemanager.service.ProfessorService;
import com.api.middlecollegemanager.service.SubjectService;
import com.api.middlecollegemanager.service.path.Path;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class CourseFunction extends Path {
    public Course fillCourse(Course course){
        Professor professor = restTemplate.getForObject(
                        getProfessor() + "/freshman/" + course.getProf(),
                        Professor.class);

        course.setDepartment_name(
                restTemplate.getForObject(
                        getDepartment() + "/" + course.getDepartment(),
                        Department.class)
                        .getName());
        course.setSubject_name(restTemplate.getForObject(
                        getSubject() + "/id/" + course.getSubject(),
                        Subject.class)
                .getSubject());
        course.setProf_surname(professor.getSurname());
        course.setProf_name(professor.getName());
        return course;
    }
    public List<Course> BindingListCourses(List<Course> courses){
        for(Course c: courses){
            this.fillCourse(c);

        }
        return courses;
    }
    public List<Course> baseFunction(String path){
        Course[] coursesArray = restTemplate.getForObject(
                getCourse() + path,
                Course[].class
        );
        List<Course> courses = Arrays.asList(coursesArray);
        return this.BindingListCourses(courses);
    }
}
