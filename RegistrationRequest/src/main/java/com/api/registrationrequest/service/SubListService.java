package com.api.registrationrequest.service;

import com.api.registrationrequest.Entity.RequestDto;
import com.api.registrationrequest.Entity.SubList;
import com.api.registrationrequest.Entity.SubListDto;
import com.api.registrationrequest.repository.SubListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubListService {
    @Autowired
    private final SubListRepository subListRepository;

    public SubListService(SubListRepository subListRepository) {
        this.subListRepository = subListRepository;
    }

    public List<SubList> getListByCourse(Long id){
        return subListRepository.findByCourse(id);
    }
    public void addSub(RequestDto request){
        subListRepository.save(new SubList(request.getCourse(), request.getStudent()));
    }

    public List<SubList> getListByStudent(String freshman){

        return subListRepository.findByStudent(freshman);
    }
    public void removeFromList(Long id){
        subListRepository.deleteById(id);
    }
}
