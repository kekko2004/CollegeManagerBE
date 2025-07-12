package com.api.usercollege.controller;

import com.api.usercollege.model.User;
import com.api.usercollege.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//non esiste una versione di codice v1, ma semplicemente si è partiti dalla versione 2 della progettazione db
public abstract class UserController<T extends User> {
    @Autowired
    private final UserService<T> userService;

    public UserController(UserService<T> userService) {
        this.userService = userService;
    }

    @GetMapping("/freshman/{freshman}")
    public ResponseEntity<Optional<T>> getUserById(@PathVariable String freshman){
        return new ResponseEntity<>(userService.findByFreshman(freshman), HttpStatus.FOUND);
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<Optional<T>> getUserByEmail(@PathVariable String email){
        return new ResponseEntity<>(userService.findByEmail(email), HttpStatus.FOUND);
    }
    @GetMapping
    public ResponseEntity<List<T>> getUsers(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.FOUND);
    }


    @PutMapping("/update/{freshman}")
    public ResponseEntity<T> updateUser(@PathVariable String freshman,@RequestBody T user){
        return new ResponseEntity<>(userService.updateUser(freshman,user), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{freshman}")
    public void deleteUser(@PathVariable String freshman) {
        userService.deleteUser(freshman);
    }
}
