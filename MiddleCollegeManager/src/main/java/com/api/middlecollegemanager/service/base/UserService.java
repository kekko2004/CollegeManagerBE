package com.api.middlecollegemanager.service.base;

import com.api.middlecollegemanager.model.base.user.User;
import com.api.middlecollegemanager.service.func.GenericService;
import com.api.middlecollegemanager.service.path.Path;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public abstract class UserService<T extends User> extends Path {
    private final GenericService<T> genericService;

    protected UserService(GenericService<T> genericService) {
        this.genericService = genericService;
    }


    @SuppressWarnings("unchecked")
    public T getByEmail(String email){
        return (T) restTemplate.getForObject("/email/" + email, User.class);
    }
    @SuppressWarnings("unchecked")
    public List<T> getAll(String path){
        return (List<T>) restTemplate.getForObject(path, List.class);
    }
}
