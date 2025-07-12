package com.api.registrationrequest.service;

import com.api.registrationrequest.Entity.RequestDto;
import com.api.registrationrequest.Entity.SubList;
import com.api.registrationrequest.repository.RequestRepo;
import com.api.registrationrequest.repository.SubListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RequestService {
    @Autowired
    private final RequestRepo requestRepo;
    @Autowired
    private final SubListRepository subListRepository;
    @Autowired
    private final SubListService subListService;
    public RequestService(RequestRepo requestRepo, SubListRepository subListRepository, SubListService subListService) {
        this.requestRepo = requestRepo;
        this.subListRepository = subListRepository;
        this.subListService = subListService;
    }

    public List<RequestDto> getAllRequest(){
        // contains all response that are not accepted and declined
        List<RequestDto> responses = new ArrayList<>();

        for(RequestDto r: requestRepo.findAll()){
            if(r.getResponse() == null) {
                responses.add(r);
            }
        }
        return responses;
    }

    public String isRequestAccepted(Long request_id, boolean accepted){// i am sure that request cannot be null
        RequestDto request = requestRepo.findById(request_id).orElse(null);
        assert(request!=null);
        request.setResponse(accepted);
        if(request.getResponse()){
            /*on front-end, where the list is uploaded, if response get false
            will be deleted on FE list but not in back-end, after reloading automatically
            get all request (line 27) doesn't upload the request with false response
             and that request are stored in DB and never gaven again
            * */
            subListService.addSub(request);
            this.deleteRequest(request_id);
            return "accepted";
        }
        requestRepo.save(request);
        return "not accepted " + request.getResponse();
    }
    public RequestDto createRequest(RequestDto requestDto){
        requestDto.setDate(new Date());
        return requestRepo.save(requestDto);
    }
    public void deleteRequest(Long id){
        requestRepo.deleteById(id);
    }


}
