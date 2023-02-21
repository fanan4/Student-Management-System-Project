package com.proj.student_mang.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document("users")

public class User {
    @Id
    private String id  ;
    @Field
    private String firstName ;
    @Field
    private String lastName;
    @Field
    private String email ;
    @Field
        private String pic ;
    @Field
        private String desc;

}
