package com.api.usercollege.service;

import com.api.usercollege.model.Professor;
import com.api.usercollege.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService extends UserService<Professor>{
    @Autowired
    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }
    public List<Professor> gets(String role){
        if(role.equalsIgnoreCase("PROFESSOR")){
            return professorRepository.findByRole("PROFESSOR");
        }else{
            return professorRepository.findByRole("SUPERVISOR");
        }
    }


}
