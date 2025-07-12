package com.api.middlecollegemanager.service.func;

import com.api.middlecollegemanager.service.path.Path;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
@Service
public class GenericService<T> extends Path{
    public List<T> getAll(String url, Class<T[]> classType) {
        try {
            T[] list = restTemplate.getForObject(url, classType);
            return  Arrays.asList(list);
        } catch (RestClientException e) {
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }


    // for professor/subject/department



}
