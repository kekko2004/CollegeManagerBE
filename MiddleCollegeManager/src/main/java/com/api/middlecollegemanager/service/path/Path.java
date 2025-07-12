package com.api.middlecollegemanager.service.path;

import com.api.middlecollegemanager.model.base.school.*;
import com.api.middlecollegemanager.model.base.user.*;
import com.api.middlecollegemanager.model.advanced.*;
import org.springframework.web.client.RestTemplate;


public class Path {
    private final String prefix = "http://localhost:";
    public RestTemplate restTemplate = new RestTemplate();


    public String getStudent() {
        return  prefix +"8082/api/v2/student";
    }

    public String getProfessor() {
        return prefix + "8082/api/v2/professor";
    }

    public String getSubject() {
        return prefix + "8083/api/v2/subject";
    }

    public String getCourse() {
        return prefix + "8084/api/v2/course";
    }

    public String getBooklet() {
        return prefix + "8085/api/v2/booklet";
    }

    public String getDepartment() {
        return prefix + "8086/api/v2/department";
    }

    public String getRequest() {
        return prefix + "8087/api/v2/request";
    }

    public String getAppeal() {
        return prefix + "8088/api/v2/appeal";
    }
    public String getExam() {
        return prefix + "8089/api/v2/exam";
    }
}
