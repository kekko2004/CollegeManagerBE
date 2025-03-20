package com.api.usercollege.service;

import com.api.usercollege.model.Student;
import com.api.usercollege.model.User;
import com.api.usercollege.repository.StudentRepository;
import com.api.usercollege.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService extends UserService<Student> {
    @Autowired
    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

//solo nel service studente serve questo
    public List<Student> getStudentByYearOfRegistration(int year){
        return studentRepository.findByRegistrationYear(year);
    }

}
