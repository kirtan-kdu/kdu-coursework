package com.kdu.homeworkten.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String name;
    private String userName;
    private String password;
    private String role;

}
