package com.api.booklet.controller;

import com.api.booklet.entity.Booklet;
import com.api.booklet.service.BookletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/booklet")
public class BookletController {
    @Autowired
    private final BookletService bookletService;

    public BookletController(BookletService bookletService) {
        this.bookletService = bookletService;
    }

    @GetMapping("/student/{freshman}")
    public ResponseEntity<List<Booklet>> getBookletOfStudent(@PathVariable String freshman){
        return new ResponseEntity<>(bookletService.getBookletByStudent(freshman), HttpStatus.FOUND);
    }

    @GetMapping("/appeal/{appeal}")
    public ResponseEntity<List<Booklet>> getBookletByAppeal(@PathVariable Long appeal){
        return new ResponseEntity<>(bookletService.getByAppeal(appeal), HttpStatus.FOUND);
    }

    @PostMapping("/vote")
    public ResponseEntity<Booklet> giveVote(@RequestBody Booklet booklet){
        return new ResponseEntity<>(bookletService.createBooklet(booklet), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Booklet> updateVote(@RequestBody Booklet booklet, @PathVariable Long id){
        return new ResponseEntity<>(bookletService.updateBooklet(booklet, id) , HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBooklet(@PathVariable Long id){
        bookletService.deleteBooklet(id);
    }
}
