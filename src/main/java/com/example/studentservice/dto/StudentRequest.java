package com.example.studentservice.dto;

import lombok.Data;

@Data
public class StudentRequest {

    private final String username;
    private final String email;
    private final String password;
    private final String firstName;
    private final String lastName;
    private final Integer age;

}
