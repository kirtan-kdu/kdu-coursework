package com.kdu.smarthome.controllers;


import com.kdu.smarthome.dto.request.LoginRequestDTO;
import com.kdu.smarthome.dto.response.AuthResponseDTO;
import com.kdu.smarthome.security.TokenGeneratorFilter;
import com.kdu.smarthome.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final TokenGeneratorFilter tokenGeneratorFilter;

    private final UserService userService;

    @Autowired
    public AuthController(TokenGeneratorFilter tokenGeneratorFilter, UserService userService) {
        this.tokenGeneratorFilter = tokenGeneratorFilter;
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> registerUser(@RequestHeader(required = false) String jwtToken, @RequestBody LoginRequestDTO loginRequestDTO){
        userService.addUser(loginRequestDTO);
        String token = tokenGeneratorFilter.generateJWT(loginRequestDTO.getUsername());
        return ResponseEntity.ok(new AuthResponseDTO(token, "Successfully registered user"));
    }

}
