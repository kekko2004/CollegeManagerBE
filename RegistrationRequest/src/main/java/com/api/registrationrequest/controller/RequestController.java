package com.api.registrationrequest.controller;

import com.api.registrationrequest.Entity.RequestDto;
import com.api.registrationrequest.Entity.SubList;
import com.api.registrationrequest.Entity.SubListDto;
import com.api.registrationrequest.service.RequestService;
import com.api.registrationrequest.service.SubListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/request")
public class RequestController {
    @Autowired
    private final RequestService requestService;
    @Autowired
    private final SubListService subListService;
    public RequestController(RequestService requestService, SubListService subListService) {
        this.requestService = requestService;
        this.subListService = subListService;
    }

    @GetMapping
    public ResponseEntity<List<RequestDto>> getRequests(){
        return new ResponseEntity<>(requestService.getAllRequest(), HttpStatus.FOUND);
    }

    //accepted is the func that switch the request in: subscription List or delete it
    @GetMapping("/{request}/accepted={isAccepted}")
    public ResponseEntity<String> isRequestAccepted(@PathVariable Long request, @PathVariable boolean isAccepted){

        return new ResponseEntity<>(requestService.isRequestAccepted(request, isAccepted), HttpStatus.OK);
    }
    @GetMapping("/courseID/{course}")
    public ResponseEntity<List<SubList>> getByCourse(@PathVariable Long course){
        return new ResponseEntity<>(subListService.getListByCourse(course), HttpStatus.FOUND);
    }
    @GetMapping("/freshman/{freshman}")
    public ResponseEntity<List<SubList>> getByStudent(@PathVariable String freshman){
        return new ResponseEntity<>(subListService.getListByStudent(freshman), HttpStatus.FOUND);
    }
    @PostMapping("/send")
    public ResponseEntity<RequestDto> sendRequest(@RequestBody RequestDto requestDto){
        return new ResponseEntity<>(requestService.createRequest(requestDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteSubscription(@PathVariable Long id){
        subListService.removeFromList(id);
    }



}
