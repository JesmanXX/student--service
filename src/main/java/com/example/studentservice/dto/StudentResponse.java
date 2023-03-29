package com.example.studentservice.dto;

import lombok.Data;

@Data
public class StudentResponse {

    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Integer age;

}
