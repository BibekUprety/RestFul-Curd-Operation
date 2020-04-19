package com.spring.springRestFulWebServiceCurdOperation.Controller;

import com.spring.springRestFulWebServiceCurdOperation.Dao.UserDao;
import com.spring.springRestFulWebServiceCurdOperation.Exception.ResourceNotFoundException;
import com.spring.springRestFulWebServiceCurdOperation.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/api")
public class UserController {

    @Autowired
    private UserDao userDao;
//get all users
    @GetMapping
    public List<User> getAllUser(){
        return this.userDao.findAll();

    }
    //get the user by id
    @GetMapping("/{id}")
    public User getUserId(@PathVariable(value = "id") long id){
      return this.userDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("UserId not found"+ id));

    }
    //Create user
    @PostMapping
    public User createUser(@RequestBody User user){
        return this.userDao.save(user);
    }
    //Update user
    @PutMapping("/{id}")
    public User updateUser(@PathVariable(value = "id") long id, @RequestBody User user){
        User user1 =  this.userDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("UserId not found"+ id));
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        return this.userDao.save(user1);
    }
    //Delete the user
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(value = "id") long id){
        User user1 =  this.userDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("UserId not found"+ id));
         this.userDao.delete(user1);
         return ResponseEntity.ok().build();
    }

}
