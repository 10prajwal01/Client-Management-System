package com.example.admin.controller;

import java.util.*;
import com.example.admin.model.Admin;
import com.example.admin.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/s1")
public class AdminController {
    @Autowired
    AdminRepository adminRepository;
    @PostMapping("/admin")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin){
    try{
        Admin _admin = adminRepository.save(new Admin(admin.getAdmin_id(), admin.getAdmin_name(), admin.getAdmin_password()));
        return new ResponseEntity<>(_admin, HttpStatus.CREATED);
    }catch (Exception ex){
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }

    @GetMapping("/admin")
    public ResponseEntity<List<Admin>> getAdmin(){
        try{
            List<Admin> admin = new ArrayList<Admin>();
            adminRepository.findAll().forEach(admin::add);
            return new ResponseEntity<>(admin,HttpStatus.OK);
        } catch(Exception ex){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<Admin> getUsersByID(@PathVariable long id){
        Optional<Admin> adminData = adminRepository.findById(id);
        if(adminData.isPresent()){
            return new ResponseEntity<>(adminData.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/admin/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable("id") long id, @RequestBody Admin admin){
        Optional<Admin> adminData = adminRepository.findById(id);
        if(adminData.isPresent()){
            Admin _admin = adminData.get();
            _admin.setAdmin_name(admin.getAdmin_name());
            _admin.setAdmin_password(admin.getAdmin_password());
            return new ResponseEntity<>(adminRepository.save(_admin), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<HttpStatus> deleteAdmin(@PathVariable("id") long id){
        try{
            adminRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
