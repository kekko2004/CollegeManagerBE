package com.api.usercollege.service;

import com.api.usercollege.model.Professor;
import com.api.usercollege.model.Role;
import com.api.usercollege.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService extends UserService<Professor>{
    @Autowired
    private final ProfessorRepository professorRepository;
    private final FreshmanService freshmanService;
    public ProfessorService(ProfessorRepository professorRepository, FreshmanService freshmanService) {
        super(professorRepository);
        this.professorRepository = professorRepository;
        this.freshmanService = freshmanService;
    }

    public Professor createProfessor(Professor professor){
        String freshman = freshmanService.generateFreshmanCode("PR");
        professor.setFreshman(
                professorRepository.findByFreshman(freshman).isEmpty()

                ? freshman : createProfessor(professor).getFreshman()
        );
        return professorRepository.save(professor);
    }

    public List<Professor> gets(String role){

        if(role.equalsIgnoreCase("PROFESSOR")){
            return professorRepository.findByRole(Role.PROFESSOR);
        }else{

            return professorRepository.findByRole(Role.SUPERVISOR);
        }
    }


}
