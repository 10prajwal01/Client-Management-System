package com.example.users.controller;

import com.example.users.model.Users;
import com.example.users.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Cross Origin --> It is used secure the information which is sent to the server..
@CrossOrigin(origins = "http://localhost:8081")

// To Make Sure that sprint will recognize this java code as the controller
@RestController

// Every Request has to be mapped from /api route only.. i.e. http://localhost:8081/api
@RequestMapping("/api")

public class UserController {
    // Controller should have a reference of the repository
    // AutoWired --> To INJECT THE OBJECT DEPENDENCY.
    @Autowired
    UsersRepository usersRepository;

    // POSTMapping is used to make this createUsers as a post request,
    // i.e. The route has to be http://localhost:8081/api/users

    // POST REQUEST
    @PostMapping("/users")

    public ResponseEntity<Users> createUsers(@RequestBody Users user) {
        try {
            Users _user = usersRepository.save(new Users(user.getUserName(), user.getUseremail(), user.isLoggedIn(), user.getPassword()));
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch(Exception err) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // GET REQUEST
    @GetMapping("/users")
    public ResponseEntity<List<Users>> getUsers() {
        try {
            List<Users> users = new ArrayList<>();
            usersRepository.findAll().forEach(users::add);
            return new ResponseEntity<>(users,HttpStatus.OK);
        } catch(Exception err) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // GET REQUEST BY ID
    @GetMapping("/users/{id}")
    public ResponseEntity<Users> getUsersByID(@PathVariable long id) {
        Optional<Users> userData = usersRepository.findById(id);
        if(userData.isPresent()) {
            return new ResponseEntity<>(userData.get(),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // UPDATE USER
    @PutMapping("/users/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable("id") long id,
                                            @RequestBody Users user) {
        Optional<Users> userData = usersRepository.findById(id);
        if(userData.isPresent()) {
            Users _user = userData.get();
            _user.setUserName(user.getUserName());
            _user.setUseremail(user.getUseremail());
            _user.setLoggedIn(user.isLoggedIn());
            _user.setPassword(user.getPassword());


            return new ResponseEntity<>(usersRepository.save(_user),HttpStatus.OK);
        }

        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE USER
    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable long id) {
//        Optional<Users> userData = usersRepository.findById(id);
//        if(userData.isPresent()) {
//            usersRepository.deleteById(id);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        try {
            usersRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch(Exception err) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
