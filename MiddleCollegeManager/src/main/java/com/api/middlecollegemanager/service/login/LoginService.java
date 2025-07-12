package com.api.middlecollegemanager.service.login;

import com.api.middlecollegemanager.model.advanced.UserLogin;
import com.api.middlecollegemanager.model.advanced.UserLoginResponse;
import com.api.middlecollegemanager.model.base.user.Professor;
import com.api.middlecollegemanager.model.base.user.Student;
import com.api.middlecollegemanager.service.path.Path;
import org.springframework.stereotype.Service;

@Service
public class LoginService extends Path {
    private Student findStudent(String email){
        return restTemplate.getForObject(getStudent() +"/email/"+ email, Student.class);
    }

    private Professor findProfessor(String email){
        return restTemplate.getForObject(getProfessor() +"/email/"+ email, Professor.class);
    }

    public UserLoginResponse login(UserLogin user){
        Student student = findStudent(user.getEmail());
        if(student!=null){
            if(student.getPassword().equals(user.getPassword())){
                return new UserLoginResponse("OK", student.getFreshman());
            }else{
                return new UserLoginResponse("UNAUTHORIZATED", null);
            }
        }else{
            Professor professor = findProfessor(user.getEmail());
            if(professor!=null){
                if(professor.getPassword().equals(user.getPassword())){
                    return new UserLoginResponse("OK", professor.getFreshman());
                }else{
                    return new UserLoginResponse("UNAUTHORIZATED", null);
                }
            }else{
                return new UserLoginResponse("NOT FOUND", null);
            }
        }
    }

}