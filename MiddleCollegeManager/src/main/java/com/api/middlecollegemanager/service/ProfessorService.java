package com.api.middlecollegemanager.service;

import com.api.middlecollegemanager.model.base.user.Professor;
import com.api.middlecollegemanager.service.base.UserService;
import com.api.middlecollegemanager.service.func.GenericService;
import com.api.middlecollegemanager.service.path.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ProfessorService extends UserService<Professor> {

    protected ProfessorService(GenericService<Professor> genericService) {
        super(genericService);
    }
    public Professor getByFreshman(String freshman){
        return restTemplate.getForObject(getProfessor() + "/freshman/"+ freshman, Professor.class);
    }
}
