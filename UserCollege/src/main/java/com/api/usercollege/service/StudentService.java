package com.api.usercollege.service;

import com.api.usercollege.model.Student;
import com.api.usercollege.model.User;
import com.api.usercollege.repository.StudentRepository;
import com.api.usercollege.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class StudentService extends UserService<Student> {
    @Autowired
    private final StudentRepository studentRepository;
    private final FreshmanService freshmanService;
    @Autowired
    public StudentService(StudentRepository studentRepository, FreshmanService freshmanService) {
        super(studentRepository);  // Passa al costruttore padre
        this.studentRepository = studentRepository;
        this.freshmanService = freshmanService;
    }

    public Student createStudent(Student student){
        String freshman =  freshmanService.generateFreshmanCode("ST");

        student.setFreshman(
                //condizione
                studentRepository.findByFreshman(freshman).isEmpty()
                //alternativa       //alternativa 2
                ? freshman : createStudent(student).getFreshman()
        );
        student.setRegistrationYear(new Date());
        return studentRepository.save(student);
    }



}
