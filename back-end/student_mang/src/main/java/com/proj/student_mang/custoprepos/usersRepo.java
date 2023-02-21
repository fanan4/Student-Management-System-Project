package com.proj.student_mang.custoprepos;

import com.proj.student_mang.models.User;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface usersRepo extends MongoRepository<User , String> {
    @Override
    List<User> findAll();

    @Override
    <S extends User> S save(S entity);
}
