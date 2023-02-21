package com.proj.student_mang.custoprepos;

import com.proj.student_mang.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface usersRepo extends MongoRepository<User , String> {

}
