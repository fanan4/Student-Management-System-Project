package com.proj.student_mang.controllers.hamzasControllers;

import com.proj.student_mang.custoprepos.usersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
public class hamzasCont {

    private usersRepo repo ;
    @Autowired
    public hamzasCont(usersRepo repo){
        this.repo = repo ;
    }
                @DeleteMapping("/deleteusre/{id}")
                @ResponseStatus
        public void deleteUser(@PathVariable String id){
try{
    repo.deleteById(id);
}catch (Exception e){
    e.printStackTrace();
}
    }
}
