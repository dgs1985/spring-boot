package com.api.controllers;

import java.util.List;

import com.api.models.User;
import com.api.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;
     
    /*POST*/
    @PostMapping("/")
    public User postUser(@RequestBody User pUser) {
        return this.userService.post(pUser);        
    }

    /*PUT*/
    @PutMapping("/")
    public User putUser(@RequestBody User pUser){
        return this.userService.put(pUser);        
    }

    /*DELETE*/
    @DeleteMapping("/{id}")
    public Boolean deleteUser(@PathVariable("id") Long id) {
        return this.userService.delete(id);
    }       

    /*GET*/
    @GetMapping("/{id}")
    public User user(@PathVariable("id") Long id){
        return userService.getById(id);        
    }
    
    @GetMapping("/list")
    public List<User> listUsers(){
        return userService.list();
    }

    @GetMapping("/list/moreThan/{id}")
    public List<User> listMoreThan(@PathVariable("id") Long id){
        return this.userService.listMoreThan(id);
    }       

    @GetMapping("/list/greaterThan/{id}")
    public List<User> listGreaterThan(@PathVariable("id") Long id){
        return this.userService.listGreaterThan(id);
    }           

    @GetMapping("/list/byName/{name}")
    public List<User> listFindByName(@PathVariable("name") String name){
        return this.userService.listFindByName(name);
    }               

    @GetMapping("/list/byNameIgnoreCase/{name}")
    public List<User> listUsersFindByNameIgnoreCase(@PathVariable("name") String name){
        return this.userService.listFindByNameIgnoreCase(name);
    }                   
}
