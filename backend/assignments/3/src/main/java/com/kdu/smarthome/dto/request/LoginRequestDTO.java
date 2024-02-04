package com.kdu.smarthome.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class LoginRequestDTO {
    private String username;

    private String password;

    private String name;

    private String firstName;

    private String lastName;

    private String emailId;
}
