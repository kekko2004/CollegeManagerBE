package com.api.appeal.controller;

import com.api.appeal.entity.Appeal;
import com.api.appeal.service.AppealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v2/appeal")
public class AppealController {
    @Autowired
    private final AppealService appealService;

    public AppealController(AppealService appealService) {
        this.appealService = appealService;
    }

    @GetMapping
    public ResponseEntity<List<Appeal>> getAll(){
        return new ResponseEntity<>(appealService.getAll(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appeal> getById(@PathVariable Long id){
        return new ResponseEntity<>(appealService.getById(id), HttpStatus.FOUND);
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<List<Appeal>> getByCourse(@PathVariable Long id){
        return new ResponseEntity<>(appealService.getByCourse((long)id), HttpStatus.FOUND);
    }

    @GetMapping("/after/{date}")
    public ResponseEntity<List<Appeal>> getByDateAfter(@PathVariable String date){
        System.out.println(appealService.convertStringToDate(date));
        return new ResponseEntity<>(appealService.getAppealAfter(appealService.convertStringToDate(date)), HttpStatus.FOUND);
    }

    @GetMapping("/ended")
    public ResponseEntity<List<Appeal>> getEndedAppeal(){
        return new ResponseEntity<>(appealService.getEndedAppeal(), HttpStatus.FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<Appeal> create(@RequestBody Appeal appeal){
        return  new ResponseEntity<>(appealService.create(appeal), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Appeal> update(@RequestBody Appeal appeal,@PathVariable Long id){
        return new ResponseEntity<>(appealService.update(appeal, id), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        appealService.delete(id);
    }

}
