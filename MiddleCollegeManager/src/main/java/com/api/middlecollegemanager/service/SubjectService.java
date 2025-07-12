package com.api.middlecollegemanager.service;

import com.api.middlecollegemanager.model.base.school.Subject;
import com.api.middlecollegemanager.service.func.GenericService;
import com.api.middlecollegemanager.service.path.Path;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService extends Path {
    private final GenericService<Subject> genericService;

    public SubjectService(GenericService<Subject> genericService) {
        this.genericService = genericService;
    }

    public Subject getSubjectById(String id){
        return restTemplate.getForObject(getSubject() + "/" + id, Subject.class);
    }

    public List<Subject> getAllSubject(){
        return genericService.getAll(getSubject(), Subject[].class);
    }
}
