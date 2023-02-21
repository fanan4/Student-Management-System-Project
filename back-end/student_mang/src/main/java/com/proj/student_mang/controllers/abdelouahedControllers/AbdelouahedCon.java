package com.proj.student_mang.controllers.abdelouahedControllers;


import com.proj.student_mang.custoprepos.usersRepo;
import com.proj.student_mang.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AbdelouahedCon {
    @Autowired
    usersRepo  repo;
    @GetMapping("/getUsers")
    List<User> getUsers(){ return repo.findAll() ;}
    @PutMapping("/addUser")
    User addUser(@RequestBody User user){
       return repo.save(user);
    }

}
