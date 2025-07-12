package com.api.middlecollegemanager.service;

import com.api.middlecollegemanager.model.base.school.Department;
import com.api.middlecollegemanager.service.func.GenericService;
import com.api.middlecollegemanager.service.path.Path;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
@Service
public class DepartmentService extends Path {
    private final GenericService<Department> genericService;

    public DepartmentService(GenericService<Department> genericService) {
        this.genericService = genericService;
    }

    public Department getDepartmentById(Long id){
        return restTemplate.getForObject(getDepartment() + "/" + id, Department.class);
    }
    public List<Department> getAllDepartment(){
        return genericService.getAll(getDepartment(), Department[].class);
    }


}
