package com.api.services;

import java.util.List;
import java.util.Optional;

import com.api.models.User;
import com.api.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getById(Long id){
        Optional<User> userFind = this.userRepository.findById(id);
        if (userFind.isPresent()){
            return userFind.get();
        }
        return null;
    }
    
    public List<User> list(){
        return this.userRepository.findAll();
    }

    public List<User> listMoreThan(Long id){
        return this.userRepository.findAllMoreThan(id);
    }       
    
    public List<User> listGreaterThan(Long id){
        return this.userRepository.findByIdGreaterThan(id);
    }           
    
    public List<User> listFindByName(String name){
        return this.userRepository.findByName(name);
    }               

    public List<User> listFindByNameIgnoreCase(String name){
        return this.userRepository.findByNameIgnoreCase(name);
    }                   
    
    public User post(User pUser) {
        return this.userRepository.save(pUser);        
    }

    public Boolean delete(Long id) {
        Optional<User> vUser = this.userRepository.findById(id);
        if (vUser.isPresent()){            
            this.userRepository.delete(vUser.get());
            return true;
        }    
        return false;
    }    
    
    public User put(User pUser){
        Optional<User> vUserExistente = this.userRepository.findById(pUser.getId());

        if (vUserExistente.isPresent()){
           return this.userRepository.save(pUser);
        }
        return null;   
    }    
}
